package com.ExpenseApi.controllers;


import com.ExpenseApi.models.UploadPdf;
import com.ExpenseApi.service.ExpenseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.validation.Valid;


@Controller
@RestController
@RequestMapping("/upload")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    @Autowired
    public ObjectMapper mapper;


   //TO upload expense pdf and other details  : localhost:8080/upload/expense
   @PostMapping("/expense")
   public ResponseEntity<String> expenseUpload(@Valid @RequestParam("file") MultipartFile file, @RequestParam("details") String expense, @ModelAttribute("user") UploadPdf data,BindingResult result ) throws IOException {


//Validation
       if (result.hasErrors()) {
           // Handle validation errors
           return ResponseEntity.badRequest().body("Validation Error: " + result.getFieldError().getDefaultMessage());
       }


       // Check if the uploaded file is a PDF
       if (!file.getContentType().equals("application/pdf") || !file.getOriginalFilename().toLowerCase().endsWith(".pdf")) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid File Format. Only PDF files are allowed.");
       }


       try {
           data = mapper.readValue(expense, UploadPdf.class);
       } catch (JsonProcessingException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
       }

       // Set the PDF name to match the uploaded file's name
       data.setPdf(file.getOriginalFilename());

       // Save the PDF file to the /static/pdf directory
       try {
           File pdfDir = new ClassPathResource("/static/Pdf").getFile();
           Path path = Paths.get(pdfDir.getAbsolutePath() + File.separator + file.getOriginalFilename());
           Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
       } catch (IOException e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Saving PDF");
       }

       // Now, save the UploadPdf entity
       expenseService.addExpense(data);

       return ResponseEntity.ok("Expense Uploaded Successfully");
   }


}

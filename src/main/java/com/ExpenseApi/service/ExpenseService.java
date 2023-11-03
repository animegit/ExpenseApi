package com.ExpenseApi.service;

import com.ExpenseApi.models.UploadPdf;
import com.ExpenseApi.repositories.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;


    //To upload pdf and other details
    public void addExpense(UploadPdf expense) {
        expenseRepo.save(expense);
    }
}

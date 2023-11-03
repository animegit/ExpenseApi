package com.ExpenseApi.repositories;

import com.ExpenseApi.models.UploadPdf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<UploadPdf,Long> {

}

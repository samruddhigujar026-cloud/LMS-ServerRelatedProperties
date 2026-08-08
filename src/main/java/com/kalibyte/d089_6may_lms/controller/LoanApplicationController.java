package com.kalibyte.d089_6may_lms.controller;

import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.LoanInfo;
import com.kalibyte.d089_6may_lms.service.LoanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans/api")
public class LoanApplicationController
{
    private final static Logger LOGGER = LogManager.getLogger(LoanApplicationController.class);

    @Autowired
    private LoanService loanService;

    @PostMapping(value = "/save")
    public ResponseEntity<UserResponse> createLoan(@RequestBody LoanInfo loanInfo)
    {
        LOGGER.info("===== LoanController createLoan START =====");
        LOGGER.debug("Incoming LoanInfoPojo: {}", loanInfo);

        UserResponse response = loanService.saveLoanInfo(loanInfo);

        if ("Loan Pojo Data inserted successfully.".equals(response.getMsg())) {
            LOGGER.info("Loan created successfully for borrower: {}", loanInfo.getLoanApplierName());
            LOGGER.info("===== LoanController createLoan END =====");
            return ResponseEntity.ok(response);
        } else {
            LOGGER.warn("Loan creation failed: {}", response.getMsg());
            LOGGER.info("===== LoanController createLoan END =====");
            return ResponseEntity.badRequest().body(response);
        }
    }




}

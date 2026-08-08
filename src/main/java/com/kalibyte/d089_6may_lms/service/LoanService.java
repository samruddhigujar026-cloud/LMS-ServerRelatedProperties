package com.kalibyte.d089_6may_lms.service;


import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.LoanInfo;

public interface LoanService
{
    UserResponse saveLoanInfo(LoanInfo loanInfo);
}

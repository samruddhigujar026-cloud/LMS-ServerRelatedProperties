package com.kalibyte.d089_6may_lms.service;

import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.LoanMaster;

import java.util.List;

public interface LoanMasterService
{
    UserResponse insertRoleMasterData(LoanMaster loanMaster);

    List<LoanMaster> findAll();

    List<String> fetchAllLoanNames();

    LoanMaster fetchLoanMasterByLoanName(String loanName);



}


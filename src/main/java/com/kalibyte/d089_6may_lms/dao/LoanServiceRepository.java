package com.kalibyte.d089_6may_lms.dao;

import com.kalibyte.d089_6may_lms.entity.LoanInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanServiceRepository extends JpaRepository<LoanInfo, Integer>
{
    LoanInfo findByLoanId(Long loanId);

}

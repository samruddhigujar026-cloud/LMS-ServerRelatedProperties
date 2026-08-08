package com.kalibyte.d089_6may_lms.dao;

import com.kalibyte.d089_6may_lms.entity.LoanMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanMasterRepository extends JpaRepository<LoanMaster,Integer>
{
    LoanMaster findByLoanName(String loanName);

    @Query(value = "select loanName from loanMaster" , nativeQuery = true)
    List<String> findAllLoanNames();


}

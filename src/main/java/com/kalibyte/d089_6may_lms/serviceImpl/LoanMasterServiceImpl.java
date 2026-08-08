package com.kalibyte.d089_6may_lms.serviceImpl;

import com.kalibyte.d089_6may_lms.controller.LoanMasterController;
import com.kalibyte.d089_6may_lms.dao.LoanMasterRepository;
import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.LoanMaster;
import com.kalibyte.d089_6may_lms.entity.RoleData;
import com.kalibyte.d089_6may_lms.service.LoanMasterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LoanMasterServiceImpl implements LoanMasterService
{
    private final static Logger LOGGER = LogManager.getLogger(LoanMasterServiceImpl.class);

    @Autowired
    private LoanMasterRepository loanMasterRepository;

    @Override
    public UserResponse insertRoleMasterData(LoanMaster loanMaster)
    {
        LOGGER.info("======== LoanMasterServiceImpl data insertion start =============");
        UserResponse userResponse = new UserResponse();
        LoanMaster loan = loanMasterRepository.findByLoanName(loanMaster.getLoanName());
        if(loan == null)
        {
            loanMasterRepository.save(loanMaster);
            userResponse.setMsg("Loan Master Data Successfully Inserted!...");
            return  userResponse;
        }
        userResponse.setMsg("Already LoanMaster Data Exist!...");
        LOGGER.info("======== LoanMasterServiceImpl data insertion end =============");
        return userResponse;
    }

    @Override
    public List<LoanMaster> findAll()
    {
        LOGGER.info("======== LoanMasterServiceImpl all data fetching start =============");
        List<LoanMaster> loanList = loanMasterRepository.findAll();
        LOGGER.info("======== LoanMasterServiceImpl all data fetching end =============");
        return loanList;
    }

    @Override
    public List<String> fetchAllLoanNames()
    {
        LOGGER.info("======== LoanMasterServiceImpl all loanNames fetching start =============");
        List<String> loanNameList = loanMasterRepository.findAllLoanNames();
        LOGGER.info("======== LoanMasterServiceImpl all loanNames fetching end =============");
        return loanNameList;
    }

    @Override
    public LoanMaster fetchLoanMasterByLoanName(String loanName)
    {
        LOGGER.info("======== LoanMasterServiceImpl single loanNames fetching start =============");
        LoanMaster loan = null;
        try {
            if(loanName == null || loanName.trim().isEmpty())
            {
                LOGGER.warn("Loan Name provided is null or empty");
                return null;
            }
            loan = loanMasterRepository.findByLoanName(loanName);
            if(loan == null)
                {
                LOGGER.warn("No LoanMaster found for loanName : {}" , loanName);
                }
        }catch (NullPointerException npe)
        {
            LOGGER.error("Nullpointer Exception occured while fetching LoanMaster for loanName : {}", loanName);
        }catch (Exception ex)
        {
            LOGGER.error("Unexpected Exception occured while fetching LoanMaster for loanName : {}", loanName);
        }finally {
            LOGGER.info("======== LoanMasterServiceImpl single loanNames fetching end =============");
        }
        return loan;
    }

}

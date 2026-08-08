package com.kalibyte.d089_6may_lms.serviceImpl;

import com.kalibyte.d089_6may_lms.dao.LoanServiceRepository;
import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.LoanInfo;
import com.kalibyte.d089_6may_lms.service.LoanService;
import com.kalibyte.d089_6may_lms.util.UserIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService
{
    private final static Logger LOGGER = LogManager.getLogger(LoanServiceImpl.class);

    @Autowired
    private LoanServiceRepository  loanServiceRepository;

    @Override
    public UserResponse saveLoanInfo(LoanInfo loanInfo)
    {
        LOGGER.info("===== LoanService saveLoanInfo START =====");
        UserResponse userResponse = new UserResponse();

        if (loanInfo != null) {
            Long id;
            LoanInfo existing;

            do {
                LOGGER.info("Generating Loan Application ID...");
                id = UserIdGenerator.generateLoanApplicationRandomId();
                existing = loanServiceRepository.findByLoanId(id);
            } while (existing != null);

            loanInfo.setLoanId(id);
            loanServiceRepository.save(loanInfo);

            userResponse.setMsg("Loan Pojo Data inserted successfully.");
            LOGGER.info("Insertion of LoanInfo with LoanId: " + id);

        } else {
            userResponse.setMsg("Loan Pojo is null, cannot insert.");
            LOGGER.warn("LoanInfo was null.");
        }

        LOGGER.info("===== LoanService saveLoanInfo END =====");
        return userResponse;

    }
}

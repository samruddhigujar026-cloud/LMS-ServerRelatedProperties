package com.kalibyte.d089_6may_lms.controller;

import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.LoanMaster;
import com.kalibyte.d089_6may_lms.service.LoanMasterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/loan")
public class LoanMasterController
{
    private final static Logger LOGGER = LogManager.getLogger(LoanMasterController.class);

    @Autowired
    private LoanMasterService loanMasterService;

    @PostMapping(value = "/insert")
    public ResponseEntity<UserResponse> insertLoanMaterData(@RequestBody LoanMaster loanMaster)
    {
        LOGGER.info("========= LoanMaster Controller Insert start =============");
        UserResponse userResponse = loanMasterService.insertRoleMasterData(loanMaster);
        LOGGER.info("========= LoanMaster Controller Insert end =============");
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<LoanMaster>> findAllLoanMasterData()
    {
        LOGGER.info("========= LoanMaster Controller FindAll start =============");
        List<LoanMaster> list = loanMasterService.findAll();
        LOGGER.info("========= LoanMaster Controller FindAll end =============");
        return new ResponseEntity<List<LoanMaster>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/allLoanName")
    public ResponseEntity<List<String>> fetchAllLoanMasterData() {
        LOGGER.info("===================== LoanMaster Controller fetch all LoanName Start =====================");

        try {
            List<String> listNames = loanMasterService.fetchAllLoanNames();

            if (listNames == null || listNames.isEmpty()) {
                LOGGER.warn("No loan names found in LoanMaster");
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listNames);
            }

            LOGGER.info("===================== LoanMaster Controller fetch all LoanName End =====================");
            return ResponseEntity.ok(listNames);

        } catch (NullPointerException npe) {
            LOGGER.error("NullPointerException occurred while fetching all loan names", npe);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());

        } catch (Exception ex) {
            LOGGER.error("Unexpected error occurred while fetching all loan names", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }

    @GetMapping("/{loanName}")
    public ResponseEntity<?> getLoanByName(@PathVariable("loanName") String loanName)
    {
        LOGGER.info("Received request to fetch LoanMaster for loanName : {}", loanName);
        try{
            LoanMaster loan = loanMasterService.fetchLoanMasterByLoanName(loanName);
            if(loan == null)
            {
                LOGGER.warn("LoanMaster not found for loanName : {}", loanName);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("LoanMaster not found for loanName : " + loanName);
            }
            return ResponseEntity.ok(loan);
        }catch (NullPointerException npe)
        {
            LOGGER.error("NullPointerException occurred while fetching LoanMaster",npe);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid Request : loanName or Repository returned null");
        } catch (Exception ex) {
            LOGGER.error("Unexpected error occurred while fetching LoanMaster",ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred. Please try again later");
        }
    }




}

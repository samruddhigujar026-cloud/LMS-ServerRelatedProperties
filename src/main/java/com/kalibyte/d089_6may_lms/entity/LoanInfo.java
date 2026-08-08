package com.kalibyte.d089_6may_lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LoanInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long loanId;
    private String loanApplierName;
    private String dateOfBirth;
    private String email;
    private String companyEmail;
    private String contactNumber;
    private String aadharNumber;
    private String panNumber;
    private String gender;
    private String permanentAddress;
    private String currentAddress;
    private String companyAddress;
    private String employeeNumber;
    private String empType;
    private String designation;
    private String occupation;
    private String companyName;
    private String monthlySalary;
    private String existingEmi;
    private String reqLoanAmount;
    private String guarantorOne;
    private String guarantorTwo;
    private String guarantorOneContact;
    private String guarantorTwoContact;
    private int tenure;
    private Double interestRate;
    private String createdDate;
    private String createdBy;
    private String updatedBy;
    private String updatedDate;

}

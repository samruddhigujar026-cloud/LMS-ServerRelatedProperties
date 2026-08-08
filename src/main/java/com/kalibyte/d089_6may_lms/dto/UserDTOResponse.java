package com.kalibyte.d089_6may_lms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOResponse
{
    private int userId;
    private  String userGenId;
    private String fname;
    private String lname;
    private String email;
    private String contactNo;
    private String uname;
    private String password;
    private String errorMsg;
}

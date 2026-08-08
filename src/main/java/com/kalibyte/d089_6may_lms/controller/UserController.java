package com.kalibyte.d089_6may_lms.controller;

import com.kalibyte.d089_6may_lms.dto.UserDTOResponse;
import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.User;
import com.kalibyte.d089_6may_lms.service.UserDetailsService;
import com.kalibyte.d089_6may_lms.serviceImpl.UserDetailsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user/api/")
public class UserController
{
    private final static Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> registerUserDetails(@RequestBody User user)
    {
        LOGGER.info("================ User Controller data insertion start =================");
        ResponseEntity<UserResponse> response = userDetailsService.registerUserData(user);
        LOGGER.info("================ User Controller data insertion end =================");
        return response;
    }

    @GetMapping(value = "/get/{uname}")
    public ResponseEntity<UserDTOResponse> fetchUserDetailsUsingUsername(@PathVariable("uname") String uname)
    {
        LOGGER.info("================ User Controller data fetching start =================");
        UserDTOResponse response = userDetailsService.findUserByUsername(uname);
        LOGGER.info("================ User Controller data fetching end =================");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

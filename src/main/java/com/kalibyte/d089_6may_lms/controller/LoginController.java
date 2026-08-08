package com.kalibyte.d089_6may_lms.controller;

import com.kalibyte.d089_6may_lms.dto.Login;
import com.kalibyte.d089_6may_lms.entity.User;
import com.kalibyte.d089_6may_lms.service.LoginService;
import com.kalibyte.d089_6may_lms.serviceImpl.LoginServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api/")
public class LoginController
{
    private final static Logger LOGGER = LogManager.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> dologin(@RequestBody Login login)
    {
        LOGGER.info("=====================User Login Controller start============");
        User user = loginService.dologin(login);
        if (user != null)
        {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        LOGGER.info("=====================User Login Controller end============");
        throw new RuntimeException("Invalid Username And Password Controller..");


    }
}

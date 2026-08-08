package com.kalibyte.d089_6may_lms.serviceImpl;

import com.kalibyte.d089_6may_lms.dao.UserDao;
import com.kalibyte.d089_6may_lms.dto.Login;
import com.kalibyte.d089_6may_lms.entity.User;
import com.kalibyte.d089_6may_lms.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService
{
    private final static Logger LOGGER = LogManager.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User dologin(Login login)
    {
        LOGGER.info("===================User Login Start===================");
        if(login != null)
        {
            if((login.getUname() != "" && login.getPassword() != "") && (login.getUname() != null && login.getPassword() != null))
            {
             User user = userDao.findByUnameOrEmailAndPasswordAndStatus(login.getUname(),login.getUname(),login.getPassword(),true);
             if(user.getRoleData().getRoleName() != null)
             {
                 return user;
             }
             else {
                 LOGGER.info("Role Not assigned..Please contact your administrator");
             }
            }
        }else{
            LOGGER.error("Login Error..Please enter/provide username and password");
            throw new RuntimeException("Please enter/provide username and password");
        }
        LOGGER.error("Invalid Username And Password..");
        LOGGER.info("===================User Login End===================");
        throw new RuntimeException("Invalid Username And Password..");
    }
}

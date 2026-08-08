package com.kalibyte.d089_6may_lms.serviceImpl;

import com.kalibyte.d089_6may_lms.dao.UserDao;
import com.kalibyte.d089_6may_lms.dto.UserDTOResponse;
import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.User;
import com.kalibyte.d089_6may_lms.service.UserDetailsService;
import com.kalibyte.d089_6may_lms.util.UserIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserDao userDao;

    private final static Logger LOGGER = LogManager.getLogger(UserDetailsServiceImpl.class);

    @Override
    public ResponseEntity<UserResponse> registerUserData(User user)
    {

        LOGGER.info("================ User Service data insertion start =================");

        UserResponse userResponse = new UserResponse();
        user.setStatus(true);

        LOGGER.info("================ User Random ID generation start =================");
        String userGenId = UserIdGenerator.generateRandomIdForUserID();
        user.setUserGenId(userGenId);
        LOGGER.info("================ User Random ID generation end =================");

        User user1 = userDao.save(user);
        if (user1 != null)
        {
           userResponse.setMsg(user1.getFname() + " " + user1.getLname() + ", Thanks for Successfully Registrations");
            return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
        }

        LOGGER.info("================ User Service data insertion end =================");
        userResponse.setMsg("User is unable to register!!");
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.NO_CONTENT);

    }

    @Override
    public UserDTOResponse findUserByUsername(String uname)
    {
        LOGGER.info("================ User Service data fetch by uname start =================");
        User user = userDao.findByUname(uname);
        UserDTOResponse userDTOResponse = new UserDTOResponse();

        if(!ObjectUtils.isEmpty(user))
        {
            return user.userToUserDTO(user);
        }
        LOGGER.info("================ User Service data fetch by uname end=================");
        userDTOResponse.setErrorMsg("User is unable to find!!");

        return userDTOResponse;
    }
}

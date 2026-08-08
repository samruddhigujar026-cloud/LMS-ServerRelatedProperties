package com.kalibyte.d089_6may_lms.serviceImpl;

import com.kalibyte.d089_6may_lms.controller.LoginController;
import com.kalibyte.d089_6may_lms.dao.RoleRepository;
import com.kalibyte.d089_6may_lms.dao.UserDao;
import com.kalibyte.d089_6may_lms.dto.RoleAssign;
import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.RoleData;
import com.kalibyte.d089_6may_lms.entity.User;
import com.kalibyte.d089_6may_lms.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService
{
    private final static Logger LOGGER = LogManager.getLogger(AdminServiceImpl.class);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDao userDao;

    @Override
    public UserResponse addRoleInfoByAdmin(RoleData roleData)
    {
        LOGGER.info("======== AdminServiceImpl addRoleInfoByAdmin data insertion start =============");
        UserResponse userResponse = new UserResponse();
        RoleData role = roleRepository.findByRoleName(roleData.getRoleName());
        if(role == null)
        {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            String strDate = dateFormat.format(date);
            roleData.setCreatedDate(strDate);
            roleRepository.save(roleData);
            userResponse.setMsg(roleData.getRoleName() +" Role Data Successfully Inserted!...");
            return  userResponse;
        }
        userResponse.setMsg("Already Role Data Exist!...");
        LOGGER.info("======== AdminServiceImpl addRoleInfoByAdmin data insertion end =============");
        return userResponse;
    }

    @Override
    public List<String> getAllUsernames()
    {
        LOGGER.info("======== AdminServiceImpl Usernames fetching start =============");
        List<String> listUsernames = userDao.getAllUsernames();
        LOGGER.info("======== AdminServiceImpl Usernames fetching end =============");
        return listUsernames;
    }

    @Override
    public List<String> getAllRolenames()
    {
        LOGGER.info("======== AdminServiceImpl Rolenames fetching start =============");
        List<String> rolenames = roleRepository.getAllRolenames();
        LOGGER.info("======== AdminServiceImpl Rolenames fetching end =============");
        return rolenames;
    }

    @Override
    public UserResponse assignRoleInfoByAdmin(RoleAssign roleAssign)
    {
        LOGGER.info("======== AdminServiceImpl Rolenames assigning start =============");
        UserResponse userResponse = new UserResponse();
        User user = userDao.findByUname(roleAssign.getUname());
        if(user != null)
        {
            LOGGER.info("======== AdminServiceImpl user info : - " + user);
            RoleData roleData = roleRepository.findByRoleName(roleAssign.getRolename());
            if(roleData != null)
            {
                LOGGER.info("======== AdminServiceImpl Role info : - " + roleData);
                user.setRoleData(roleData);
                userDao.save(user);
                LOGGER.info("======== AdminServiceImpl Role successfully Assigned! =============");
                LOGGER.info("======== AdminServiceImpl Rolenames assigning end =============");
                userResponse.setMsg("Role Assigned successfully!");
                return userResponse;
            }
            else {
                LOGGER.info("======== AdminServiceImpl Rolenames assigning end =============");
                userResponse.setMsg("Role does not exists!");
                return userResponse;
            }
        }
        else{
            LOGGER.info("======== AdminServiceImpl Rolenames assigning end =============");
            userResponse.setMsg("User does not exists!");
            return userResponse;
        }
    }
}

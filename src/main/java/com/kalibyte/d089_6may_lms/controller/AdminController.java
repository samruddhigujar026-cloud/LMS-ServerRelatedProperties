package com.kalibyte.d089_6may_lms.controller;

import com.kalibyte.d089_6may_lms.dto.RoleAssign;
import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.RoleData;
import com.kalibyte.d089_6may_lms.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/api/")
public class AdminController
{
    private final static Logger LOGGER = LogManager.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/addRole")
    public ResponseEntity<UserResponse> addRoleInfoByAdmin(@RequestBody RoleData roleData)
    {
        LOGGER.info("========= Admin Controller addRoleInfoByAdmin data insertion start =============");
        UserResponse userResponse= adminService.addRoleInfoByAdmin(roleData);
        LOGGER.info("========= Admin Controller addRoleInfoByAdmin data insertion end =============");
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/findAllUname")
    public ResponseEntity<List<String>> getAllUnames()
    {
        LOGGER.info("========= Admin Controller AllUsername fetching start =============");
        List<String> listUsernames = adminService.getAllUsernames();
        LOGGER.info("========= Admin Controller AllUsername fetching end =============");
        return new ResponseEntity<List<String>>(listUsernames, HttpStatus.OK);
    }

    @GetMapping(value = "/findAllRolename")
    public ResponseEntity<List<String>> getAllRolenames()
    {
        LOGGER.info("========= Admin Controller All Rolenames fetching start =============");
        List<String> rolenames = adminService.getAllRolenames();
        LOGGER.info("========= Admin Controller All Rolenames fetching end =============");
        return new ResponseEntity<List<String>>(rolenames, HttpStatus.OK);
    }

    @PostMapping(value = "/roleAssign")
    public ResponseEntity<UserResponse> assignRoleInfoByAdmin(@RequestBody RoleAssign roleAssign)
    {
        LOGGER.info("========= Admin Controller Role Assign start =============");
        UserResponse userResponse= adminService.assignRoleInfoByAdmin(roleAssign);
        LOGGER.info("========= Admin Controller  Role Assign end =============");
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

}

package com.kalibyte.d089_6may_lms.service;

import com.kalibyte.d089_6may_lms.dto.RoleAssign;
import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.RoleData;

import java.util.List;

public interface AdminService
{
    UserResponse addRoleInfoByAdmin(RoleData roleData);

    List<String> getAllUsernames();

    List<String> getAllRolenames();

    UserResponse assignRoleInfoByAdmin(RoleAssign roleAssign);
}

package com.kalibyte.d089_6may_lms.service;

import com.kalibyte.d089_6may_lms.dto.UserDTOResponse;
import com.kalibyte.d089_6may_lms.dto.UserResponse;
import com.kalibyte.d089_6may_lms.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserDetailsService
{
    public ResponseEntity<UserResponse> registerUserData(User user);

    UserDTOResponse findUserByUsername(String username);
}

package com.kalibyte.d089_6may_lms.service;

import com.kalibyte.d089_6may_lms.dto.Login;
import com.kalibyte.d089_6may_lms.entity.User;

public interface LoginService
{
    User dologin(Login login);
}

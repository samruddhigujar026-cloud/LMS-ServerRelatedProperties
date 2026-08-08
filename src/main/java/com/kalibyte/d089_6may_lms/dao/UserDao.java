package com.kalibyte.d089_6may_lms.dao;

import com.kalibyte.d089_6may_lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer>
{
    User findByUname(String uname);

    User findByUnameOrEmailAndPasswordAndStatus(String  uname, String email, String password,boolean status);

    @Query(value = "select uname from app_user", nativeQuery = true)
    List<String> getAllUsernames();
}

package com.kalibyte.d089_6may_lms.dao;

import com.kalibyte.d089_6may_lms.entity.RoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleData, Integer>
{
    RoleData findByRoleName(String roleName);

    @Query(value = "select roleName from RoleData", nativeQuery = true)
    List<String> getAllRolenames();
}

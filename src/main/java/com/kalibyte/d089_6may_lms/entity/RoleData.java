package com.kalibyte.d089_6may_lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RoleData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int roleId;
    private String roleName;
    private String description;
    private String createdBy;
    private String createdDate;
    private String updatedBy;
    private String updatedDate;
}

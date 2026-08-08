package com.kalibyte.d089_6may_lms.entity;

import com.kalibyte.d089_6may_lms.dto.UserDTOResponse;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.type.YesNoConverter;

@Entity
@Data
@Table(name = "app_user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private  String userGenId;

    private String fname;
    private String lname;
    private String email;
    private String contactNo;
    private String uname;
    private String password;

//    @OneToOne(cascade = CascadeType.ALL)
//    private RoleData roleData;

    @ManyToOne
    @JoinColumn(name = "role_data_id")
    private RoleData roleData;

    @Convert(converter = YesNoConverter.class)
    private boolean status;

    public UserDTOResponse userToUserDTO(User user)
    {
        return UserDTOResponse.builder()
                .userId(user.getUserId())
                .userGenId(user.getUserGenId())
                .fname(user.getFname())
                .lname(user.getLname())
                .email(user.getEmail())
                .contactNo(user.getContactNo())
                .uname(user.getUname())
                .password(user.getPassword())
                .build();
    }
}

package com.xworkz.loginsystem.dto;

import com.xworkz.loginsystem.constant.LoginConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data

public class LoginDto {

    private int id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String createdBy = LoginConstant.SYSTEM.toString();
    private Timestamp createdTime = Timestamp.valueOf(LocalDateTime.now());
}

package com.xworkz.loginsystem.service;

import com.xworkz.loginsystem.dto.LoginDto;

public interface LoginService {

    boolean save(LoginDto loginDto);
    LoginDto[] findAll();

}

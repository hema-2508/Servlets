package com.xworkz.loginsystem.repository;

import com.xworkz.loginsystem.dto.LoginDto;

public interface LoginRepository {

    boolean persist(LoginDto loginDto);
   LoginDto[] findAll();
}

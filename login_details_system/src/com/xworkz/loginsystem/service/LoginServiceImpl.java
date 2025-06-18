package com.xworkz.loginsystem.service;

import com.xworkz.loginsystem.dto.LoginDto;
import com.xworkz.loginsystem.repository.LoginRepository;
import com.xworkz.loginsystem.repository.LoginRepositoryImpl;

import java.util.Arrays;

public class LoginServiceImpl implements LoginService{

    LoginRepository loginRepository = new LoginRepositoryImpl();
    @Override
    public boolean save(LoginDto loginDto) {
        System.out.println("Service method");
        if(loginDto!=null){

            return loginRepository.persist(loginDto);
        }
        return false;
    }

    @Override
    public LoginDto[] findAll() {
        System.out.println(Arrays.toString(loginRepository.findAll()));
        return loginRepository.findAll();
    }
}

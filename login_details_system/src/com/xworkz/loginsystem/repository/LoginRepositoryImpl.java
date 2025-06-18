package com.xworkz.loginsystem.repository;

import com.xworkz.loginsystem.dto.LoginDto;
import com.xworkz.loginsystem.utils.JdbcUtils;

import java.sql.*;

public class LoginRepositoryImpl implements LoginRepository{
    @Override
    public boolean persist(LoginDto loginDto) {

        //load the driver
        try {
            Class.forName(JdbcUtils.jdbcDriver);
            //get connection
           Connection connection = DriverManager.getConnection(JdbcUtils.jdbcUrl,JdbcUtils.jdbcUserName,JdbcUtils.jdbcPassword);
            String query = "insert into login_details(user_name,user_email,user_password,created_by,created_time) values(?,?,?,?,?)";
           PreparedStatement statement = connection.prepareStatement(query);
           statement.setString(1,loginDto.getUserName());
           statement.setString(2, loginDto.getUserEmail());
           statement.setString(3,loginDto.getUserPassword());
           statement.setString(4,loginDto.getCreatedBy());
           statement.setTimestamp(5,loginDto.getCreatedTime());
          int result =  statement.executeUpdate();
          if(result>0){
              return true;
          }
        }catch(ClassNotFoundException | SQLException exception){
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public LoginDto[] findAll() {
        int index=0;
        //int arraySize=1;
       //LoginDto[] loginDtos=null;

        try {
            Class.forName(JdbcUtils.jdbcDriver);
            //get connection
            Connection connection = DriverManager.getConnection(JdbcUtils.jdbcUrl, JdbcUtils.jdbcUserName, JdbcUtils.jdbcPassword);
            String fetchAll ="select * from login_details";
           PreparedStatement statement = connection.prepareStatement(fetchAll);
          ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                loginDtos=new LoginDto[arraySize];
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getString(5));
                System.out.println(resultSet.getTimestamp(6));
                System.out.println("==========================================");
                LoginDto loginDto=new LoginDto();
                loginDto.setId(resultSet.getInt(1));
                loginDto.setUserName(resultSet.getString(2));
                loginDto.setUserEmail(resultSet.getString(3));
                loginDto.setUserPassword(resultSet.getString(4));
                loginDto.setCreatedBy(resultSet.getString(5));
                loginDto.setCreatedTime(resultSet.getTimestamp(6));

                loginDtos[index]=loginDto;
                arraySize++;
                index++;


            }

        }catch (ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }

        return loginDtos;
    }
}

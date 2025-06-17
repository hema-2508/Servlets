package com.xworkz.complaint.repository;

import com.xworkz.complaint.dto.DetailsDto;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FormRepositoryImplementation implements FormRepository{


    @SneakyThrows
    @Override
    public boolean persist(DetailsDto detailsDto) {
        if(detailsDto!=null){
            String url="jdbc:mysql://localhost:3306/complaint";
            String username="root";
            String password="Hema@342434";
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Step 2 : Create the Connection
            Connection connection= DriverManager.getConnection(url,username,password);
            //Step 3 : Prepare the Statement
            String sql="insert into complaint values(0,'"+detailsDto.getUsername()+"','"+detailsDto.getEmail()+"',"+detailsDto.getContact()+",'"+detailsDto.getComplaint()+"')";
            Statement statement=connection.createStatement();
            //step 4 : execute the statement
            statement.executeUpdate(sql);
            return true;
        }
        return false;
    }
}
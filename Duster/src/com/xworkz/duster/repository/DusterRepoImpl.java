package com.xworkz.duster.repository;

import com.xworkz.duster.dto.DusterDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class DusterRepoImpl implements DusterRepo{
    @Override
    public boolean persist(DusterDTO dusterDTO) {
        System.out.println("running persist in DusterRepoImpl");
        if (dusterDTO != null) {
            String url = "jdbc:mysql://localhost:3306/weather";
            String username = "root";
            String password = "Hema@342434";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection(url, username, password);

                String sql = "insert into duster values (0,'"+ dusterDTO.getMaterial()+"','"+ dusterDTO.getColor()+"',"+ dusterDTO.getCost()+",'"+ dusterDTO.getDateOfManufac()+"',"+ dusterDTO.getQuantity()+",'"+ dusterDTO.getIsUseful()+"');";
                Statement statement = connection.createStatement();

                statement.executeUpdate(sql);
            }
            catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
        return false;
    }

    @Override
    public Optional<DusterDTO> findById(int id) {
        System.out.println("running findById in dusterRepositoryImpl...");

        return DusterRepo.super.findById(id);
    }
}

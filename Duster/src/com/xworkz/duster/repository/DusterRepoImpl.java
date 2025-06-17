package com.xworkz.duster.repository;

import com.xworkz.duster.constant.DBProperties;
import com.xworkz.duster.dto.DusterDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class DusterRepoImpl implements DusterRepo{
    @Override
    public boolean persist(DusterDTO dusterDTO) {
        System.out.println("running persist in DusterRepoImpl");
        if (dusterDTO != null) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager
                        .getConnection(DBProperties.URL.getProp(), DBProperties.USER_NAME.getProp(), DBProperties.SECRET.getProp());

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
        //JDBC
        // Load & register , Create the Connection , Preppare the Statemtne , Execute the statement
        //URL,UN,PWD
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DBProperties.URL.getProp(), DBProperties.USER_NAME.getProp(), DBProperties.SECRET.getProp());
            String findByIdSQL="select * from duster dust where dust.id="+id+"";
            System.out.println("findById :"+findByIdSQL);
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(findByIdSQL);
            System.out.println("resultSet :"+resultSet);
            while(resultSet.next())
            {
               int pk= resultSet.getInt("id");
               String material=resultSet.getString("material");
               String color=resultSet.getString("color");
               int cost=resultSet.getInt("cost");
                LocalDate manfdate=resultSet.getDate("dateOfManufac").toLocalDate();
                int quantity=resultSet.getInt("quantity");
                String useFul=resultSet.getString("isUseful");

                DusterDTO  dusterDTO=new DusterDTO(material,color,cost,manfdate,quantity,useFul);
                return  Optional.of(dusterDTO);
            }

        }
        catch (SQLException | ClassNotFoundException exception)
        {
            System.err.println("SQLException in findById "+exception.getMessage());
        }
        return Optional.empty();
    }
}

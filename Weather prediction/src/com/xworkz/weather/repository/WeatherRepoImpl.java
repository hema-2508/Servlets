package com.xworkz.weather.repository;

import com.xworkz.weather.dto.WeatherDTO;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WeatherRepoImpl implements WeatherRepo{


    @Override
    public boolean persist(WeatherDTO weatherDTO) {
        System.out.println("running persist in WeatherRepositoryImpl");
        System.out.println("should save into DB...");
        if (weatherDTO != null) {
            String url = "jdbc:mysql://localhost:3306/weather";
            String username = "root";
            String password = "Hema@342434";
            //4 steps
            //Step1 : Load & register the Driver
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");// register

            //Step 2 : Create the Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            //Step 3 : Prepare the Statement
            String sql = "insert into weather_data values (0,'"+weatherDTO.getPname()+ "','" + weatherDTO.getWeather() + "'," + weatherDTO.getMintemp() + "," + weatherDTO.getMaxtemp() + ",'"+ weatherDTO.getCloudy() + "','"+ weatherDTO.getRaining() + "','"+ weatherDTO.getHumidity() + "','"+ weatherDTO.getWindspeed() + "','"+ weatherDTO.getSunrisetime() + "','"+ weatherDTO.getSunsettime() + "','"+ weatherDTO.getMoonrisetime() + "','"+ weatherDTO.getMoonsettime() + "','"+ weatherDTO.getRainstarttime() + "','"+ weatherDTO.getRainendtime() + "','"+ weatherDTO.getPrecipitation() + "','"+ weatherDTO.getLocal()+"');";
            Statement statement = connection.createStatement();
            //step 4 : execute the statement
            statement.executeUpdate(sql);
            }
            catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
            return false;
    }
}

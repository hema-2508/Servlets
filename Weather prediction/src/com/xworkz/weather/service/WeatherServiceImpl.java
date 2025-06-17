package com.xworkz.weather.service;

import com.xworkz.weather.dto.WeatherDTO;
import com.xworkz.weather.repository.WeatherRepo;
import com.xworkz.weather.repository.WeatherRepoImpl;

public class WeatherServiceImpl implements WeatherService{
    @Override
    public boolean save(WeatherDTO weatherDTO) {
        boolean valid = true;
        if(weatherDTO!=null){
            System.out.println("DTO returning null");
            valid = false;
        }

        if (weatherDTO.getPname() == null ) {
            System.out.println("Invalid place name");
            valid = false;
        }


        if (weatherDTO.getWeather() == null ) {
            System.out.println("Invalid weather description");
            valid = false;
        }


        if (weatherDTO.getMintemp() < -100 || weatherDTO.getMintemp() > 100) {
            System.out.println("Invalid min temperature range");
            valid = false;
        }

        if (weatherDTO.getMaxtemp() < -100 || weatherDTO.getMaxtemp() > 100) {
            System.out.println("Invalid max temperature range");
            valid = false;
        }

        if (weatherDTO.getMintemp() > weatherDTO.getMaxtemp()) {
            System.out.println("Min temperature is greater than max temperature");
            valid = false;
        }


        if (weatherDTO.getCloudy() == null ) {
            System.out.println("Invalid cloudy value");
            valid = false;
        }


        if (weatherDTO.getRaining() == null ) {
            System.out.println("Invalid raining value ");
            valid = false;
        }

        if (weatherDTO.getHumidity() == null ) {
            System.out.println("Humidity not valid");
            valid = false;
        }


        if (weatherDTO.getWindspeed() == null) {
            System.out.println("Wind speed cannot be empty");
            valid = false;
        }

        if (weatherDTO.getSunrisetime() == null) {
            System.out.println("Sunrise time is required");
            valid = false;
        }

        if (weatherDTO.getSunsettime() == null) {
            System.out.println("Sunset time is required");
            valid = false;
        }

        if (weatherDTO.getMoonrisetime() == null) {
            System.out.println("Moonrise time is required");
            valid = false;
        }

        if (weatherDTO.getMoonsettime() == null) {
            System.out.println("Moonset time is required");
            valid = false;
        }

        if (weatherDTO.getRainstarttime() == null) {
            System.out.println("Rain start time is required");
            valid = false;
        }

        if (weatherDTO.getRainendtime() == null) {
            System.out.println("Rain end time is required");
            valid = false;
        }

        if (weatherDTO.getPrecipitation() == null || weatherDTO.getPrecipitation().trim().isEmpty()) {
            System.out.println("Precipitation is required");
            valid = false;
        }

        if (weatherDTO.getLocal() == null) {
            System.out.println("Local DateTime is required");
            valid = false;
        }
        System.out.println("data is valid, will save into DB using repo...");
        WeatherRepo weatherRepo = new WeatherRepoImpl();
        boolean repo = weatherRepo.persist(weatherDTO);

        return valid;
    }
}

package com.xworkz.weather.repository;

import com.xworkz.weather.dto.WeatherDTO;

public interface WeatherRepo {
     boolean persist(WeatherDTO weatherDTO);
}

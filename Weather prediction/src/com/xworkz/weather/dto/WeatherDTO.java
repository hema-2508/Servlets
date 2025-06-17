package com.xworkz.weather.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class WeatherDTO {
    String pname;

    String weather;

    int mintemp=0;

    int maxtemp=0;

    String cloudy;

    String raining;

    String humidity;

    String windspeed;

    LocalTime sunrisetime;


    LocalTime sunsettime;


    LocalTime moonrisetime;

    LocalTime moonsettime ;

    String rainstartStr ;
    LocalTime rainstarttime ;

    LocalTime rainendtime ;

    String precipitation;

    LocalDateTime local;


}

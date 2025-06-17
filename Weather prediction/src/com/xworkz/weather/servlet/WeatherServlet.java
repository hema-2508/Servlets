package com.xworkz.weather.servlet;

import com.xworkz.weather.dto.WeatherDTO;
import com.xworkz.weather.service.WeatherService;
import com.xworkz.weather.service.WeatherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

@WebServlet(urlPatterns = "/move", loadOnStartup = 1)
public class WeatherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pname=req.getParameter("pname");

        String weather=req.getParameter("weather");

        String mitemp=req.getParameter("mintemp");
        int mintemp=0;
        if(mitemp!=null){
            mintemp=Integer.parseInt(mitemp);
        }

        String matemp=req.getParameter("maxtemp");
        int maxtemp=0;
        if(matemp!=null){
            maxtemp=Integer.parseInt(matemp);
        }

        String cloudy=req.getParameter("cloudy");

        String raining=req.getParameter("raining");

        String humidity=req.getParameter("humidity");

        String windspeed=req.getParameter("windspeed");

        String sunritime=req.getParameter("sunrisetime");
        LocalTime sunrisetime =LocalTime.MIDNIGHT;
        if(sunritime!=null) {
            sunrisetime = LocalTime.parse(sunritime);
        }

        String sunsetime=req.getParameter("sunsettime");
        LocalTime sunsettime =LocalTime.MIDNIGHT;
        if(sunsetime!=null) {
            sunsettime = LocalTime.parse(sunsetime);
        }

        String moonritime=req.getParameter("moonrisetime");
        LocalTime moonrisetime =LocalTime.MIDNIGHT;
        if(moonritime!=null) {
            moonrisetime = LocalTime.parse(moonritime);
        }

        String moonsetStr = req.getParameter("moonsettime");
        LocalTime moonsettime = LocalTime.MIDNIGHT;
        if (moonsetStr != null && !moonsetStr.isEmpty()) {
            moonsettime = LocalTime.parse(moonsetStr);
        }

        String rainstartStr = req.getParameter("rainstarttime");
        LocalTime rainstarttime = LocalTime.MIDNIGHT;
        if (rainstartStr != null && !rainstartStr.isEmpty()) {
            rainstarttime = LocalTime.parse(rainstartStr);
        }

        String rainendStr = req.getParameter("rainendtime");
        LocalTime rainendtime = LocalTime.MIDNIGHT;
        if (rainendStr != null && !rainendStr.isEmpty()) {
            rainendtime = LocalTime.parse(rainendStr);
        }

        String precipitation=req.getParameter("precipitation");
        LocalDateTime local = LocalDateTime.now();
        WeatherDTO weatherDTO= new WeatherDTO();
        weatherDTO.setPname(pname);
        weatherDTO.setWeather(weather);
        weatherDTO.setMintemp(mintemp);
        weatherDTO.setMaxtemp(maxtemp);
        weatherDTO.setCloudy(cloudy);
        weatherDTO.setRaining(raining);
        weatherDTO.setHumidity(humidity);
        weatherDTO.setWindspeed(windspeed);
        weatherDTO.setSunrisetime(sunrisetime);
        weatherDTO.setSunsettime(sunsettime);
        weatherDTO.setMoonrisetime(moonrisetime);
        weatherDTO.setMoonsettime(moonsettime);
        weatherDTO.setRainstarttime(rainstarttime);
        weatherDTO.setRainendtime(rainendtime);
        weatherDTO.setPrecipitation(precipitation);
        weatherDTO.setLocal(local);

        WeatherService weatherService = new WeatherServiceImpl();
        boolean save=weatherService.save(weatherDTO);
        if(save){
            System.out.println("saved successfully");
        }
        else{
            System.out.println("not saved");
        }


    }
}

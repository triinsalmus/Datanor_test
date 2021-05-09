package com.example.Datanor.controller;

import com.example.Datanor.dto.CityWeatherResponse;
import com.example.Datanor.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/weather")
@RestController
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping("city/{city}")
    public CityWeatherResponse getWeather(@PathVariable("city") String name) {
        return service.getWeather(name);
    }

    @GetMapping("/all")
    public List<CityWeatherResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/delete")
    public void deleteWeather() {
        service.deleteWeather();
    }

}

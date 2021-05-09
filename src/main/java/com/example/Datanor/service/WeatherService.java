package com.example.Datanor.service;

import com.example.Datanor.dto.CityWeatherResponse;
import com.example.Datanor.dto.WeatherResponse;
import com.example.Datanor.exceptions.WeatherErrorHandler;
import com.example.Datanor.exceptions.WeatherException;
import com.example.Datanor.repository.WeatherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository repository;

    public CityWeatherResponse getWeather(String cityName) {
        try {

            RestTemplate restTemplate = new RestTemplate();
            String resourceUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=c1a4c6a93c2616d5a9b379e8afc84948&units=metric";
            WeatherResponse response = restTemplate.getForObject(resourceUrl, WeatherResponse.class);
            CityWeatherResponse cityWeather = new CityWeatherResponse();
            cityWeather.setName(response.name);
            cityWeather.setTemperature(response.main.temp);
            cityWeather.setWindSpeed(response.wind.speed);
            cityWeather.setWindDeg(response.wind.deg);
            repository.addWeather(cityWeather);
            return cityWeather;
        } catch (Exception exception) {
            throw new WeatherException("City not found, please try again");
        }
    }

    public List<CityWeatherResponse> getAll() {
        return repository.getAll();
    }

    public void deleteWeather() {
        repository.deleteWeather();
    }


}

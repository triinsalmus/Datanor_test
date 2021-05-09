package com.example.Datanor.repository;

import com.example.Datanor.dto.CityWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WeatherRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addWeather(CityWeatherResponse weatherResponse) {
        String addWeather = "INSERT INTO weather_info (name,temp,speed,deg) VALUES (:dbname,:dbtemp,:dbspeed,:dbdeg)";
        Map<String, Object> weatherMap = new HashMap<>();
        weatherMap.put("dbname", weatherResponse.getName());
        weatherMap.put("dbtemp", weatherResponse.getTemperature());
        weatherMap.put("dbspeed", weatherResponse.getWindSpeed());
        weatherMap.put("dbdeg", weatherResponse.getWindDeg());
        jdbcTemplate.update(addWeather, weatherMap);
    }

    public List<CityWeatherResponse> getAll() {
        String getAll = "SELECT * FROM weather_info";
        return jdbcTemplate.query(getAll, new HashMap<>(), new CityWeatherRowMapper());
    }


    public void deleteWeather() {
        String deleteWeather = "DELETE FROM weather_info";
        Map<String, Object> deleteMap = new HashMap<>();
        jdbcTemplate.update(deleteWeather, deleteMap);
    }


}

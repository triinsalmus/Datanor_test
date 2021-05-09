package com.example.Datanor.repository;

import com.example.Datanor.dto.CityWeatherResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityWeatherRowMapper implements RowMapper<CityWeatherResponse> {

    @Override
    public CityWeatherResponse mapRow(ResultSet resultSet, int i) throws SQLException {
        CityWeatherResponse response=new CityWeatherResponse();
        response.setName(resultSet.getString("name"));
        response.setTemperature(resultSet.getDouble("temp"));
        response.setWindSpeed(resultSet.getDouble("speed"));
        response.setWindDeg(resultSet.getInt("deg"));
        return response;
    }

}

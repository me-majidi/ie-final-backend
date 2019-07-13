package repositories;

import dataLayer.dataMappers.city.CityMapper;
import entities.City;

import java.util.ArrayList;

public class CitiesRepository {
    public ArrayList<City> getActiveCities() {
        return CityMapper.getCities();
    }
}

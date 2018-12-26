package com.example.persistencefactory.service.impl;

import com.example.persistencefactory.domain.City;
import com.example.persistencefactory.repository.CityRepository;
import com.example.persistencefactory.service.CityService;
import com.example.persistencefactory.service.IPersistenceFactoryMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<?> saveAll(List<?> cityList) {
        if (!cityList.isEmpty())
            return cityRepository.saveAll((List<City>) cityList);
        else
            return cityList;
    }
}

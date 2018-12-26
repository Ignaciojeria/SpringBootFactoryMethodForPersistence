package com.example.persistencefactory.service;

import java.util.List;

public interface IPersistenceFactoryMethod {
    public List<?> saveAll(List<?> genericDomainList);
}

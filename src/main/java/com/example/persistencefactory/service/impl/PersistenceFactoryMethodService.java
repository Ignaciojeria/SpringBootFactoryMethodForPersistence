package com.example.persistencefactory.service.impl;
import com.example.persistencefactory.domain.CharacterEvent;
import com.example.persistencefactory.domain.City;
import com.example.persistencefactory.service.IPersistenceFactoryMethod;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersistenceFactoryMethodService {

    @Autowired
    private CharacterEventServiceImpl characterEventServiceImpl;

    @Autowired
    private CityServiceImpl cityServiceImpl;

    /**
     * when a service method implements a IPersistenceFactoryMethod, add this
     * service inside this method as a Pair with its corresponding ArrayList<?>();
     * and put this instance as a new element in the persistenceFactoryMethodMap local instance
     */
    public Map<String, Pair<ArrayList<?>, IPersistenceFactoryMethod>> createNewFlusheableInstance() {
        //dont change this.
        Map<String, Pair<ArrayList<?>, IPersistenceFactoryMethod>> persistenceFactoryMethodMap = new HashMap<>();

        //CharacterEventIPersistenceFactoryMethodPair
        Pair<ArrayList<?>, IPersistenceFactoryMethod> characterEventFactoryPair = new Pair<>(new ArrayList<CharacterEvent>(), characterEventServiceImpl);
        persistenceFactoryMethodMap.put(CharacterEvent.class.getName(), characterEventFactoryPair);

        //CityPersistenceFactoryMethodPair
        Pair<ArrayList<?>, IPersistenceFactoryMethod> cityFactotryPair = new Pair<>(new ArrayList<City>(), cityServiceImpl);
        persistenceFactoryMethodMap.put(City.class.getName(),cityFactotryPair);

        return persistenceFactoryMethodMap;
    }

    public void flushInstance(Map<String, Pair<ArrayList<?>, IPersistenceFactoryMethod>> flusheableInstance) {
        flusheableInstance.forEach((key, value) ->
                value.getValue().saveAll(value.getKey())
        );
    }


}

package com.example.persistencefactory.service.impl;

import com.example.persistencefactory.domain.Character;
import com.example.persistencefactory.domain.City;
import com.example.persistencefactory.domain.CharacterEvent;
import com.example.persistencefactory.domain.Event;
import com.example.persistencefactory.repository.CharacterRepository;
import com.example.persistencefactory.repository.CityRepository;
import com.example.persistencefactory.repository.CharacterEventRepository;
import com.example.persistencefactory.service.IPersistenceFactoryMethod;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class InitializationService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CharacterEventRepository characterEventRepository;

    @Autowired
    private PersistenceFactoryMethodService persistenceFactoryMethodService;

    @PostConstruct
    private void initData() {

        ArrayList<CharacterEvent> characterEventArrayList = flushFactories();

        Set<Event> events = new HashSet<>();

        Event event1 = new Event();
        event1.setLocalDateTime(LocalDateTime.now());
        event1.setEventDescription(characterEventArrayList.get(0).getDescription());
        event1.setClassNameEvent(CharacterEvent.class.getName());
        event1.setEventId(characterEventArrayList.get(0).getId());
        events.add(event1);

        Event event2 = new Event();
        event2.setEventId(characterEventArrayList.get(1).getId());
        event2.setEventDescription(characterEventArrayList.get(1).getDescription());
        event2.setClassNameEvent(CharacterEvent.class.getName());
        event2.setLocalDateTime(LocalDateTime.now());

        events.add(event1);
        events.add(event2);

        City city = createNewCity();

        Character character = createNewCharacter(city, events);

    }

    private Character createNewCharacter(City city, Set<Event> characterEventSet) {
        Character character = new Character();
        character.setId(1L);
        character.setName("Nacho");
        character.setCity(city);
        character.setEventSet(characterEventSet);
        return characterRepository.save(character);
    }

    private City createNewCity() {
        City city = new City();
        city.setId(1L);
        city.setName("Santiago de Chile");
        return cityRepository.save(city);
    }

    private CharacterEvent createNewCharacterEvent() {
        CharacterEvent characterEvent = new CharacterEvent();
        Event event = new Event();
        event.setEventDescription("the character has been created");
        event.setLocalDateTime(LocalDateTime.now());
        characterEvent.setId(1L);

        return characterEvent;
        // return characterEventRepository.save(characterEvent);
    }

    private CharacterEvent createNewCharacterAppearInSantiagoEvent() {
        CharacterEvent characterEvent = new CharacterEvent();
        Event event = new Event();
        event.setLocalDateTime(LocalDateTime.now());
        characterEvent.setId(2L);
        characterEvent.setDescription("new character was born in santiago");
        return characterEvent;
        //return characterEventRepository.save(characterEvent);
    }

    private ArrayList<CharacterEvent> flushFactories() {
        Map<String, Pair<ArrayList<?>, IPersistenceFactoryMethod>> flusheableInstance = persistenceFactoryMethodService.createNewFlusheableInstance();

        ArrayList<CharacterEvent> characterEventArrayList = (ArrayList<CharacterEvent>) flusheableInstance.get(CharacterEvent.class.getName()).getKey();
        characterEventArrayList.add(createNewCharacterEvent());
        characterEventArrayList.add(createNewCharacterAppearInSantiagoEvent());

        persistenceFactoryMethodService.flushInstance(flusheableInstance);

        return characterEventArrayList;
    }

}

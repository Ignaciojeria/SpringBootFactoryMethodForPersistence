package com.example.persistencefactory.service.impl;

import com.example.persistencefactory.domain.Character;
import com.example.persistencefactory.domain.CharacterEvent;
import com.example.persistencefactory.repository.CharacterEventRepository;
import com.example.persistencefactory.service.CharacterEventService;
import com.example.persistencefactory.service.IPersistenceFactoryMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterEventServiceImpl implements CharacterEventService {

    @Autowired
    private CharacterEventRepository characterEventRepository;

    @Override
    public List<?> saveAll(List<?> characterEventList) {
        List<CharacterEvent> localCharacterEventList = (List<CharacterEvent>) characterEventList;
        if (!characterEventList.isEmpty())
            return characterEventRepository.saveAll(localCharacterEventList);
        else
            return localCharacterEventList;
    }
}

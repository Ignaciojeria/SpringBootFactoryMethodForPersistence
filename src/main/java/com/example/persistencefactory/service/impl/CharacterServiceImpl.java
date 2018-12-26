package com.example.persistencefactory.service.impl;

import com.example.persistencefactory.domain.Character;
import com.example.persistencefactory.repository.CharacterRepository;
import com.example.persistencefactory.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<?> saveAll(List<?> characterList) {
        if (!characterList.isEmpty())
            return characterRepository.saveAll((List<Character>) characterList);
        else
            return characterList;
    }
}

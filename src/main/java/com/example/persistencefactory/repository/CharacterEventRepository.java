package com.example.persistencefactory.repository;

import com.example.persistencefactory.domain.CharacterEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterEventRepository extends JpaRepository<CharacterEvent,String> {
}

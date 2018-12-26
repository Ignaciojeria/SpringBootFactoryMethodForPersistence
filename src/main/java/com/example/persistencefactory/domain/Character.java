package com.example.persistencefactory.domain;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Character {

    @Id
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private City city;

    @ElementCollection
    private Set<Event> eventSet;

    public Character(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }
}

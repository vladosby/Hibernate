package org.koushik.hibernate.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by vladosby on 18.09.2015.
 */

@Entity
public class Animal extends BaseEntity{
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TYPE_ID")
    private AnimalType animalType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
//    @JoinTable(name = "ANIMAL_ANIMALFEED", joinColumns = @JoinColumn(name = "ANIMAL_ID"),
//            inverseJoinColumns = @JoinColumn(name = "ANIMALFEED_ID"))

    private Collection<AnimalFeed> feeds;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<AnimalOwner> animalOwners;

    public Collection<AnimalOwner> getAnimalOwners() {
        return animalOwners;
    }

    public void setAnimalOwners(Collection<AnimalOwner> animalOwners) {
        this.animalOwners = animalOwners;
    }

    public Collection<AnimalFeed> getFeeds() {
        return feeds;
    }

    public void setFeeds(Collection<AnimalFeed> feeds) {
        this.feeds = feeds;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

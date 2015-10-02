package org.koushik.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by vladosby on 21.09.2015.
 */
@Entity
public class AnimalFeed extends BaseEntity{
    private String name;
    @ManyToOne
    @JoinColumn(name = "ANIMAL_ID")
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package org.koushik.hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by vladosby on 18.09.2015.
 */

@Entity
public class Animal extends BaseEntity{
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private AnimalType animalType;

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

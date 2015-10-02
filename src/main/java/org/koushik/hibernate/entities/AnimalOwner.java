package org.koushik.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Collection;

/**
 * Created by vladosby on 27.09.2015.
 */

@Entity
public class AnimalOwner extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "animalOwners")
    private Collection<Animal> animals;

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

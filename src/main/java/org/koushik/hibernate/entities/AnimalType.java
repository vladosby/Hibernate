package org.koushik.hibernate.entities;

import javax.persistence.Entity;

/**
 * Created by vladosby on 21.09.2015.
 */
@Entity
public class AnimalType extends BaseEntity {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

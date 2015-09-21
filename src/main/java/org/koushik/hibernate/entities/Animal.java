package org.koushik.hibernate.entities;

import org.hibernate.mapping.Collection;

import javax.persistence.Entity;

/**
 * Created by vladosby on 18.09.2015.
 */

@Entity
public class Animal extends BaseEntity{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

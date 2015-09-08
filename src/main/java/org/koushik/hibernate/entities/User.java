package org.koushik.hibernate.entities;

import javax.persistence.*;

/**
 * Created by vladosby on 06.09.2015.
 */

@Entity
@Table(name = "USER")
public class User extends BaseFields{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

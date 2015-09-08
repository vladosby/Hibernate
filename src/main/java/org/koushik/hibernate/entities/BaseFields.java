package org.koushik.hibernate.entities;

import javax.persistence.*;

/**
 * Created by vladosby on 06.09.2015.
 */
@MappedSuperclass
public abstract class BaseFields {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package org.koushik.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by vladosby on 17.09.2015.
 */
@Embeddable
public class Address {
    private String city;
    @Column(name = "STREET")
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

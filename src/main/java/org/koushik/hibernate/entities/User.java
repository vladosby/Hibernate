package org.koushik.hibernate.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by vladosby on 06.09.2015.
 */

@Entity
@Table(name = "USER")
public class User extends BaseFields{
    private String name;
    @ElementCollection
    private List<Address> addresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}

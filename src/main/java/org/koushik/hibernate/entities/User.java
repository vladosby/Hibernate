package org.koushik.hibernate.entities;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vladosby on 06.09.2015.
 */

@Entity
@Table(name = "USER")
public class User extends BaseEntity {
    private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "ADDRESS",
    joinColumns = @JoinColumn(name = "USER_ID"))
    @GenericGenerator(name = "gen", strategy = "increment")
    @CollectionId(columns = {@Column(name = "ADDR_ID")}, generator = "gen",
            type = @Type(type = "long"))
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

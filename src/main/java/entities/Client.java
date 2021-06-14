package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client extends EntityClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_rent", joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "rent_id"))
    List<Rent> rents;
    String firstName;
    String lastName;
    String address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", rents=" + rents +
                '}';
    }
}

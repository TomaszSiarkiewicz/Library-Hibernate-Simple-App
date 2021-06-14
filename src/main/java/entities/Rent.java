package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rent extends EntityClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rent_id")
    long id;
    LocalDateTime datefrom;
    LocalDateTime dateTo;

    public Rent() {
        this.datefrom= LocalDateTime.now();
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(LocalDateTime datefrom) {
        this.datefrom = datefrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", datefrom=" + datefrom +
                ", dateTo=" + dateTo +
                '}';
    }
}

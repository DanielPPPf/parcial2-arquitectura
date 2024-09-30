package co.edu.unisabana.parcial.service.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Checkin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  
    private final String facility;
    private final String driver;
    private final int dayOfMonth;

    public Checkin(String facility, String driver, int dayOfMonth) {
        this.facility = facility;
        this.driver = driver;
        this.dayOfMonth = dayOfMonth;
    }
}

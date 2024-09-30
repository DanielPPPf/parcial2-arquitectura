package co.edu.unisabana.parcial.service.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Asegúrate de tener un campo id

    private String facility;

    private String driver;

    private int dayOfMonth;

    // Constructor con todos los campos, excepto `id`
    public Checkout(String facility, String driver, int dayOfMonth) {
        this.facility = facility;
        this.driver = driver;
        this.dayOfMonth = dayOfMonth;
    }
}

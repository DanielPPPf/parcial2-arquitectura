package co.edu.unisabana.parcial;

import co.edu.unisabana.parcial.service.model.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICheckinRepository extends JpaRepository<Checkin, Long> {
    // Métodos adicionales, si los hay
}

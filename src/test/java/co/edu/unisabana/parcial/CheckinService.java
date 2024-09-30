package co.edu.unisabana.parcial;

import co.edu.unisabana.parcial.service.model.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckinService {
    private final ICheckinRepository checkinRepository;

    @Autowired
    public CheckinService(ICheckinRepository checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    public List<Checkin> findAll() {
        return checkinRepository.findAll();
    }
}

package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.touristapp.backend.model.Tour;

public interface TourRepository extends JpaRepository<Tour, Long> {
}

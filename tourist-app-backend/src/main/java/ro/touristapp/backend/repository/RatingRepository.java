package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.touristapp.backend.model.Rating;
import ro.touristapp.backend.model.Tour;
import ro.touristapp.backend.model.TouristUser;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findAllByUser(TouristUser user);
}

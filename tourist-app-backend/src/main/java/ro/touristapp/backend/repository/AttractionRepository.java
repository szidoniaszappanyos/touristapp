package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.touristapp.backend.model.Attraction;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction,Long> {
}

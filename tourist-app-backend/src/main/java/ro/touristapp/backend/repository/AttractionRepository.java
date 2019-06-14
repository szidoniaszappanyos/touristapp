package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.touristapp.backend.model.Attraction;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction,Long> {

    List<Attraction> findAll();
}

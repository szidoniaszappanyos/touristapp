package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.touristapp.backend.model.AttractionType;

@Repository
public interface AttractionTypeRepository extends JpaRepository<AttractionType,Long> {
}

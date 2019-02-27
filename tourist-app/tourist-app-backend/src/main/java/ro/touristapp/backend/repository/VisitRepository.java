package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.touristapp.backend.model.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
}

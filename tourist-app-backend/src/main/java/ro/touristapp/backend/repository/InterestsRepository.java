package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.touristapp.backend.model.Interests;

@Repository
public interface InterestsRepository extends JpaRepository<Interests,Long> {
}

package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.touristapp.backend.model.Location;

@Repository
public interface LocationsRepository extends JpaRepository<Location,Long> {
}

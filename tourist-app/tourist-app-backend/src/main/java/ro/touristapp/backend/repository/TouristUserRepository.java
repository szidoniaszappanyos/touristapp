package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.touristapp.backend.model.TouristUser;

@Repository
public interface TouristUserRepository extends JpaRepository<TouristUser, Long> {
}

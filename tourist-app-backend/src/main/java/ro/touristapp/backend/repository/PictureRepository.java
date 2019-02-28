package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.touristapp.backend.model.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {
}

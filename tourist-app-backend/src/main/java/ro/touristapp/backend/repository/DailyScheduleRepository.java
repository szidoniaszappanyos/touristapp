package ro.touristapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.touristapp.backend.model.DailySchedule;

@Repository
public interface DailyScheduleRepository extends JpaRepository<DailySchedule,Long> {
}

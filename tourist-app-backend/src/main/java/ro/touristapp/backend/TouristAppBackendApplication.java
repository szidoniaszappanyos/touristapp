package ro.touristapp.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import ro.touristapp.backend.model.*;
import ro.touristapp.backend.repository.AttractionRepository;
import ro.touristapp.backend.repository.AttractionTypeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@SpringBootApplication
public class TouristAppBackendApplication {
    @Autowired
    TouristCreatorBean touristCreatorBean;



    List<Users> users = new ArrayList<Users>();

    public static void main(String[] args) {
        SpringApplication.run(TouristAppBackendApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        List<Tour> tours = new ArrayList<>();
        for(int i=0;i<10;i++) {
            tours.addAll(touristCreatorBean.createTours(50));
        }
        List<Rating> ratings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Users users = touristCreatorBean.createUser(UUID.randomUUID().toString());
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(0,50)));
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(50,100)));
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(100,150)));
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(150,200)));
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(200,250)));
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(250,300)));
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(300,350)));
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(350,400)));
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(400,450)));
            ratings.addAll(touristCreatorBean.createUserRatings(users.getTouristUser().getId(),tours.subList(450,500)));
        }
    }

}

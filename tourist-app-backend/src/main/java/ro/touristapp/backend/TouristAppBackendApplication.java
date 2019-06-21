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
        for(int i=0;i<100;i++) {
            tours.addAll(touristCreatorBean.createTours(50));
        }
    }

}

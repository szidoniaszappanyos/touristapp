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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@SpringBootApplication
public class TouristAppBackendApplication {

	@Autowired
	AttractionTypeRepository attractionTypeRepository;

	@Autowired
	AttractionRepository attractionRepository;

	@Autowired
	EntityManager em;

	List<Users> users = new ArrayList<Users>();

	public static void main(String[] args) {
		SpringApplication.run(TouristAppBackendApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void doSomethingAfterStartup() {
		List<AttractionType> attractionTypes = attractionTypeRepository.findAll();
		List<Users> users = new ArrayList<>();
		Random randomGenerator = new Random();
		for (int i = 0; i < 100; i++) {
			TouristUser tourist = new TouristUser();
			tourist.setFirstName("user" + i);
			tourist.setLastName("user" + i);
			tourist.setEmail("user" + i + "@user.com");
			tourist.setBirthDate(Timestamp.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
			List<Interests> interests = new ArrayList<>();
			tourist.setInterests(interests);
			Users user = new Users("user" + i, "password" + i, tourist);
			users.add(user);
			attractionTypes.forEach((type) -> {
				int stars = randomGenerator.nextInt(5);
				interests.add(new Interests(null, tourist, type, stars));
			});
		}

		List<Attraction> attractions = attractionRepository.findAll();
		List<List<Attraction>> selectedRoutes = new ArrayList<>();
		for (int i = 0; i < 500; i++) {
			Collections.shuffle(attractions);
			List<Attraction> copy = new LinkedList<>(attractions.subList(0,5));
			selectedRoutes.add(copy);
		}

		List<Tour> tours = new ArrayList<>();
		for(int i=0;i<selectedRoutes.size();i++){
			Tour tour = new Tour();
			tour.setAttractions(new HashSet<>(selectedRoutes.get(i)));
			tour.generateSummary();
			tours.add(tour);
		}

		for(int i=0;i<users.size();i++){
			for(int j=0;j<tours.size();j++){
				
			}
		}
	}

}

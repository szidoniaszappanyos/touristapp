package ro.touristapp.backend;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import org.springframework.transaction.annotation.Transactional;
import ro.touristapp.backend.model.Attraction;
import ro.touristapp.backend.model.AttractionType;
import ro.touristapp.backend.model.Interests;
import ro.touristapp.backend.model.TouristUser;
import ro.touristapp.backend.model.Users;
import ro.touristapp.backend.repository.AttractionRepository;
import ro.touristapp.backend.repository.AttractionTypeRepository;

import javax.persistence.EntityManager;

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
			List<Attraction> copy = new LinkedList<>(attractions);
			Collections.shuffle(copy);
			selectedRoutes.add(copy);
		}
		System.out.println(selectedRoutes);
		System.out.println(users);
	}

}

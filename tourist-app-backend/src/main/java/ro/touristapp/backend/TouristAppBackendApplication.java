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
    private static final Random random = new Random(System.currentTimeMillis());

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
            List<Attraction> copy = new LinkedList<>(attractions.subList(0, 5));
            selectedRoutes.add(copy);
        }

        List<Tour> tours = new ArrayList<>();
        for (int i = 0; i < selectedRoutes.size(); i++) {
            Tour tour = new Tour();
            tour.setAttractions(new HashSet<>(selectedRoutes.get(i)));
            tour.generateSummary();
            tours.add(tour);
        }

        int[] staticInterestPoints = users.get(0).getTouristUser().getInterestsPoints(false);
        for (int i = 0; i < users.size(); i++) {
            int[] interestsPoints = users.get(i).getTouristUser().getInterestsPoints(true);
            double[] starsPerPoint = new double[staticInterestPoints.length];
            for (int j = 0; j < starsPerPoint.length; j++) {
                starsPerPoint[j] = (double) interestsPoints[j] / staticInterestPoints[j];
                starsPerPoint[i] += random.nextGaussian()*0.3;
            }

            List<Rating> ratings= new ArrayList<>();
            for (int j = 0; j < tours.size(); j++) {
                Rating rating = new Rating();
                rating.setUser(users.get(i).getTouristUser());
                rating.setTour(tours.get(j));
                int total = 0;
                double totalStars = 0;
                total += tours.get(j).getArt();
                totalStars += tours.get(j).getArt()* starsPerPoint[0];
                total += tours.get(j).getAmusement();
                totalStars += tours.get(j).getAmusement()* starsPerPoint[1];
                total += tours.get(j).getRecreation();
                totalStars += tours.get(j).getRecreation()* starsPerPoint[2];
                total += tours.get(j).getHistoric();
                totalStars += tours.get(j).getHistoric()* starsPerPoint[3];
                int ratingInt = (int)Math.round((totalStars/total)*4);
				rating.setStars(ratingInt);
				ratings.add(rating);
//				em.persist(rating);
            }

            System.out.println(ratings);
        }
    }

}

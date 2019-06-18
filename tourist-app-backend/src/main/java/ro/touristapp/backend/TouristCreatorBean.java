package ro.touristapp.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

@Component
public class TouristCreatorBean {
    private static final Random random = new Random(System.currentTimeMillis());

    final AttractionTypeRepository attractionTypeRepository;

    @PersistenceContext
    EntityManager em;

    @Autowired
    AttractionRepository attractionRepository;

    public TouristCreatorBean(AttractionTypeRepository attractionTypeRepository) {
        this.attractionTypeRepository = attractionTypeRepository;
    }

    @Transactional
    public Users createUser(String userId){
        List<AttractionType> attractionTypes = attractionTypeRepository.findAll();
        TouristUser tourist = new TouristUser();
        tourist.setFirstName("user_" + userId);
        tourist.setLastName("user_" + userId);
        tourist.setEmail("user_" + userId + "@user.com");
        tourist.setBirthDate(Timestamp.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        List<Interests> interests = new ArrayList<>();
        tourist.setInterests(interests);
        Users user = new Users("user_" + userId, "password", tourist);
        attractionTypes.forEach((type) -> {
            int stars = random.nextInt(5);
            Interests interest=new Interests(null, tourist, type, stars);
            interests.add(interest);
            em.persist(interest);
        });
        em.persist(tourist);
        em.persist(user);
        return user;
    }

    @Transactional
    public List<Rating> createUserRatings(Long touristId,List<Tour> tours){
        TouristUser tourist=em.find(TouristUser.class,touristId);
        int[] staticInterestPoints = tourist.getInterestsPoints(false);
        int[] interestsPoints = tourist.getInterestsPoints(true);
        double[] starsPerPoint = new double[staticInterestPoints.length];
        for (int j = 0; j < starsPerPoint.length; j++) {
            starsPerPoint[j] = (double) interestsPoints[j] / staticInterestPoints[j];
            starsPerPoint[j] += random.nextGaussian()*0.75;
        }

        List<Rating> ratings= new ArrayList<>();
        for (int j = 0; j < tours.size(); j++) {
            Rating rating = new Rating();
            rating.setUser(tourist);
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
            int ratingInt = (int)Math.round((totalStars/total));
            rating.setRating(ratingInt);
            ratings.add(rating);
            em.persist(rating);
        }
        return ratings;
    }

    @Transactional
    public List<Tour> createTours(int size){
        List<Attraction> attractions = attractionRepository.findAll();
        List<List<Attraction>> selectedRoutes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
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
            em.persist(tour);
        }
        return tours;
    }
}

package ro.touristapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ro.touristapp.backend.model.AttractionType;
import ro.touristapp.backend.model.Interests;
import ro.touristapp.backend.model.TouristUser;
import ro.touristapp.backend.model.Users;
import ro.touristapp.backend.repository.InterestsRepository;
import ro.touristapp.backend.repository.TouristUserRepository;
import ro.touristapp.backend.repository.UsersRepository;
import ro.touristapp.backend.resource.AttractionTypeResource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PreferencesService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    InterestsRepository interestsRepository;
    @Autowired
    AttractionTypeResource attractionTypeResource;
    @Autowired
    TouristUserRepository touristUserRepository;

    public void setInterests(List<Integer> ratings) {
        System.out.println(ratings);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        Optional<Users> user = usersRepository.findByUsername(currentPrincipalName);
        if (user != null) {
            TouristUser currentTouristUser = user.get().getTouristUser();
            System.out.println(currentTouristUser);
            interestsRepository.deleteAll(currentTouristUser.getInterests());
            currentTouristUser.getInterests().clear();
            for (int i = 0; i < 9; i++) {
                Optional<AttractionType> attractionType = attractionTypeResource.findById(new Long(i+1));
                if (attractionType != null) {
                    System.out.println(attractionType+ " " + ratings.get(i));
                    Interests interest = new Interests(null, currentTouristUser, attractionType.get(),
                            ratings.get(i));
                    currentTouristUser.getInterests().add(interest);
                    interestsRepository.save(interest);
                }
            }
            touristUserRepository.save(currentTouristUser);
        }
    }
}

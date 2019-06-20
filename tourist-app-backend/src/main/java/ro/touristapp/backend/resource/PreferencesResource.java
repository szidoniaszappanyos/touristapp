package ro.touristapp.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.touristapp.backend.model.*;
import ro.touristapp.backend.model.dto.PreferencesDto;
import ro.touristapp.backend.repository.InterestsRepository;
import ro.touristapp.backend.repository.UsersRepository;
import ro.touristapp.backend.service.PreferencesService;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/preferences")
public class PreferencesResource {
    @Autowired
    PreferencesService preferencesService;

    @RequestMapping(path = "/interests", method = RequestMethod.POST)
    public void setInterests( @RequestBody PreferencesDto preferences) {
        preferencesService.setInterests(preferences.getRatings());
    }

}

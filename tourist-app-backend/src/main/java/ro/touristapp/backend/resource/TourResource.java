package ro.touristapp.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.touristapp.backend.model.dto.TourAttraction;
import ro.touristapp.backend.service.AttractionService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/tour")
public class TourResource {
    @Autowired
    AttractionService attractionService;

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public List<TourAttraction> getRandomTour() {
        return attractionService.getRandomTour();
    }
}

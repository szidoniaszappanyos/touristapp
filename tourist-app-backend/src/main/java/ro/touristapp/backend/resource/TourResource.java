package ro.touristapp.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(path = "{username}/personal/{id}", method = RequestMethod.GET)
    public List<TourAttraction> getPersonalizedTour(@PathVariable(name = "username") String username,@PathVariable(name = "id") int id) {
        return attractionService.getPersonalizedTour(username,id);
    }

    @RequestMapping(path = "{username}/clear", method = RequestMethod.GET)
    public void clearPreviousTour(@PathVariable(name = "username") String username) {
        attractionService.clearPreviousData(username);
    }

}

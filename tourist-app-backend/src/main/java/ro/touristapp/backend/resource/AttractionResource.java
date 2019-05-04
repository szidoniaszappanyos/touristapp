package ro.touristapp.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.touristapp.backend.model.Attraction;
import ro.touristapp.backend.model.Picture;
import ro.touristapp.backend.model.dto.AttractionAllDto;
import ro.touristapp.backend.service.AttractionService;

import javax.ws.rs.Produces;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/attractions")
public class AttractionResource {

    @Autowired
    AttractionService attractionService;

    @RequestMapping(path = "/attraction", method = RequestMethod.GET)
    @Produces("text/plain")
    public Optional<Attraction> findById(@RequestParam(value = "id", defaultValue = "0") Long id) {
        return attractionService.findById(id);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<AttractionAllDto> getAllTables() {
        return attractionService.getAll();
    }

    @RequestMapping(path = "/gallery/{id}", method = RequestMethod.GET)
    public List<Picture> getGalleyOfAttraction(@PathVariable long id) {
        return attractionService.getGalleryOfAttraction(id);
    }

}

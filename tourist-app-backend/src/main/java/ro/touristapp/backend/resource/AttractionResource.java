package ro.touristapp.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.touristapp.backend.model.Attraction;
import ro.touristapp.backend.model.Picture;
import ro.touristapp.backend.model.dto.*;
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
    public List<PictureDto> getGalleryOfAttraction(@PathVariable long id) {
        return attractionService.getGalleryOfAttraction(id);
    }

    @RequestMapping(path = "/location/{id}", method = RequestMethod.GET)
    public LocationDto getLocationOfAttraction(@PathVariable long id) {
        return attractionService.getLocationOfAttraction(id);
    }

    @RequestMapping(path = "/details/{id}", method = RequestMethod.GET)
    public DetailsDto getDetailsOfAttraction(@PathVariable long id) {
        return attractionService.getDetailsOfAttraction(id);
    }

    @RequestMapping(path = "/tour/details/{id1}/{id2}/{id3}/{id4}/{id5}", method = RequestMethod.GET)
    public List<TourAttraction> getDetailsOfTourAttraction(@PathVariable long id1, @PathVariable long id2, @PathVariable long id3,
                                                       @PathVariable long id4, @PathVariable long id5) {
        return attractionService.getDetailsOfTourAttraction(id1,id2,id3,id4,id5);
    }

}

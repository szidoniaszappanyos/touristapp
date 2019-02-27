package ro.touristapp.backend.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.touristapp.backend.model.Attraction;
import ro.touristapp.backend.model.AttractionType;
import ro.touristapp.backend.repository.AttractionRepository;
import ro.touristapp.backend.repository.AttractionTypeRepository;
import ro.touristapp.backend.service.AttractionTypeService;

import javax.ws.rs.Produces;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AttractionTypeResource {

    @Autowired
    AttractionTypeService attractionTypeService;

    @RequestMapping(path = "/attractionType", method = RequestMethod.GET)
    @Produces("text/plain")
    public Optional<AttractionType> findById(@RequestParam(value = "id", defaultValue = "0") Long id) {
        return attractionTypeService.findById(id);
    }
}

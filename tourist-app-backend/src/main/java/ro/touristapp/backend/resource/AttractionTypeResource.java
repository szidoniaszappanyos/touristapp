package ro.touristapp.backend.resource;

import java.util.Optional;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.touristapp.backend.model.AttractionType;
import ro.touristapp.backend.service.AttractionTypeService;

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

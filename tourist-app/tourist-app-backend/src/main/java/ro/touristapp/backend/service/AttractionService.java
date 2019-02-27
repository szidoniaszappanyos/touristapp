package ro.touristapp.backend.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ro.touristapp.backend.model.Attraction;
import ro.touristapp.backend.repository.AttractionRepository;

import java.util.Optional;

@Service
public class AttractionService {

    @Autowired
    AttractionRepository attractionRepository;

    public Optional<Attraction> findById(@RequestParam(value = "id", defaultValue = "0") Long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String valueAsString=objectMapper.writeValueAsString(attractionRepository.findById(id));
            System.out.println(valueAsString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return attractionRepository.findById(id);
    }
}

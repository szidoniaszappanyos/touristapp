package ro.touristapp.backend.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ro.touristapp.backend.converter.AttractionToAttractionAllDtoConverter;
import ro.touristapp.backend.converter.PictureConverter;
import ro.touristapp.backend.model.Attraction;
import ro.touristapp.backend.model.Location;
import ro.touristapp.backend.model.Picture;
import ro.touristapp.backend.model.Tour;
import ro.touristapp.backend.model.dto.*;
import ro.touristapp.backend.repository.AttractionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AttractionService {

    @Autowired
    AttractionRepository attractionRepository;

    @Autowired
    AttractionToAttractionAllDtoConverter attractionToAttractionAllDtoConverter;

    @Autowired
    PictureConverter pictureConverter;

    public Optional<Attraction> findById(@RequestParam(value = "id", defaultValue = "0") Long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String valueAsString = objectMapper.writeValueAsString(attractionRepository.findById(id));
            System.out.println(valueAsString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return attractionRepository.findById(id);
    }

    public List<AttractionAllDto> getAll() {
        return attractionRepository.findAll().stream()
                .map(attractionToAttractionAllDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    public List<PictureDto> getGalleryOfAttraction(long id) {
        List<Picture> pictures = attractionRepository.findById(id).get().getPictures();
        return pictures.stream().map(pictureConverter::convertToDto).collect(Collectors.toList());
    }

    public DetailsDto getDetailsOfAttraction(long id) {
        Attraction attraction = attractionRepository.findById(id).get();
        List<String> schedule = new ArrayList<String>();
        if(attraction.getWeeklySchedule()!=null){
            schedule.add(attraction.getWeeklySchedule().getMondaySchedule().getOpeningHours().toString().substring(11, 16) + " - "
                    + attraction.getWeeklySchedule().getMondaySchedule().getOpeningHours().toString().substring(11, 16));
            schedule.add(attraction.getWeeklySchedule().getTuesdaySchedule().getOpeningHours().toString().substring(11, 16) + " - "
                    + attraction.getWeeklySchedule().getTuesdaySchedule().getOpeningHours().toString().substring(11, 16));
            schedule.add(attraction.getWeeklySchedule().getWednesdaySchedule().getOpeningHours().toString().substring(11, 16) + " - "
                    + attraction.getWeeklySchedule().getWednesdaySchedule().getOpeningHours().toString().substring(11, 16));
            schedule.add(attraction.getWeeklySchedule().getThursdaySchedule().getOpeningHours().toString().substring(11, 16) + " - "
                    + attraction.getWeeklySchedule().getThursdaySchedule().getOpeningHours().toString().substring(11, 16));
            schedule.add(attraction.getWeeklySchedule().getFridaySchedule().getOpeningHours().toString().substring(11, 16) + " - "
                    + attraction.getWeeklySchedule().getFridaySchedule().getOpeningHours().toString().substring(11, 16));
            schedule.add(attraction.getWeeklySchedule().getSaturdaySchedule().getOpeningHours().toString().substring(11, 16) + " - "
                    + attraction.getWeeklySchedule().getSaturdaySchedule().getOpeningHours().toString().substring(11, 16));
            schedule.add(attraction.getWeeklySchedule().getSundaySchedule().getOpeningHours().toString().substring(11, 16) + " - "
                    + attraction.getWeeklySchedule().getSundaySchedule().getOpeningHours().toString().substring(11, 16));
        }
        return new DetailsDto(attraction.getName(), attraction.getDetails(), attraction.getAttractionType().getName(), schedule);
    }

    public LocationDto getLocationOfAttraction(long id) {
        Location location = attractionRepository.findById(id).get().getLocation();
        String[] geolocation = location.getDetails().split(" ");
        if (geolocation.length == 2) {
            double latitude = Double.parseDouble(geolocation[0]);
            double longitude = Double.parseDouble(geolocation[1]);
            return new LocationDto(location.getId(), location.getName(), location.getAddress(), latitude, longitude);
        } else {
            double latitude = 46.770920;
            double longitude = 23.589920;
            return new LocationDto(location.getId(), location.getName(), location.getAddress(), latitude, longitude);
        }

    }

    private double getLat(String location) {
        String[] geolocation = location.split(" ");
        if (geolocation.length == 2) {
            double latitude = Double.parseDouble(geolocation[0]);
            return latitude;
        } else {
            double longitude = 23.589920;
            return 0;
        }
    }

    private double getLng(String location) {
        String[] geolocation = location.split(" ");
        if (geolocation.length == 2) {
            double longitude = Double.parseDouble(geolocation[1]);
            return longitude;
        } else {
            return 0;
        }
    }

    public List<TourAttraction> getRandomTour() {
        Random rand = new Random();
        List<TourAttraction> attractions = new ArrayList<TourAttraction>();
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Attraction randomAttraction = attractionRepository.findAll()
                    .get(rand.nextInt(attractionRepository.findAll().size()));
            if (ids.contains(randomAttraction.getId())) {
                while (ids.contains(randomAttraction.getId())) {
                    randomAttraction = attractionRepository.findAll()
                            .get(rand.nextInt(attractionRepository.findAll().size()));
                }
            }
            ids.add(randomAttraction.getId());
            attractions.add(new TourAttraction(randomAttraction.getId(), randomAttraction.getName()
                    , getLat(randomAttraction.getLocation().getDetails())
                    , getLng(randomAttraction.getLocation().getDetails()), randomAttraction.getDetails()));
        }
        return attractions;
    }

    public List<TourAttraction> getDetailsOfTourAttraction(long id1, long id2, long id3, long id4, long id5) {
        List<TourAttraction> tourAttractions = new ArrayList<>();
        Optional<Attraction> attraction = attractionRepository.findById(id1);
        TourAttraction tourAttraction = new TourAttraction(attraction.get().getId(), attraction.get().getName()
                , getLat(attraction.get().getLocation().getDetails())
                , getLng(attraction.get().getLocation().getDetails()), attraction.get().getDetails());
        tourAttractions.add(tourAttraction);

        Optional<Attraction> attraction2 = attractionRepository.findById(id2);
        TourAttraction tourAttraction2 = new TourAttraction(attraction2.get().getId(), attraction2.get().getName()
                , getLat(attraction2.get().getLocation().getDetails())
                , getLng(attraction2.get().getLocation().getDetails()), attraction2.get().getDetails());
        tourAttractions.add(tourAttraction2);

        Optional<Attraction> attraction3 = attractionRepository.findById(id3);
        TourAttraction tourAttraction3 = new TourAttraction(attraction3.get().getId(), attraction3.get().getName()
                , getLat(attraction3.get().getLocation().getDetails())
                , getLng(attraction3.get().getLocation().getDetails()), attraction3.get().getDetails());
        tourAttractions.add(tourAttraction3);

        Optional<Attraction> attraction4 = attractionRepository.findById(id4);
        TourAttraction tourAttraction4 = new TourAttraction(attraction4.get().getId(), attraction4.get().getName()
                , getLat(attraction4.get().getLocation().getDetails())
                , getLng(attraction4.get().getLocation().getDetails()), attraction4.get().getDetails());
        tourAttractions.add(tourAttraction4);

        Optional<Attraction> attraction5 = attractionRepository.findById(id5);
        TourAttraction tourAttraction5 = new TourAttraction(attraction5.get().getId(), attraction5.get().getName()
                , getLat(attraction5.get().getLocation().getDetails())
                , getLng(attraction5.get().getLocation().getDetails()), attraction5.get().getDetails());
        tourAttractions.add(tourAttraction5);
        return tourAttractions;
    }
}

package ro.touristapp.backend.model.dto;

import java.util.List;

public class DetailsDto {
    String name;
    String details;
    String attractionType;
    List<String> Schedule;

    public DetailsDto(String name, String details, String attractionType, List<String> schedule) {
        this.name = name;
        this.details = details;
        this.attractionType = attractionType;
        Schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAttractionType() {
        return attractionType;
    }

    public void setAttractionType(String attractionType) {
        this.attractionType = attractionType;
    }

    public List<String> getSchedule() {
        return Schedule;
    }

    public void setSchedule(List<String> schedule) {
        Schedule = schedule;
    }
}

package ro.touristapp.backend.model.dto;

import java.util.List;

public class PreferencesDto {
    public List<Integer> ratings;

    public PreferencesDto(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public PreferencesDto() {
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }
}

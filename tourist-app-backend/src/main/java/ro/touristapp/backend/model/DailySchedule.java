package ro.touristapp.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class DailySchedule {
    @Id
    private Long id;
    private String working_day;
    private Timestamp openingHours;
    private Timestamp closingHours;

    @OneToMany(mappedBy = "mondaySchedule")
    @JsonManagedReference
    private List<WeeklySchedule> mondaysWeeklySchedules;

    @OneToMany(mappedBy = "tuesdaySchedule")
    @JsonManagedReference
    private List<WeeklySchedule> tuesdaysWeeklySchedules;

    @OneToMany(mappedBy = "wednesdaySchedule")
    @JsonManagedReference
    private List<WeeklySchedule> wednesdaysWeeklySchedules;

    @OneToMany(mappedBy = "thursdaySchedule")
    @JsonManagedReference
    private List<WeeklySchedule> thursdaysWeeklySchedules;

    @OneToMany(mappedBy = "fridaySchedule")
    @JsonManagedReference
    private List<WeeklySchedule> fridaysWeeklySchedules;

    @OneToMany(mappedBy = "saturdaySchedule")
    @JsonManagedReference
    private List<WeeklySchedule> saturdaysWeeklySchedules;

    @OneToMany(mappedBy = "sundaySchedule")
    @JsonManagedReference
    private List<WeeklySchedule> sundaysWeeklySchedules;


    public DailySchedule() {
    }

    public DailySchedule(Long id, String working_day, Timestamp openingHours, Timestamp closingHours, List<WeeklySchedule> mondaysWeeklySchedules, List<WeeklySchedule> tuesdaysWeeklySchedules, List<WeeklySchedule> wednesdaysWeeklySchedules, List<WeeklySchedule> thursdaysWeeklySchedules, List<WeeklySchedule> fridaysWeeklySchedules, List<WeeklySchedule> saturdaysWeeklySchedules, List<WeeklySchedule> sundaysWeeklySchedules) {
        this.id = id;
        this.working_day = working_day;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.mondaysWeeklySchedules = mondaysWeeklySchedules;
        this.tuesdaysWeeklySchedules = tuesdaysWeeklySchedules;
        this.wednesdaysWeeklySchedules = wednesdaysWeeklySchedules;
        this.thursdaysWeeklySchedules = thursdaysWeeklySchedules;
        this.fridaysWeeklySchedules = fridaysWeeklySchedules;
        this.saturdaysWeeklySchedules = saturdaysWeeklySchedules;
        this.sundaysWeeklySchedules = sundaysWeeklySchedules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorking_day() {
        return working_day;
    }

    public void setWorking_day(String working_day) {
        this.working_day = working_day;
    }

    public Timestamp getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Timestamp openingHours) {
        this.openingHours = openingHours;
    }

    public Timestamp getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(Timestamp closingHours) {
        this.closingHours = closingHours;
    }

    public List<WeeklySchedule> getMondaysWeeklySchedules() {
        return mondaysWeeklySchedules;
    }

    public void setMondaysWeeklySchedules(List<WeeklySchedule> mondaysWeeklySchedules) {
        this.mondaysWeeklySchedules = mondaysWeeklySchedules;
    }

    public List<WeeklySchedule> getTuesdaysWeeklySchedules() {
        return tuesdaysWeeklySchedules;
    }

    public void setTuesdaysWeeklySchedules(List<WeeklySchedule> tuesdaysWeeklySchedules) {
        this.tuesdaysWeeklySchedules = tuesdaysWeeklySchedules;
    }

    public List<WeeklySchedule> getWednesdaysWeeklySchedules() {
        return wednesdaysWeeklySchedules;
    }

    public void setWednesdaysWeeklySchedules(List<WeeklySchedule> wednesdaysWeeklySchedules) {
        this.wednesdaysWeeklySchedules = wednesdaysWeeklySchedules;
    }

    public List<WeeklySchedule> getThursdaysWeeklySchedules() {
        return thursdaysWeeklySchedules;
    }

    public void setThursdaysWeeklySchedules(List<WeeklySchedule> thursdaysWeeklySchedules) {
        this.thursdaysWeeklySchedules = thursdaysWeeklySchedules;
    }

    public List<WeeklySchedule> getFridaysWeeklySchedules() {
        return fridaysWeeklySchedules;
    }

    public void setFridaysWeeklySchedules(List<WeeklySchedule> fridaysWeeklySchedules) {
        this.fridaysWeeklySchedules = fridaysWeeklySchedules;
    }

    public List<WeeklySchedule> getSaturdaysWeeklySchedules() {
        return saturdaysWeeklySchedules;
    }

    public void setSaturdaysWeeklySchedules(List<WeeklySchedule> saturdaysWeeklySchedules) {
        this.saturdaysWeeklySchedules = saturdaysWeeklySchedules;
    }

    public List<WeeklySchedule> getSundaysWeeklySchedules() {
        return sundaysWeeklySchedules;
    }

    public void setSundaysWeeklySchedules(List<WeeklySchedule> sundaysWeeklySchedules) {
        this.sundaysWeeklySchedules = sundaysWeeklySchedules;
    }

}

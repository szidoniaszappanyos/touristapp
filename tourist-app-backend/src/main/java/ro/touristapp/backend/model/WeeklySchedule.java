package ro.touristapp.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class WeeklySchedule {
    @Id
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name = "monday",insertable=false, updatable=false)
    @JsonBackReference
    private DailySchedule mondaySchedule;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name = "tuesday" ,insertable=false, updatable=false)
    @JsonBackReference
    private DailySchedule tuesdaySchedule;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name = "wednesday",insertable=false, updatable=false)
    @JsonBackReference
    private DailySchedule wednesdaySchedule;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name = "thursday",insertable=false, updatable=false)
    @JsonBackReference
    private DailySchedule thursdaySchedule;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name = "friday",insertable=false, updatable=false)
    @JsonBackReference
    private DailySchedule fridaySchedule;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name = "saturday",insertable=false, updatable=false)
    @JsonBackReference
    private DailySchedule saturdaySchedule;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name = "sunday",insertable=false, updatable=false)
    @JsonBackReference
    private DailySchedule sundaySchedule;

    @OneToMany(mappedBy = "weeklySchedule")
    @JsonBackReference
    private List<Attraction> attractions;

    public WeeklySchedule() {
    }

    public WeeklySchedule(Long id, DailySchedule mondaySchedule, DailySchedule tuesdaySchedule, DailySchedule wednesdaySchedule, DailySchedule thursdaySchedule, DailySchedule fridaySchedule, DailySchedule saturdaySchedule, DailySchedule sundaySchedule, List<Attraction> attractions) {
        this.id = id;
        this.mondaySchedule = mondaySchedule;
        this.tuesdaySchedule = tuesdaySchedule;
        this.wednesdaySchedule = wednesdaySchedule;
        this.thursdaySchedule = thursdaySchedule;
        this.fridaySchedule = fridaySchedule;
        this.saturdaySchedule = saturdaySchedule;
        this.sundaySchedule = sundaySchedule;
        this.attractions = attractions;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DailySchedule getMondaySchedule() {
        return mondaySchedule;
    }

    public void setMondaySchedule(DailySchedule mondaySchedule) {
        this.mondaySchedule = mondaySchedule;
    }

    public DailySchedule getTuesdaySchedule() {
        return tuesdaySchedule;
    }

    public void setTuesdaySchedule(DailySchedule tuesdaySchedule) {
        this.tuesdaySchedule = tuesdaySchedule;
    }

    public DailySchedule getWednesdaySchedule() {
        return wednesdaySchedule;
    }

    public void setWednesdaySchedule(DailySchedule wednesdaySchedule) {
        this.wednesdaySchedule = wednesdaySchedule;
    }

    public DailySchedule getThursdaySchedule() {
        return thursdaySchedule;
    }

    public void setThursdaySchedule(DailySchedule thursdaySchedule) {
        this.thursdaySchedule = thursdaySchedule;
    }

    public DailySchedule getFridaySchedule() {
        return fridaySchedule;
    }

    public void setFridaySchedule(DailySchedule fridaySchedule) {
        this.fridaySchedule = fridaySchedule;
    }

    public DailySchedule getSaturdaySchedule() {
        return saturdaySchedule;
    }

    public void setSaturdaySchedule(DailySchedule saturdaySchedule) {
        this.saturdaySchedule = saturdaySchedule;
    }

    public DailySchedule getSundaySchedule() {
        return sundaySchedule;
    }

    public void setSundaySchedule(DailySchedule sundaySchedule) {
        this.sundaySchedule = sundaySchedule;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeeklySchedule that = (WeeklySchedule) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(mondaySchedule, that.mondaySchedule) &&
                Objects.equals(tuesdaySchedule, that.tuesdaySchedule) &&
                Objects.equals(wednesdaySchedule, that.wednesdaySchedule) &&
                Objects.equals(thursdaySchedule, that.thursdaySchedule) &&
                Objects.equals(fridaySchedule, that.fridaySchedule) &&
                Objects.equals(saturdaySchedule, that.saturdaySchedule) &&
                Objects.equals(sundaySchedule, that.sundaySchedule) &&
                Objects.equals(attractions, that.attractions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mondaySchedule, tuesdaySchedule, wednesdaySchedule, thursdaySchedule, fridaySchedule, saturdaySchedule, sundaySchedule, attractions);
    }

    @Override
    public String toString() {
        return "WeeklySchedule{" +
                "id=" + id +
                ", mondaySchedule=" + mondaySchedule +
                ", tuesdaySchedule=" + tuesdaySchedule +
                ", wednesdaySchedule=" + wednesdaySchedule +
                ", thursdaySchedule=" + thursdaySchedule +
                ", fridaySchedule=" + fridaySchedule +
                ", saturdaySchedule=" + saturdaySchedule +
                ", sundaySchedule=" + sundaySchedule +
                ", attractions=" + attractions +
                '}';
    }
}

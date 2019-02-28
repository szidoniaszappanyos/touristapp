package ro.touristapp.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Picture {

    @Id
    private Long id;
    private String fileName;
    private String description;

    @ManyToMany(mappedBy = "pictures")
    @JsonBackReference
    private List<Attraction> attractions;

    public Picture() {
    }

    public Picture(Long id, String fileName, String description) {
        this.id = id;
        this.fileName = fileName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Picture picture = (Picture) o;
        return Objects.equals(id, picture.id) &&
                Objects.equals(fileName, picture.fileName) &&
                Objects.equals(description, picture.description) &&
                Objects.equals(attractions, picture.attractions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, description, attractions);
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", attractions=" + attractions +
                '}';
    }
}

package ro.touristapp.backend.model.dto;

public class AttractionAllDto {
    private Long id;
    private String name;
    private String details;
    private String pictureFileName;

    public AttractionAllDto(Long id, String name, String details, String pictureFileName) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.pictureFileName = pictureFileName;
    }

    public AttractionAllDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }
}

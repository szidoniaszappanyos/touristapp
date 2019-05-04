package ro.touristapp.backend.model.dto;

public class PictureDto {
    private Long id;
    private String fileName;
    private String description;

    public PictureDto(Long id, String fileName, String description) {
        this.id = id;
        this.fileName = fileName;
        this.description = description;
    }

    public PictureDto() {
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
}

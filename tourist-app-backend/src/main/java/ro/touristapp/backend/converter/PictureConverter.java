package ro.touristapp.backend.converter;

import org.springframework.stereotype.Component;
import ro.touristapp.backend.model.Picture;
import ro.touristapp.backend.model.dto.PictureDto;

@Component
public class PictureConverter {
    public PictureDto convertToDto(Picture picture) {
        if (picture == null) {
            return null;
        }
        PictureDto pictureDto = new PictureDto(picture.getId(), picture.getFileName(), picture.getDescription());
        return pictureDto;
    }
}

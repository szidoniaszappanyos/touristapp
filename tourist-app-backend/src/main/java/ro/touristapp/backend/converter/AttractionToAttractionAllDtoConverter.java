package ro.touristapp.backend.converter;

import org.springframework.stereotype.Component;
import ro.touristapp.backend.model.Attraction;
import ro.touristapp.backend.model.dto.AttractionAllDto;

@Component
public class AttractionToAttractionAllDtoConverter {
    public AttractionAllDto toDto(Attraction attraction){
        if(attraction==null){
            return null;
        }
        AttractionAllDto attractionAllDto = new AttractionAllDto();
        attractionAllDto.setId(attraction.getId());
        attractionAllDto.setDetails(attraction.getDetails());
        attractionAllDto.setName(attraction.getName());
        if(!attraction.getPictures().isEmpty()){
            attractionAllDto.setPictureFileName(attraction.getPictures().get(0).getFileName());
        }
        else{
            attractionAllDto.setPictureFileName(null);
        }
        return attractionAllDto;
    }
}

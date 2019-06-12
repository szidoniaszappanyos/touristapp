package ro.touristapp.backend.converter;

import org.springframework.stereotype.Component;
import ro.touristapp.backend.model.Attraction;
import ro.touristapp.backend.model.dto.AttractionAllDto;

import java.util.Random;

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
            String[] defaultPictures = {"town.png","town2.png", "town3.png"};
            Random rand = new Random();
            int randomNum = rand.nextInt((3 - 1) + 1) + 1;
            attractionAllDto.setPictureFileName(defaultPictures[randomNum-1]);
        }
        return attractionAllDto;
    }
}

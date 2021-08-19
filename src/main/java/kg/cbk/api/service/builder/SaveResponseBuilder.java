package kg.cbk.api.service.builder;

import kg.cbk.api.entity.dto.RequestDto;
import kg.cbk.api.entity.dto.SaveResponseDto;
import org.springframework.stereotype.Component;

@Component
public class SaveResponseBuilder {
   public SaveResponseDto convertToXml(RequestDto dto){
       return SaveResponseDto.builder()
               .response_id(dto.getId())
               .date(dto.getDate())
               .status(1)
               .message("PAYMENT CONFIRMED")
               .build();
   }
}

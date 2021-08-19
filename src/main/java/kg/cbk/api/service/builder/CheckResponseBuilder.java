package kg.cbk.api.service.builder;

import kg.cbk.api.entity.Request;
import kg.cbk.api.entity.dto.CheckResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CheckResponseBuilder {

    public CheckResponseDto convertTo(Request dto){
        return CheckResponseDto.builder()
                .responseId(dto.getId())
                .date(dto.getDate())
                .status(0)
                .message("ACCOUNT EXISTS")
                .build();
    }
}

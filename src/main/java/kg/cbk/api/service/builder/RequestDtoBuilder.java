package kg.cbk.api.service.builder;

import kg.cbk.api.entity.Request;
import kg.cbk.api.entity.dto.RequestDto;
import org.springframework.stereotype.Component;

@Component
public class RequestDtoBuilder {
    public RequestDto convertToDto(Request request) {
        return RequestDto.builder()
                .id(request.getId())
                .supplierId(request.getSupplierId())
                .account(request.getAccount())
                .amount(request.getAmount())
                .command(request.getCommand())
                .date(request.getDate())
                .build();
    }
}

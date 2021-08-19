package kg.cbk.api.entity.dto;

import kg.cbk.api.entity.enums.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    private Long id;
    private Long supplierId;
    private String account;
    private Long amount;
    private Command command;
    private LocalDateTime date;
}

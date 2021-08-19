package kg.cbk.api.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class SaveResponseDto {
    private Long response_id;
    private int status;
    private String message;
    private LocalDateTime date;
}

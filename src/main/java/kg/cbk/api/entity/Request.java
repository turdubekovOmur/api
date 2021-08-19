package kg.cbk.api.entity;

import jdk.jfr.Timestamp;
import kg.cbk.api.entity.enums.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
public class Request {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Long supplierId;

    @NonNull
    private String account;

    @NonNull
    private Long amount;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Command command;

    @NonNull
    @Timestamp
    private LocalDateTime date;

}

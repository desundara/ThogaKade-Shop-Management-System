package model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    private String id;
    private LocalDate date;
    private String customerId;
}

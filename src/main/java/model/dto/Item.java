package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
    private String code;
    private String description;
    private String packSize;
    private Double unitPrice;
    private Integer qty;
}

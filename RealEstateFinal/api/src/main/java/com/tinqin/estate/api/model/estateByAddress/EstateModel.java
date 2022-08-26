package com.tinqin.estate.api.model.estateByAddress;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class EstateModel {
    private String estateName;
   /* private String address;*/
    private Double price;
    private Double size;
}

package com.tinqin.estate.api.model.typeEstate;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class TypeEstateResponse {
    private String typeEstate;
}

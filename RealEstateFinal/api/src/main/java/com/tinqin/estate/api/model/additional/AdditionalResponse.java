package com.tinqin.estate.api.model.additional;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalResponse {
    private String typeAddition;
}

package com.tinqin.estate.api.model.typeContract;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class TypeContractRequest {
    private Long typeContractID;
}

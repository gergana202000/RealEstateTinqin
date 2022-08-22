package com.tinqin.estate.api.model.estate;

import com.tinqin.estate.api.base.OperationInput;
import lombok.*;
@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class EstateRequest implements OperationInput {
    private String address;

}

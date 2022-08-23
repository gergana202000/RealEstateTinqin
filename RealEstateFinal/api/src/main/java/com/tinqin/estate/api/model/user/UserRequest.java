package com.tinqin.estate.api.model.user;

import com.tinqin.estate.api.base.OperationInput;
import com.tinqin.estate.api.base.OperationProcessor;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)

public class UserRequest implements OperationInput {
    private String username;
}

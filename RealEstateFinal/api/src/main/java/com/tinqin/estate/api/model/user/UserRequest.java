package com.tinqin.estate.api.model.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)

public class UserRequest {
    private Long userID;
}

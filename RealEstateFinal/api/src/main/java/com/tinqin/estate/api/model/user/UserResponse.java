package com.tinqin.estate.api.model.user;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String name;
    private String lastName;
    private String phone;
    private String email;
}

package com.tinqin.estate.api.model.userByUsername;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}

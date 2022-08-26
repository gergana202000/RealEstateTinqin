package com.tinqin.estate.core.converter;

import com.tinqin.estate.api.model.user.UserResponse;
import com.tinqin.estate.domain.data.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class UserToUserResponseConverter implements Converter<User, UserResponse> {
    @Override
    public UserResponse convert(User source) {
        return UserResponse.builder()
                .name(source.getName())
                .lastName(source.getLastName())
                .phone(source.getPhone())
                .email(source.getEmail())
                .build();
    }
}

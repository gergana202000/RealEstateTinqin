package com.tinqin.estate.domain.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<Estate> estates;
    @OneToMany(mappedBy = "user")
    private Set<Contract> contracts;

    public User(){}

    public User(String username, String password, String name, String lastName, String phone, String email, Set<Estate> estates, Set<Contract> contracts) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.estates = estates;
        this.contracts = contracts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(estates, user.estates) && Objects.equals(contracts, user.contracts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, name, lastName, phone, email, estates, contracts);
    }
}

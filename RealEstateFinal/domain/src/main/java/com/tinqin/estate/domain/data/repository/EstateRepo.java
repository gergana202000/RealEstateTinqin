package com.tinqin.estate.domain.data.repository;

import com.tinqin.estate.domain.data.entity.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstateRepo extends JpaRepository<Estate, Long> {
    /*Optional<Estate> findEstateByAddress(String estateName);*/
    Optional<Estate> findEstateByAddress(String address);
    /*List<Estate> findEstateByAddress(Estate address);*/
}

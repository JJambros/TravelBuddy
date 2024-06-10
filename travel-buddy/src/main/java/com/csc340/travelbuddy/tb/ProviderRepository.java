package com.csc340.travelbuddy.tb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {
    Optional<Provider> findByEmailAndPassword(String email, String password);
}

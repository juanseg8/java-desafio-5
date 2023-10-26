package com.desafio.desafio3.Models.Repositories;

import com.desafio.desafio3.Models.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByNombre(String nombre);

    Boolean existsByCelular(Integer celular);

    Optional<UserEntity> findOneByEmail(String email);

    boolean existsByEmail(String email);
}

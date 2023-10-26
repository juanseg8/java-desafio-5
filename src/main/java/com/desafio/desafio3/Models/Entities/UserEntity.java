package com.desafio.desafio3.Models.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "nombre", columnDefinition = "VARCHAR(100)")
    private String nombre;

    @Column(name = "celular", columnDefinition = "INT")
    private Integer celular;

    @Column(name = "email", columnDefinition = "INT")
    private String email;

    @Column(name = "contraseña", columnDefinition = "INT")
    private String password;

    @Column(name = "direccion", columnDefinition = "INT")
    private Integer addDireccion;


}


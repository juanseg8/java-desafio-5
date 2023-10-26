package com.desafio.desafio3.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddDTO {
    private String nombre;
    private Integer celular;
    private String email;
    private String password;
}

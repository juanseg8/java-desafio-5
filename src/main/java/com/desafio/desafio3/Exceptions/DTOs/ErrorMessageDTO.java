package com.desafio.desafio3.Exceptions.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorMessageDTO {
    private String message;
    private int id;
}

package com.desafio.desafio3.Models.Mapers;

import com.desafio.desafio3.Models.DTOs.UserAddDTO;
import com.desafio.desafio3.Models.DTOs.UserReadDTO;
import com.desafio.desafio3.Models.Entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserReadDTO userEntityToUserReadDTO(UserEntity userEntity) {
        UserReadDTO userReadDTO = new UserReadDTO();
        userReadDTO.setId(userEntity.getId());
        userReadDTO.setNombre(userEntity.getNombre());
        userReadDTO.setCelular(userEntity.getCelular());
        return userReadDTO;
    }

    public UserEntity userAddDTOToUserEntity(UserAddDTO userAddDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNombre(userAddDTO.getNombre());
        userEntity.setCelular(userAddDTO.getCelular());
        return userEntity;
    }
}

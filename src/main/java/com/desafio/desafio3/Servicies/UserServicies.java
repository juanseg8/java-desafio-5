package com.desafio.desafio3.Servicies;

import com.desafio.desafio3.Exceptions.ExceptionsKinds.UserBadRequestException;
import com.desafio.desafio3.Exceptions.ExceptionsKinds.UserNotFoundException;
import com.desafio.desafio3.Models.DTOs.MessageUserAddDTO;
import com.desafio.desafio3.Models.DTOs.UserEditDTO;
import com.desafio.desafio3.Models.DTOs.UserAddDTO;
import com.desafio.desafio3.Models.DTOs.UserReadDTO;
import com.desafio.desafio3.Models.Entities.UserEntity;
import com.desafio.desafio3.Models.Mapers.UserMapper;
import com.desafio.desafio3.Models.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServicies {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServicies(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public List<UserReadDTO> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::userEntityToUserReadDTO)
                .collect(Collectors.toList());
    }

    public MessageUserAddDTO add(UserAddDTO userAddDTO) {
        Boolean nombreExist = userRepository.existsByNombre(userAddDTO.getNombre());
        Boolean celularExist = userRepository.existsByCelular(userAddDTO.getCelular());

        if(nombreExist) throw new UserBadRequestException("Ya existe un contacto con ese nombre");
        if(celularExist) throw new UserBadRequestException("Ya existe un contacto con ese celular");

        MessageUserAddDTO messageUserAddDTO = new MessageUserAddDTO();
        UserEntity user = userRepository.save(userMapper.userAddDTOToUserEntity(userAddDTO));
        UserReadDTO userDTO = userMapper.userEntityToUserReadDTO(user);
        messageUserAddDTO.setUser(userDTO);
        messageUserAddDTO.setMessage("Se añadio exitosamente");
        return messageUserAddDTO;
    }

    public UserReadDTO findById(Integer id) {
        return userRepository
                .findById(id)
                .map(userEntity -> userMapper.userEntityToUserReadDTO(userEntity))
                .orElseThrow(() -> new UserNotFoundException("No se encontro un contacto con ese id"));
    }

    public UserReadDTO deleteById(Integer id) {
        try {
            UserEntity user = userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("No se encontro el contacto con ese id"));

            userRepository.delete(user);

            return userMapper.userEntityToUserReadDTO(user);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public UserReadDTO edit(Integer id, UserEditDTO user) {
        try {
            UserEntity editUser = userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("No se encontro el contacto con ese id"));

            if(Objects.nonNull(user.getNombre())) editUser.setNombre(user.getNombre());
            if(Objects.nonNull(user.getCelular())) editUser.setCelular(user.getCelular());

            UserEntity newUser = userRepository.save(editUser);

            return userMapper.userEntityToUserReadDTO(newUser);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

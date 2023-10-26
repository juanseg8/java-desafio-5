package com.desafio.desafio3.Controllers;

import com.desafio.desafio3.Models.DTOs.MessageUserAddDTO;
import com.desafio.desafio3.Models.DTOs.UserEditDTO;
import com.desafio.desafio3.Models.DTOs.UserAddDTO;
import com.desafio.desafio3.Models.DTOs.UserReadDTO;
import com.desafio.desafio3.Servicies.UserServicies;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
public class UserController {

    private final UserServicies userServicies;

    public UserController(UserServicies userServicies) {
        this.userServicies = userServicies;
    }

    @GetMapping
    public ResponseEntity<List<UserReadDTO>> findAllUsers(){
        return ResponseEntity.ok(userServicies.findAll());
    }

    @PostMapping
    public ResponseEntity<MessageUserAddDTO> add(@RequestBody UserAddDTO userAddDTO){
        return ResponseEntity.ok(userServicies.add(userAddDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReadDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userServicies.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserReadDTO> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(userServicies.deleteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReadDTO> edit(
            @PathVariable Integer id,
            @RequestBody UserEditDTO user) {
        return ResponseEntity.ok(userServicies.edit(id,user));
    }


}





package com.edsonteles.Workshopmongo.Resources;

import com.edsonteles.Workshopmongo.Domain.User;
import com.edsonteles.Workshopmongo.Dto.UserDTO;
import com.edsonteles.Workshopmongo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);
        UserDTO userDto = new UserDTO(user);
        return ResponseEntity.ok().body(userDto);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        user = userService.save(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        userDTO.setId(id);
        user = userService.update(user);

        return ResponseEntity.noContent().build();
    }
}

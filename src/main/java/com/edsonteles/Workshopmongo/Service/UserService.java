package com.edsonteles.Workshopmongo.Service;

import com.edsonteles.Workshopmongo.Domain.User;
import com.edsonteles.Workshopmongo.Exception.ObjectNotFoundException;
import com.edsonteles.Workshopmongo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        List<User> user = userRepository.findAll();
        return user;
    }

    public User findById(String id){
        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return user;
    }
}

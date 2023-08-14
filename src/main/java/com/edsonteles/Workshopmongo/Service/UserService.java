package com.edsonteles.Workshopmongo.Service;

import com.edsonteles.Workshopmongo.Domain.User;
import com.edsonteles.Workshopmongo.Dto.UserDTO;
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

    public User save(User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj){
        User updUser = findById(obj.getId());
        updateData(updUser, obj);
        return userRepository.save(updUser);
    }

    private void updateData(User updUser, User obj) {
        updUser.setName(obj.getName());
        updUser.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}

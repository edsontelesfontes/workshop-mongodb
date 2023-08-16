package com.edsonteles.Workshopmongo.Service;

import com.edsonteles.Workshopmongo.Domain.Post;
import com.edsonteles.Workshopmongo.Domain.User;
import com.edsonteles.Workshopmongo.Dto.UserDTO;
import com.edsonteles.Workshopmongo.Exception.ObjectNotFoundException;
import com.edsonteles.Workshopmongo.Repository.PostRepository;
import com.edsonteles.Workshopmongo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return post;
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }

}

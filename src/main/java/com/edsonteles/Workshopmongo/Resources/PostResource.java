package com.edsonteles.Workshopmongo.Resources;

import com.edsonteles.Workshopmongo.Domain.Post;
import com.edsonteles.Workshopmongo.Resources.Util.URL;
import com.edsonteles.Workshopmongo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);

        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titleserch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text") String text){
        URL.decodeParam(text);

        List<Post> post = postService.findByTitle(text);
        return ResponseEntity.ok().body(post);
    }
}

package com.example.springbootlabs.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
//@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/comments")
    public List<Comment> getComment(){

        return commentRepository.findAll();
    }

    @GetMapping("/comments/{id}")
    public Optional<Comment> getSingleComment(@PathVariable Long id){
        return commentRepository.findById(id);
    }
}

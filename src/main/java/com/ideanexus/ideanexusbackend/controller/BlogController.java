package com.ideanexus.ideanexusbackend.controller;


import com.ideanexus.ideanexusbackend.model.Blog;
import com.ideanexus.ideanexusbackend.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping()
    public ResponseEntity<List<Blog>> getBlogs(){

        return new ResponseEntity<>(blogService.getBlogs(), HttpStatus.OK);

    }

    @GetMapping("/title")
    public ResponseEntity<List<Blog>> getBlogsByTitle(@RequestParam String title){

        return new ResponseEntity<>(blogService.getBlogsByTitleContains(title), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer id){
        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog newBlog){
        return new ResponseEntity<>(blogService.saveBlog(newBlog),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id){
        blogService.deleteBlogById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Integer id, @RequestBody Blog updateBlog){
        return new ResponseEntity<>(blogService.updateBlogById(id,updateBlog),HttpStatus.OK);

    }

}

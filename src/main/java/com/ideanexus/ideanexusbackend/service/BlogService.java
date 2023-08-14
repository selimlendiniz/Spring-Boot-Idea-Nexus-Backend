package com.ideanexus.ideanexusbackend.service;

import com.ideanexus.ideanexusbackend.exception.DataBadRequestException;
import com.ideanexus.ideanexusbackend.exception.BlogNotFoundException;
import com.ideanexus.ideanexusbackend.model.Blog;
import com.ideanexus.ideanexusbackend.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getBlogs(){

            return blogRepository.findAll();

    }

    public List<Blog> getBlogsByTitleContains(String title){

        return blogRepository.findBlogsByTitleContains(title);

    }

    public Blog saveBlog(Blog newBlog){

        if (newBlog.getTitle() == null){
            throw new DataBadRequestException("Title is required");
        }

        return blogRepository.save(newBlog);
    }

    public void deleteBlogById(Integer id){
        blogRepository.deleteById(id);
    }

    public Blog updateBlogById(Integer id, Blog updatedBlog){

        Blog oldBlog = blogRepository.getBlogById(id);
        oldBlog.setTitle(updatedBlog.getText());
        oldBlog.setText(updatedBlog.getText());



        return blogRepository.save(oldBlog);
    }

    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found with id: " + id));
    }

}

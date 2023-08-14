package com.ideanexus.ideanexusbackend.repository;

import com.ideanexus.ideanexusbackend.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    public Blog getBlogById(Integer id);

    public List<Blog> findBlogsByTitleContains(String title);


}

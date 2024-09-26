package com.example.demo.dao;

import com.example.demo.model.dbentities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoService extends JpaRepository<Book,Long> {
}

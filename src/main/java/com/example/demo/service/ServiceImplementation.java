package com.example.demo.service;

import com.example.demo.dao.RepoService;
import com.example.demo.model.dbentities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class ServiceImplementation {

    RepoService repoService;

    public ServiceImplementation(RepoService repoService){
        this.repoService = repoService;
    }

    public List<Book> getBookInformation(){
        return repoService.findAll();
    }
}

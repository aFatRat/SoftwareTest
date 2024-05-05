package com.example.softwaretest.repository;

import com.example.softwaretest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findFirstByNameAndAuthor(String name,String author);
}

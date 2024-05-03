package com.example.softwaretest.repository;


import com.example.softwaretest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {

}

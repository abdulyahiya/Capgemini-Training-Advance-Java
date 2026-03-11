package com.spring.REST.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.REST.security.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}

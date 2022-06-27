package com.example.bookstore.DAO;

import com.example.bookstore.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Integer> {

}
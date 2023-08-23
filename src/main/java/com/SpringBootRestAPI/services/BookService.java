package com.SpringBootRestAPI.services;

import com.SpringBootRestAPI.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1,"Java","ABC"));
        list.add(new Book(2,"Spring","XYZ"));
        list.add(new Book(3,"Python","PQR"));
        list.add(new Book(4,"AWS","HJK"));
    }

    //to get all the books
    public List<Book> getAllBooks(){
        return list;
    }

    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        book=list.stream().filter(i->i.getId()==id).findFirst().get();
        return book;
    }

    //to add book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    //to delete book
    public void deleteBook(int bid){
        list=list.stream().filter(book ->book.getId()!=bid).collect(Collectors.toList());
    }

    //to update book
    public void updateBook(Book book,int bookId){
        list=list.stream().map(b->{
            if (b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());


    }

}

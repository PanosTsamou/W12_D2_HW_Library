package com.codeclan.example;

import java.util.ArrayList;

public class Borrower {
    private String name;
    private ArrayList<Book> myBooks;

    public Borrower(String name){
        this.name = name;
        this.myBooks = new ArrayList<>();
    }

    public void  borrowBooksFromLibrary(Library library, Book book){
        Book borrowedBook = library.borrowBook(book);
        if (borrowedBook != null){
            this.myBooks.add( borrowedBook);
        }

    }
    public int getHowManyBooksHas(){
        return this.myBooks.size();
    }
}

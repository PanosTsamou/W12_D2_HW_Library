package com.codeclan.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> libra;
    private int capasity;
    private HashMap<String,Integer> trackBooksByGenre;

    public Library(ArrayList<Book> libra){
        this.libra = libra;
        this.capasity = 6;
        trackBooksByGenre = new HashMap<>();
    }

    public int getTheSize(){
        return this.libra.size();
    }

    public void addBookInLibrary( Book  book){
        if(checkCapasity()){
            this.libra.add(book);
        }
    }

    public Boolean checkCapasity(){
        if (this.libra.size()< capasity){
            return true;
        }
        return false;
    }

    public Book borrowBook(Book book){
        int index = libra.indexOf(book);
        if(index >= 0){
            return this.libra.remove(index);
        }
        return  null;
    }

    public void setTrackBooksByGenre(){
        ArrayList<String> allKeys = new ArrayList<>();
        for(Book book : this.libra){
            if (allKeys.contains(book.getGenre())){
               int value =  trackBooksByGenre.get(book.getGenre()) +1;
               trackBooksByGenre.put(book.getGenre(), value);
            }else {
                trackBooksByGenre.put(book.getGenre(), 1);
                allKeys.add(book.getGenre());
            }
        }
    }

    public int getTheNumberOfBooksOfGenre(String genre){
        return this.trackBooksByGenre.get(genre);
    }
}

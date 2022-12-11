package org.example.dao;

public class GenreDTO {
    private String name;
    private int ID;

    public GenreDTO(int ID, String name){
        this.name = name;
        this.ID = ID;
    }

    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
}

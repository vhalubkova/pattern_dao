package org.example.dao;

public class ArtistDTO {
    private String name;
    private int ID;

    public ArtistDTO(int ID,String name){
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

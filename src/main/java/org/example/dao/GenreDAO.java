package org.example.dao;

import java.util.ArrayList;

public class GenreDAO {
    private volatile static GenreDAO instance;
    public ArrayList<GenreDTO> genres = new ArrayList<>();

    private GenreDAO(){

        genres.add(new GenreDTO(101,"Classic"));
        genres.add(new GenreDTO(102,"Jazz"));
        genres.add(new GenreDTO(103,"Folk"));
        genres.add(new GenreDTO(104,"Rock"));
        genres.add(new GenreDTO(105,"Indie"));
        genres.add(new GenreDTO(106,"Blues"));
        genres.add(new GenreDTO(107,"Electro"));
        genres.add(new GenreDTO(108,"Funk"));
        genres.add(new GenreDTO(109,"Techno"));
        genres.add(new GenreDTO(110,"Rap"));
    }

    public ArrayList<GenreDTO> getAll(){
        return genres;
    }

    public boolean isGenreExists(int ID){
        for(GenreDTO genre:genres){
            if(ID == genre.getID()){
                return true;
            }
        }
        return false;
    }

    public static GenreDAO getInstance(){
        if(instance == null){
            synchronized (GenreDAO.class){
                if(instance==null){
                    instance = new GenreDAO();
                }
            }
        }
        return instance;
    }
}

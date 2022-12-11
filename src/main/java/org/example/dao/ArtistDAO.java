package org.example.dao;

import java.util.ArrayList;

public class ArtistDAO {
    private volatile static ArtistDAO instance;

    public ArrayList<ArtistDTO> artists = new ArrayList<>();

    private ArtistDAO() {
        artists.add(new ArtistDTO(1, "Aerosmith"));
        artists.add(new ArtistDTO(2, "Thegiornalisti"));
        artists.add(new ArtistDTO(3, "Chris Rea"));
        artists.add(new ArtistDTO(4, "Paul Mauriat"));

    }

    public ArrayList<ArtistDTO> getAll() {
        return artists;
    }


    public static ArtistDAO getInstance() {
        if (instance == null) {
            synchronized (ArtistDAO.class) {
                if (instance == null) {
                    instance = new ArtistDAO();
                }
            }
        }
        return instance;
    }
}

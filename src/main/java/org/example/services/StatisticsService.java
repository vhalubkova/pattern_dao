package org.example.services;

import org.example.dao.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class StatisticsService implements IStatisticsService{
    private volatile static StatisticsService instance;
    ArrayList<VoteDTO> Results = VoteDAO.getInstance().read();

    public ArrayList<ArtistResultsDTO> getArtists(){
        HashMap<Integer,Integer> statArtist = new HashMap();
        for(VoteDTO result:Results){
            if(statArtist.containsKey(result.getArtistID())){
                statArtist.put(result.getArtistID(),statArtist.get(result.getArtistID()) + 1);
            }else{
                statArtist.put(result.getArtistID(),1);
            }
        }
        ArrayList<ArtistResultsDTO> artistList = new ArrayList<>();
        for(ArtistDTO artist: ArtistDAO.getInstance().getAll()){
            artistList.add(new ArtistResultsDTO(artist.getName(),statArtist.get(artist.getID())));
        }
        artistList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return artistList;
    }

    public ArrayList<GenreResultsDTO> getGenres(){
        HashMap<Integer,Integer> statGenres = new HashMap();
        for(VoteDTO result:Results){
            for(int ID:result.getGenreID()){
                if(statGenres.containsKey(ID)){
                    statGenres.put(ID,statGenres.get(ID)+1);
                } else{
                    statGenres.put(ID,1);
                }
            }
        }
        ArrayList<GenreResultsDTO> genreList = new ArrayList<>();
        for(GenreDTO genre: GenreDAO.getInstance().getAll()){
            genreList.add(new GenreResultsDTO(genre.getName(),statGenres.get(genre.getID())));
        }
        genreList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return genreList;
    }
    public ArrayList<AboutUserResultsDTO> getAboutUser(){
        ArrayList<AboutUserResultsDTO> aboutUserList = new ArrayList<>();
        for(VoteDTO result:Results){
            aboutUserList.add(new AboutUserResultsDTO(result.getDate(),result.gettextAboutUser()));
        }
        aboutUserList.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        return aboutUserList;
    }

    public static StatisticsService getInstance(){
        if(instance == null){
            synchronized (StatisticsService.class){
                if(instance==null){
                    instance = new StatisticsService();
                }
            }
        }
        return instance;
    }
}

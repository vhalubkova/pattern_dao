package org.example.services;

import java.util.ArrayList;

// возвращает таблицу/ы с результатом
public interface IStatisticsService {
    public ArrayList<ArtistResultsDTO> getArtists();
    public ArrayList<GenreResultsDTO> getGenres();
    public ArrayList<AboutUserResultsDTO> getAboutUser();
}

package org.example.viewer;

import org.example.services.AboutUserResultsDTO;
import org.example.services.ArtistResultsDTO;
import org.example.services.GenreResultsDTO;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultCreator {

    public String create(ArrayList<ArtistResultsDTO> sortedArtists,ArrayList<GenreResultsDTO> sortedGenres,ArrayList<AboutUserResultsDTO> sortedInfoAboutUser){
        String s = "<p>Рейтинг исполнителей:</b></p><table><tbody><tr><th>Исполнитель</th><th>Кол-во голосов</th></tr>";
        for(ArtistResultsDTO artist: sortedArtists){
            s = s + "<tr><td>" + artist.getName() + "</td><td>" + artist.getValue() + "</td></tr>";
        }
        s = s + "</tbody></table>";

        String p = "<p>Рейтинг жанров:</b></p><table><tbody><tr><th>Жанр</th><th>Кол-во голосов</th></tr>";
        for(GenreResultsDTO genre: sortedGenres){
            p =p + "<tr><td>" + genre.getName() + "</td><td>" + genre.getValue() + "</td></tr>";
        }
        p = p + "</tbody></table>";

        String t = "<p>Информация о голосующих</b></p><table><tbody><tr><th>Дата</th><th>Информация</th></tr>";
        for(AboutUserResultsDTO info: sortedInfoAboutUser){
            t =t + "<tr><td>" + info.getDate() + "</td><td>" + info.getText() + "</td></tr>";
        }
        t = t + "</tbody></table>";

        String resp = s + "<Br>" + p + "<Br>" + t + "<Br>";

        return resp;
    }



}

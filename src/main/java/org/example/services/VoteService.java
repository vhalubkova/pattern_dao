package org.example.services;

import org.example.dao.ArtistDAO;
import org.example.dao.GenreDAO;
import org.example.dao.VoteDAO;
import org.example.dao.VoteDTO;
import org.example.helpers.TypeCheck;
import org.example.services.exceptions.ValidationException;

import java.util.Map;

public class VoteService implements IVoteService {
    private volatile static VoteService instance;

    public void save(Map<String, String[]> map) throws Exception {
        VoteDTO voteDTO = new VoteDTO();

        String[] s = map.get("artist");
        if (s == null ) {
            throw new ValidationException("Исполнитель не выбран");
        }
        if (s.length != 1) {
            throw new ValidationException("Можно проголосовать только за одного исполнителя");
        }
        if(!TypeCheck.checkIsInteger(s[0])){
            throw new ValidationException("not Integer");
        }
        int artistID = Integer.parseInt(s[0]);
        if(!ArtistDAO.getInstance().isArtistExists(artistID)){
            throw new ValidationException("artist do not exist");
        }
        voteDTO.setArtist(artistID);


        String[] v = map.get("genre");
        if (v == null ) {
            throw new ValidationException("Жанр не выбран");
        }
        if (v.length < 3 || v.length > 5) {
            throw new ValidationException("Необходимо выбрать 3-5 жанров");
        }
        int[] genreIDs = new int[v.length];
        for (int i = 0; i < v.length; i++) {
            if(!TypeCheck.checkIsInteger(v[i])){
                throw new ValidationException("not Integer");
            }
            genreIDs[i] = Integer.parseInt(v[i]);
            if(!GenreDAO.getInstance().isGenreExists(genreIDs[i])){
                throw new ValidationException("genre do not exist");
            }
        }

        voteDTO.setGenre(genreIDs);

        String[] t = map.get("text");
        if (t == null ) {
            throw new ValidationException("Информация о себе не введена");
        }
        if (t.length != 1) {
            throw new ValidationException("text size error");
        }
        voteDTO.settextAboutUser(t[0]);
        voteDTO.setDate();

        VoteDAO.getInstance().create(voteDTO);
    }

    public static VoteService getInstance() {
        if (instance == null) {
            synchronized (VoteService.class) {
                if (instance == null) {
                    instance = new VoteService();
                }
            }
        }
        return instance;
    }
}

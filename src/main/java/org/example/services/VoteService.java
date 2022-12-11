package org.example.services;

import org.example.dao.VoteDAO;
import org.example.dao.VoteDTO;

import java.io.IOException;
import java.util.Map;

public class VoteService implements IVoteService {
    private volatile static VoteService instance;

    public void save(Map<String, String[]> map) throws IOException {
        VoteDTO voteDTO = new VoteDTO();

        String[] s = map.get("artist");
        if (s.length != 1) {
            throw new IOException();
        }
        int artistID = Integer.parseInt(s[0]);
        voteDTO.setArtist(artistID);

        String[] v = map.get("genre");
        if (v.length < 3 || v.length > 5) {
            throw new IOException();
        }
        int[] genreIDs = new int[v.length];
        for (int i = 0; i < v.length; i++) {
            genreIDs[i] = Integer.parseInt(v[i]);
        }
        voteDTO.setGenre(genreIDs);

        String[] t = map.get("text");
        if (t.length != 1) {
            throw new IOException();
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

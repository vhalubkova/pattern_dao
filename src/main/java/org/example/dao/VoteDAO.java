package org.example.dao;

import java.util.ArrayList;

public class VoteDAO {
    private volatile static VoteDAO instance;
    private ArrayList<VoteDTO> votes = new ArrayList<>();

    public void create(VoteDTO vote){
        votes.add(vote);
    }



    public static VoteDAO getInstance(){
        if(instance == null){
            synchronized (VoteDAO.class){
                if(instance==null){
                    instance = new VoteDAO();
                }
            }
        }
        return instance;
    }
}

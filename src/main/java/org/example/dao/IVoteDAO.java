package org.example.dao;

import java.util.ArrayList;

public interface IVoteDAO {
    public ArrayList<VoteDTO> read();
    public void create(VoteDTO vote);
}

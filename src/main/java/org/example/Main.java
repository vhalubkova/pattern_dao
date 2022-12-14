package org.example;

import org.example.services.IVoteService;
import org.example.services.VoteService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String,String[]> inputParams = new HashMap<>();//пустая мэп
        //inputParams.put("artist", new String[]{" 1"});
        //inputParams.put("artist", new String[]{"1 "});
        //inputParams.put("artist", new String[]{"rty"});
        //inputParams.put("artist", new String[]{"2"});
        //inputParams.put("artist", new String[]{"2", "3"});
        IVoteService service = VoteService.getInstance();
        service.save(inputParams);
    }
}
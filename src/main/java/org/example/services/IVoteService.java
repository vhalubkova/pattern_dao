package org.example.services;

import java.io.IOException;
import java.util.Map;

// сервис, который принимает форму голоса и сохраняет его
public interface IVoteService {
    public void save(Map<String, String[]> map) throws IOException, Exception;
}

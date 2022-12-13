package org.example.controllers;

import org.example.services.*;
import org.example.viewer.ResultCreator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StatisticsServlet extends HttpServlet {
    private IStatisticsService service = StatisticsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        ArrayList<ArtistResultsDTO> sortedArtists = service.getArtists();
        ArrayList<GenreResultsDTO> sortedGenres = service.getGenres();
        ArrayList<AboutUserResultsDTO> sortedInfoAboutUser = service.getAboutUser();

        ResultCreator creator = new ResultCreator();
        writer.write(creator.create(sortedArtists,sortedGenres,sortedInfoAboutUser));

    }
}

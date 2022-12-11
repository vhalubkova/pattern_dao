package org.example.controllers;

import org.example.services.GenreService;
import org.example.services.IGenresService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GenreServlet extends HttpServlet {
    private IGenresService service = GenreService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write(service.getForm());  //put form
    }
}

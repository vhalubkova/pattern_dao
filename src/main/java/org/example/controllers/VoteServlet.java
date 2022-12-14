package org.example.controllers;

import org.example.services.IVoteService;
import org.example.services.VoteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class VoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]> inputParams = req.getParameterMap();

        IVoteService service = VoteService.getInstance();
        try{
            service.save(inputParams);
        } catch (Exception e){
            throw new ServletException("Ошибка введенной информации");
            //resp.getWriter().write("exs:" + e.getMessage() + e);
        }


    }
}

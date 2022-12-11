package org.example.services;

import org.example.dao.GenreDAO;
import org.example.dao.GenreDTO;

public class GenreService implements IGenresService{
    private volatile static GenreService instance;

    @Override
    public String getForm() {
        String s = "<form method='post' action='s'><p><b>Выберите Ваши любимые жанры (3-5шт):</b></p>";
        for(GenreDTO genre:GenreDAO.getInstance().getAll()){
            s = s + "<input type='checkbox' name='genre' value='" + genre.getID() + "'> " + genre.getName() + "<Br>";
        }
        s = s + "<p><input type='submit' value='Отправить'></p> </form>";
        return s;
    }


    public static GenreService getInstance(){
        if(instance == null){
            synchronized (GenreService.class){
                if(instance==null){
                    instance = new GenreService();
                }
            }
        }
        return instance;
    }
}

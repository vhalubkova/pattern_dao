package org.example.services;

import org.example.dao.ArtistDAO;
import org.example.dao.ArtistDTO;

public class ArtistService implements IArtistService {
    private volatile static ArtistService instance;

    @Override
    public String getForm() {
        String s = "<form method='post' action='s'><p><b>Какого исполнителя Вы считаете лучшим?</b></p>";
        for (ArtistDTO artist : ArtistDAO.getInstance().getAll()) {
            s = s + "<input type='radio' name='artist' value='" + artist.getID() + "'> " + artist.getName() + "<Br>";
        }
        s = s + "<p><input type='submit' value='Отправить'></p> </form>";
        return s;
    }

    public static ArtistService getInstance() {
        if (instance == null) {
            synchronized (ArtistService.class) {
                if (instance == null) {
                    instance = new ArtistService();
                }
            }
        }
        return instance;
    }
}

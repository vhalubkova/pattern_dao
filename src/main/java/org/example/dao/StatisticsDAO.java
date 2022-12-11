package org.example.dao;

public class StatisticsDAO {
    private volatile static StatisticsDAO instance;

    public static StatisticsDAO getInstance(){
        if(instance == null){
            synchronized (StatisticsDAO.class){
                if(instance==null){
                    instance = new StatisticsDAO();
                }
            }
        }
        return instance;
    }
}

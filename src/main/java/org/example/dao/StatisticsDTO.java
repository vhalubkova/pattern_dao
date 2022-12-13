package org.example.dao;

public class StatisticsDTO {
    private volatile static StatisticsDTO instance;




    public static StatisticsDTO getInstance(){
        if(instance == null){
            synchronized (StatisticsDTO.class){
                if(instance==null){
                    instance = new StatisticsDTO();
                }
            }
        }
        return instance;
    }
}

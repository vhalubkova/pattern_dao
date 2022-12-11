package org.example.services;

public class StatisticsModel {
    private volatile static StatisticsModel instance;

    public static StatisticsModel getInstance(){
        if(instance == null){
            synchronized (StatisticsModel.class){
                if(instance==null){
                    instance = new StatisticsModel();
                }
            }
        }
        return instance;
    }
}

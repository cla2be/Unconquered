package com.example.matt.groundwork;

import android.app.Application;

/**
 * Created by matt_000 on 4/11/2015.
 */
public class Global extends Application {
    private static battlestorage Battles[];
    private static  int numberOfBattles=0;
    public static Players ThisPlayer;
    public static int lookat=0;

    private static Global instance;
    private String email;

    public Global() {}

    public void setCurrentEmail(String curEmail)
    {
        this.email = curEmail;
    }

    public String getCurrentEmail()
    {
        return this.email;
    }

    public static synchronized Global getInstance(){
        if(instance==null){
            instance=new Global();
        }
        return instance;
    }

    public static battlestorage GetBattle(int i){
        if (i<numberOfBattles)
            return Battles[i];
        else
            return null;
    }

    public static int GetBattleNum(){
            return numberOfBattles;
    }

    public static void addBattle(battlestorage in){
        if(numberOfBattles==0)
        {
            numberOfBattles++;
            Battles=new battlestorage[1];
            Battles[0]= in;
            return;
        }

        battlestorage hold[]= new battlestorage [numberOfBattles+1];

        for(int i=0; i< numberOfBattles;i++) {
            hold [i]=Battles[i];
        }
        hold[numberOfBattles]= in;
        numberOfBattles++;
        Battles= hold;
    }
}

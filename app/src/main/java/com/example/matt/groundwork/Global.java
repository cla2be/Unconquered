package com.example.matt.groundwork;

import android.app.Application;

/**
 * Created by matt_000 on 4/11/2015.
 */
public class Global extends Application {
    private battlestorage Battles[];
    private int numberOfBattles;


    public battlestorage GetBattle(int i){
        if (i<numberOfBattles)
            return this.Battles[i];
        else
            return null;
    }

    public void addBattle(battlestorage in){
        battlestorage hold[]= new battlestorage [numberOfBattles+1];

        for(int i=0; i< numberOfBattles;i++) {
            hold [i]=Battles[i];
        }
        numberOfBattles++;
        hold[numberOfBattles]= in;

        Battles= hold;
    }
}

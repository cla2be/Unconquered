package com.example.matt.groundwork;

/**
 * Created by matt_000 on 4/3/2015.
 */
public class Minions
{
    private int action, time;

    public Ailments Affect;

    Minions(int actionin, int timein,Ailments Affectin)
    {
        action = actionin;
        time=timein;
        Affect=Affectin;

    }

    int minionAction(Players Target)
    {
        time--;
        return Target.Damage(action);
    }

    int getTime()
    {return time;}

};

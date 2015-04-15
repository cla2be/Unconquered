package com.example.matt.groundwork;

/**
 * Created by matt_000 on 4/3/2015.
 */


public class Players {


    private Statistics STATS;
    private int Health, maxMoves;
    private int nextMove;

    private Moves Sequence [];

    Ailments Affected;
    int Poisened;

    public Players(int STRin, int ENDin, int CHRin, int INTin, int AGLin, int LCKin)
    {

        STATS =new Statistics();
        nextMove=0;
        STATS.STR = STRin;
        STATS.END = ENDin;
        STATS.CHR = CHRin;
        STATS.INT = INTin;
        STATS.AGL = AGLin;
        STATS.LCK = LCKin;

        Health = ENDin*5+20;
        Affected = Ailments.None;
        Poisened=0;
    }

    Statistics GetSTATS()
    {
        return STATS;
    }

    void SetMoves (Moves Set[], int MaxIn)
    {

        Sequence = Set;

        maxMoves= MaxIn;
    }

    String GetNameOfMove()
    {
        if (nextMove%maxMoves !=0)
            return Sequence[nextMove].GetName();
        else
            return Sequence[0].GetName();

    }

    Moves NextAction()
    {
        nextMove= nextMove%maxMoves;
        return Sequence[nextMove++];
    }

    Moves LastAction()
    {
        if (nextMove !=0)
            return Sequence[nextMove-1];
        else
            return Sequence[maxMoves];
    }
    int Damage(Moves in, Statistics Other){
        int delt=in.Use(Other, STATS.AGL);
        if (in.AilOut() != Ailments.None && Affected == Ailments.None)
            if ((Math.random() %4) ==1)
                Affected = in.AilOut();
        if (delt == -2)
            return delt;
        if (delt < Health)
            Health -= delt;
        else
            delt= -1;
        return delt;
    }
    int Damage(int in){
        if (in < Health)
            Health-= in;
        else
            in= -1;
        return in;
    }

    int Initiation ()
    {return STATS.AGL+STATS.LCK;}

    void changestat(Stat type, int change)
    {

        switch (type)
        {
            case Str:
                STATS.STR+= change;
            case End:
                STATS.END+= change;
            case Chr:
                STATS.CHR+= change;
            case Int:
                STATS.INT+= change;
            case Agl:
                STATS.AGL+= change;
            case Lck:
                STATS.LCK+= change;
        }
    }

}

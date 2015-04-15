package com.example.matt.groundwork;

/**
 * Created by matt_000 on 4/2/2015.
 */
public class Moves {

    String name;
    Stat type;
    Ailments Ail;
    int mod, modadd;


    public Moves(){}

    public Moves (String namein, Stat which, int modifier,int modifier2, Ailments cause)
    {
        name= namein;
        type= which;
        mod = modifier;
        modadd=modifier2;
        Ail = cause;
    }

    int Use(Statistics STATSIN, int Aglin)
    {
        double Dodge= Math.random()*100 %100;
        if (type== Stat.Chr)
            return -2;
        if (Aglin+10 >Dodge)
            return 0;
        switch (type)
        {
            case Str:
                return (((STATSIN.STR)-1)* mod) +modadd;
            case End:
                return (((STATSIN.END)-1)* mod)+modadd;

            case Int:
                return (((STATSIN.INT)-1)* mod)+modadd;
            case Agl:
                return (((STATSIN.AGL)-1)* mod)+modadd;
            case Lck:
                return (((STATSIN.LCK)-1)* mod)+modadd;
        }
        return 0;
    }

    int FirstMod()
    {
        return mod;
    }
    int SecondMod()
    {
        return modadd;
    }

    Ailments AilOut()
    {return Ail;}

    String GetName()
    { return name;}

}

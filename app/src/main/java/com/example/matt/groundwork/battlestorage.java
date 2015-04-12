package com.example.matt.groundwork;

/**
 * Created by matt_000 on 4/3/2015.
 */
public class battlestorage {

    Actions  Record[];
    int SizeOfStorage;

    Players Player1;
    Players Player2;

    int winner;

    public battlestorage ()
    {
        SizeOfStorage= 0;
    }

    public void newRecord(Actions Actionin)
    {
        if (SizeOfStorage ==0)
        {
            Record= new Actions [1];
            Record [0] = Actionin;
        }
        else
        {
            Actions HoldRecord []= new Actions [SizeOfStorage+1];
            System.arraycopy(Record, 0, HoldRecord, 0, SizeOfStorage);
            HoldRecord[SizeOfStorage] =Actionin;
            //delete Record;
            Record =HoldRecord;

        }
        SizeOfStorage++;
    }

    public String Summery()
    {
        String Output= "";

        if (winner==0)
            Output+="You won!";
        else
            Output+="You lost!";

        return Output;
    }

    public String OutputRecord(){
        String Output= "";
        Output+=Record[0].WhoDunIt;
        Output+=" goes first";
        for(int i=0;i<SizeOfStorage;i++)
        {
            Output+=Record[i].WhoDunIt;
            if (!Record[i].min)
                Output+="'s ";

            if (Record[i].damage != -3 && !Record[i].min)
                Output+=Record[i].name;

            switch(Record[i].damage)
            {
                case -3:
                    Output+="Stunned, and as such can not attack\n";
                    break;
                case -2:
                    Output+=" summoned a minion\n";
                    break;
                case -1:
                    Output+=" did fatal Damage\n";
                    break;
                case 0:
                    Output+=" Missed\n";
                    break;
                default:
                    Output+=" did ";
                    Output+=Record[i].damage;
                    Output+=" Damage\n";

            }
        }

        return Output;
    }


    int Fight(Players Player1in, Players Player2in) {
        Minions m1 = null, m2 = null;
        int result, turn;
        Actions SendToRecord=new Actions();


        Player1=Player1in;
        Player2=Player2in;


        if (Math.random() % Player1.Initiation() >= Math.random() % Player2.Initiation())
            turn = 1;
        else
            turn = 2;
        while (true) {
            turn = turn % 2; // player 2 = 0

            if (turn==1) {
                SendToRecord.WhoDunIt = "Player 1 ";
                if (Player1.Affected == Ailments.Stun) {
                    SendToRecord.name = "Stunned";
                    result = -3;
                } else {
                    SendToRecord.name = Player1.GetNameOfMove();
                    result = Player2.Damage(Player1.NextAction(), Player1.GetSTATS());
                }
            } else {
                SendToRecord.WhoDunIt = "Player 2 ";
                if (Player2.Affected == Ailments.Stun) {
                    SendToRecord.name = "Stunned";
                    result = -3;
                } else {
                    SendToRecord.name = Player2.GetNameOfMove();
                    result = Player1.Damage(Player2.NextAction(), Player2.GetSTATS());
                }
            }

            SendToRecord.damage = result;
            SendToRecord.min = false;
            this.newRecord(SendToRecord);
            if (result == -1)
                return turn;
            else if (result == -2) {
                if (turn==1) {
                    //delete &m1;
                    m1 = new Minions(Player1.LastAction().FirstMod(), Player1.LastAction().SecondMod(), Player1.LastAction().AilOut());
                } else {
                    //delete &m2;
                    m2 = new Minions(Player2.LastAction().FirstMod(), Player2.LastAction().SecondMod(), Player2.LastAction().AilOut());
                }
            } else if (result == -3) {
                if (turn==1)
                    Player1.Affected = Ailments.None;
                else
                    Player2.Affected = Ailments.None;
            }


            if (turn==1 && m1 != null) {
                result = m1.minionAction(Player2);
                if (Player2.Affected != Ailments.None && m1.Affect != Ailments.None)
                    Player2.Affected = m1.Affect;

                SendToRecord.WhoDunIt = "Player 1's minion";
                SendToRecord.name = "";
                SendToRecord.damage = result;
                SendToRecord.min = true;

                this.newRecord(SendToRecord);

                if (result == -1)
                    return 1;
                if (m1.getTime() == 0)
                    m1 = null;
            } else if (turn==0 && m2 != null) {
                result = m2.minionAction(Player1);
                if (Player2.Affected != Ailments.None && m1.Affect != Ailments.None)
                    Player2.Affected = m1.Affect;

                SendToRecord.WhoDunIt = "Player 2's minion did ";
                SendToRecord.name = "";
                SendToRecord.damage = result;
                SendToRecord.min = true;

                this.newRecord(SendToRecord);
                if (result == -1)
                    return turn;

                if (m2.getTime() == 0)
                    m2 = null;
            }

            if (Player1.Affected == Ailments.Poison) {
                Player1.Poisened++;
                Player1.Affected = Ailments.None;
            } else if
                    (Player2.Affected == Ailments.Poison) {
                Player2.Poisened++;
                Player2.Affected = Ailments.None;
            }

            if (turn==1 && Player1.Poisened != 0) {
                result = Player1.Damage(Player1.Poisened);
                SendToRecord.WhoDunIt = "Player 1";
                SendToRecord.damage = result;
                SendToRecord.min = false;
                SendToRecord.name = "Poison";
                this.newRecord(SendToRecord);
            } else if
                    (turn==0 && Player2.Poisened != 0) {
                result = Player2.Damage(Player1.Poisened);
                SendToRecord.WhoDunIt = "Player 2";
                SendToRecord.damage = result;
                SendToRecord.min = false;
                SendToRecord.name = "Poison";
                this.newRecord(SendToRecord);
            }
            winner=turn;
            turn++;
        }
    }
}

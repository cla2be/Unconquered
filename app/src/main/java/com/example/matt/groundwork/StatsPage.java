package com.example.matt.groundwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by matt_000 on 3/26/2015.
 */
public class StatsPage
    extends ActionBarActivity

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        TextView text = (TextView) findViewById(R.id.textView3);
        text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().STR));
        text = (TextView) findViewById(R.id.textView5);
        text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().END));
        text = (TextView) findViewById(R.id.textView10);
        text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().CHR));
        text = (TextView) findViewById(R.id.textView11);
        text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().INT));
        text = (TextView) findViewById(R.id.textView12);
        text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().AGL));
        text = (TextView) findViewById(R.id.textView13);
        text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().LCK));

        text = (TextView) findViewById(R.id.textView21);
        text.setText("Basic Attack");
        text = (TextView) findViewById(R.id.textView22);
        text.setText("Strong Attack");
        text = (TextView) findViewById(R.id.textView25);
        text.setText("Dizzy Strike");
        text = (TextView) findViewById(R.id.textView23);
        text.setText("Summon Imp");
        text = (TextView) findViewById(R.id.textView26);
        text.setText("Smoke Cloud");
        text = (TextView) findViewById(R.id.textView27);
        text.setText("Fireball");
        text = (TextView) findViewById(R.id.textView28);
        text.setText("Frost");
        text = (TextView) findViewById(R.id.textView29);
        text.setText("Needle");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

 public void MoveToSet(View view){
    Stat StatToUse;
    Ailments AilToUse;
    Moves Attacks[] = new Moves[9];
     Moves AttackToUse [];
     boolean checks[] = new boolean[9];
     int NumOfMoves=0;

    StatToUse=Stat.Str;
    AilToUse=Ailments.None;
    Attacks[0]=new

    Moves("Basic Attack",StatToUse, 1,10,AilToUse);

    Attacks[1]=new

    Moves("Strong Attack",StatToUse, 5,-1,AilToUse);

    AilToUse=Ailments.Stun;
    Attacks[2]=new

    Moves("Dizzy Strike",StatToUse, 3,-10,AilToUse);

    AilToUse=Ailments.None;

    StatToUse=Stat.Chr;
    Attacks[3]=new

    Moves("Imp",StatToUse, 10,3,AilToUse);

    AilToUse=Ailments.Poison;
    Attacks[4]=new

    Moves("Smoke Cloud",StatToUse, 1,5,AilToUse);

    AilToUse=Ailments.Burnt;
    Attacks[5]=new

    Moves("Fireball",StatToUse, 4,1,AilToUse);

    AilToUse=Ailments.Freeze;
    Attacks[6]=new

    Moves("Frost",StatToUse, 4,1,AilToUse);

    AilToUse=Ailments.Poison;
    Attacks[7]=new

    Moves("Needle",StatToUse, 4,1,AilToUse);

    AilToUse=Ailments.Stun;
    Attacks[8]=new

    Moves("Lightning Strike",StatToUse, 4,1,AilToUse);
    //text=(TextView)findViewById(R.id.textView30);
    //text.setText("Lightning Strike");
     CheckBox Setting []= new CheckBox[8];
     Setting[0]= (CheckBox)findViewById(R.id.checkBox);
     Setting[1]= (CheckBox)findViewById(R.id.checkBox2);
     Setting[2]= (CheckBox)findViewById(R.id.checkBox5);
     Setting[3]= (CheckBox)findViewById(R.id.checkBox3);
     Setting[4]= (CheckBox)findViewById(R.id.checkBox6);
     Setting[5]= (CheckBox)findViewById(R.id.checkBox7);
     Setting[6]= (CheckBox)findViewById(R.id.checkBox8);
     Setting[7]= (CheckBox)findViewById(R.id.checkBox9);

     for(int i=0;i<8;i++)
         if (Setting[i].isChecked())
             checks[i]=true;
     else
             checks[i]=false;


     for(int i=0;i<8;i++)
     if (checks[i])
        NumOfMoves++;

        int hold = 0;
        AttackToUse= new Moves [NumOfMoves];

        for(int i=0;i<8;i++)
     if (checks[i]){
        AttackToUse[hold]=Attacks[i];
        hold++;
        }

        Global.ThisPlayer.SetMoves (AttackToUse, NumOfMoves);



}

        public void CloseStats(View view)
        {
            finish();
        }

}

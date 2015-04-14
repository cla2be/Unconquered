package com.example.matt.groundwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
            TextView text=(TextView)findViewById(R.id.textView3);
            text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().STR));
            text=(TextView)findViewById(R.id.textView5);
            text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().END));
            text=(TextView)findViewById(R.id.textView10);
            text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().CHR));
            text=(TextView)findViewById(R.id.textView11);
            text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().INT));
            text=(TextView)findViewById(R.id.textView12);
            text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().AGL));
            text=(TextView)findViewById(R.id.textView13);
            text.setText(Integer.toString(Global.ThisPlayer.GetSTATS().LCK));

            Stat StatToUse;
            Ailments AilToUse;
            Moves Attacks []= new Moves [10];

            StatToUse = Stat.Str;
            AilToUse = Ailments.None;
            Attacks[0] = new Moves("Basic Attack",StatToUse,1,10,AilToUse);
            Attacks[1]= new Moves("Strong Attack",StatToUse,5,-1,AilToUse);
            AilToUse = Ailments.Stun;
            Attacks[2]= new Moves("Dizzy Strike",StatToUse,3,-10,AilToUse);
            AilToUse = Ailments.None;

            StatToUse = Stat.Chr;
            Attacks[3]= new Moves("Imp",StatToUse,10,3,AilToUse);
            AilToUse = Ailments.Poison;
            Attacks[4]= new Moves("Smoke Cloud",StatToUse,1,5,AilToUse);
            AilToUse = Ailments.Burnt;
            Attacks[5]= new Moves("Fire Elemental",StatToUse,15,2,AilToUse);


            StatToUse = Stat.Int;
            Attacks[6]= new Moves("Fireball",StatToUse,4,1,AilToUse);
            AilToUse = Ailments.Freeze;
            Attacks[7]= new Moves("Frost",StatToUse,4,1,AilToUse);
            AilToUse = Ailments.Poison;
            Attacks[8]= new Moves("Needle",StatToUse,4,1,AilToUse);
            AilToUse = Ailments.Stun;
            Attacks[9]= new Moves("Lightning Strike",StatToUse,4,1,AilToUse);

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

        public void CloseStats(View view)
        {
            finish();
        }

}

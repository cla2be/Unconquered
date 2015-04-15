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

public class FightPage
    extends ActionBarActivity

    {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

            Intent intent = getIntent();
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_chat, menu);
            return true;
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

        public void addFight(View view)
        {
                battlestorage NextFight = new battlestorage();
                Players player2= new Players(5,50,5,5,5,5);
            Stat StatToUse;
            Ailments AilToUse;
            Moves Attacks[] = new Moves[9];

            StatToUse=Stat.Str;
            AilToUse=Ailments.None;
            Attacks[0]=new

                    Moves("Basic Attack",StatToUse, 1,10,AilToUse);

            Attacks[1]=new

                    Moves("Strong Attack",StatToUse, 5,0,AilToUse);

            AilToUse=Ailments.Stun;
            Attacks[2]=new

                    Moves("Dizzy Strike",StatToUse, 3,0,AilToUse);

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

            player2.SetMoves(Attacks,9);
                NextFight.Fight(Global.ThisPlayer,player2);
                Global.addBattle(NextFight);
                TextView out = (TextView) findViewById(R.id.textView19);
            out.setText(NextFight.Summery());
            Global.ThisPlayer.Restore();

        }

        public void OpenDetails(View view)
        {
            Intent intent = new Intent(this, DetailsOfFight.class);
            //EditText editText = (EditText) findViewById(R.id.edit_message);
            //String message = editText.getText().toString();
            //intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

        public void CloseFight(View view)
        {
            finish();
        }

}
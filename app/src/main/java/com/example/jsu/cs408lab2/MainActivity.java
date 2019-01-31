package com.example.jsu.cs408lab2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.*;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand = new Random();
    //random Variable for computer choice
    private int r ;
    private Weapon userWeapon;
    private Weapon computerWeapon;
    private int userWinCount;
    private int computerWinCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView viewInstruction = (TextView) findViewById(R.id.txtInstruction);
        viewInstruction.setText("Welcome to Rock-Paper-Scissors! Please choose your weapon");

        userWinCount =0;
        computerWinCount =0;


    }


    //Created by Jobish on 1/24/19
    public void buttonRockClicked(View v){
        displayPlayerWeapon(Weapon.ROCK);
        userWeapon = Weapon.ROCK;
        computerChoice();

    }
    public void buttonPaperClicked(View V){
        displayPlayerWeapon(Weapon.PAPER);
        userWeapon = Weapon.PAPER;
        computerChoice();

    }
    public void buttonScissorsClicked(View V){
        displayPlayerWeapon(Weapon.SCISSORS);
        userWeapon = Weapon.SCISSORS;
        computerChoice();

    }
    public void displayPlayerWeapon( Weapon w){
        TextView playerWeapon = (TextView) findViewById(R.id.txtPlayerWeapon);
        playerWeapon.setText("Player's Weapon: "+ w.toString());
    }

    public void computerChoice(){
       r = rand.nextInt(3) + 1;
       switch (r){
           case 1: displayComputerWeapon(Weapon.ROCK);
                    computerWeapon = Weapon.ROCK;
                    findWinner(userWeapon,computerWeapon);
                    break;
           case 2: displayComputerWeapon(Weapon.PAPER);
                    computerWeapon = Weapon.PAPER;
                    findWinner(userWeapon,computerWeapon);
                    break;
           case 3: displayComputerWeapon(Weapon.SCISSORS);
                    computerWeapon = Weapon.SCISSORS;
                    findWinner(userWeapon,computerWeapon);
                    break;
           default: displayComputerWeapon(Weapon.SCISSORS);
                    computerWeapon = Weapon.SCISSORS;
                    findWinner(userWeapon,computerWeapon);
                    break;
       }
    }

    public void displayComputerWeapon(Weapon w){
        TextView computerWeapon = (TextView) findViewById(R.id.txtComputerWeapon);
        computerWeapon.setText("Computer's Weapon: "+ w.toString());
    }
    public void findWinner(Weapon userChoice, Weapon computerChoice){
        TextView winner = (TextView) findViewById(R.id.txtDispplayWinner);
       if (userChoice.equals(Weapon.ROCK)) {
           if (computerChoice.equals(Weapon.SCISSORS)){
                winner.setText("The Player wins!.. " + userChoice + " beats " + computerChoice);
                userWinCount++;
                printCount(userWinCount,computerWinCount);
           }
            else if (computerChoice.equals(Weapon.PAPER)){
                winner.setText( "The computer wins!.. " +computerChoice+ " beats " + userChoice);
                computerWinCount++;
                printCount(userWinCount,computerWinCount);
           }
            else
                winner.setText("The game is tied!");
        } else if (userChoice.equals(Weapon.PAPER)) {
            if (computerChoice.equals(Weapon.SCISSORS)){
                winner.setText("The computer wins!.. "+ computerChoice+ " beats " + userChoice);
                computerWinCount++;
                printCount(userWinCount,computerWinCount);
            }
            else if (computerChoice.equals(Weapon.ROCK)){
                winner.setText("The Player wins!.. "+ userChoice+ " beats " + computerChoice);

                userWinCount++;
                printCount(userWinCount,computerWinCount);
            }
            else
                winner.setText("The game is tied!");
        } else if (userChoice.equals(Weapon.SCISSORS)) {
            if (computerChoice.equals(Weapon.ROCK)){
                winner.setText("The computer wins!.. "+computerChoice+ " beats " +userChoice);
                computerWinCount++;
                printCount(userWinCount,computerWinCount);
            }
            else if (computerChoice.equals(Weapon.PAPER)){
                winner.setText("The Player wins!.. "+userChoice+ " beats " +computerChoice);
                userWinCount++;
                printCount(userWinCount,computerWinCount);
            }

            else
                winner.setText("The game is tied!");
        }
    }

    public void printCount(int userCount, int computerCount){
        TextView countView = (TextView) findViewById(R.id.txtCount);
        countView.setText("Player: "+ userCount +" Computer: "+ computerCount);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");

        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

    }
}

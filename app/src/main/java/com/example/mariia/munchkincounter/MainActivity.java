package com.example.mariia.munchkincounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    //The level of 10 required to win
    //Tracks the level score for player 1
    int playerOneLevel = 0;
    //Tracks the level score for player 2
    int playerTwoLevel = 0;
    //Tracks the level score for player 3
    int playerThreeLevel = 0;

    /**
     * Sum of player's level and points on the cards, such as gear.
     * Used as a reference to see if the player has a high enough level
     * to defeat a monster or not.
     */
    //Tracks the strength score for player 1
    int playerOneStrength = 0;
    //Tracks the strength score for player 2
    int playerTwoStrength = 0;
    //Tracks the strength score for player 3
    int playerThreeStrength = 0;
    //Changes if any player wins
    String winningMessage = "The first player to reach level 10 wins";
    //When any player wins, the buttons are toggled unclickable
    boolean buttonsClickable = true;
    //Stores user's name
    String playerOneName = "Player 1";
    String playerTwoName = "Player 2";
    String playerThreeName = "Player 3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayLevelPlayerOne(playerOneLevel);
        displayLevelPlayerTwo(playerTwoLevel);
        displayLevelPlayerThree(playerThreeLevel);
        displayStrengthPlayerOne(playerOneStrength);
        displayStrengthPlayerTwo(playerTwoStrength);
        displayStrengthPlayerThree(playerThreeStrength);
        displayWinningMessage(winningMessage);
        setButtonsClickable(buttonsClickable);
        displayNamePlayerOne(playerOneName);
        displayNamePlayerTwo(playerTwoName);
        displayNamePlayerThree(playerThreeName);
    }


// methods for displaying players' levels

    public void displayLevelPlayerOne(int playerOneLevel) {
        TextView player1Level = (TextView) findViewById(R.id.player1_level);
        player1Level.setText(String.valueOf(playerOneLevel));
    }

    public void displayLevelPlayerTwo(int playerTwoLevel) {
        TextView player2Level = (TextView) findViewById(R.id.player2_level);
        player2Level.setText(String.valueOf(playerTwoLevel));
    }

    public void displayLevelPlayerThree(int playerThreeLevel) {
        TextView player3Level = (TextView) findViewById(R.id.player3_level);
        player3Level.setText(String.valueOf(playerThreeLevel));
    }

    // methods for displaying players' strength

    public void displayStrengthPlayerOne(int playerOneStrength) {
        TextView player1Strength = (TextView) findViewById(R.id.player1_strength);
        player1Strength.setText(String.valueOf(playerOneStrength));
    }

    public void displayStrengthPlayerTwo(int playerTwoStrength) {
        TextView player2Strength = (TextView) findViewById(R.id.player2_strength);
        player2Strength.setText(String.valueOf(playerTwoStrength));
    }

    public void displayStrengthPlayerThree(int playerThreeStrength) {
        TextView player3Strength = (TextView) findViewById(R.id.player3_strength);
        player3Strength.setText(String.valueOf(playerThreeStrength));
    }

    //method to display a winning message
    public void displayWinningMessage(String winningMessage) {
        TextView infoMessage = findViewById(R.id.info_text_view);
        infoMessage.setText(String.valueOf(winningMessage));
    }

    //methods to display players' names. Can't figure out how to take the user input and add it to the winning message :(
    public void displayNamePlayerOne(String playerOneName) {
        EditText nameOne = findViewById(R.id.player1_name);
        nameOne.setText(String.valueOf(playerOneName));
    }

    public void displayNamePlayerTwo(String playerTwoName) {
        EditText nameTwo = findViewById(R.id.player2_name);
        nameTwo.setText(String.valueOf(playerTwoName));
    }

    public void displayNamePlayerThree(String playerThreeName) {
        EditText nameThree = findViewById(R.id.player3_name);
        nameThree.setText(String.valueOf(playerThreeName));
    }

    //method to toggle buttons clickable or uncklickable
    public void setButtonsClickable(boolean buttonsClickable) {
        final Button plusLevelButtonPlayerOne = (Button) findViewById(R.id.levelup_player1);
        final Button plusLevelButtonPlayerTwo = (Button) findViewById(R.id.levelup_player2);
        final Button plusLevelButtonPlayerThree = (Button) findViewById(R.id.levelup_player3);
        final Button minusLevelButtonPlayerOne = (Button) findViewById(R.id.leveldown_player1);
        final Button minusLevelButtonPlayerTwo = (Button) findViewById(R.id.leveldown_player2);
        final Button minusLevelButtonPlayerThree = (Button) findViewById(R.id.leveldown_player3);
        final Button plusStrengthButtonPlayerOne = (Button) findViewById(R.id.strengthup_player1);
        final Button plusStrengthButtonPlayerTwo = (Button) findViewById(R.id.strengthup_player2);
        final Button plusStrengthButtonPlayerThree = (Button) findViewById(R.id.strengthup_player3);
        final Button minusStrengthButtonPlayerOne = (Button) findViewById(R.id.strengthdown_player1);
        final Button minusStrengthButtonPlayerTwo = (Button) findViewById(R.id.strengthdown_player2);
        final Button minusStrengthButtonPlayerThree = (Button) findViewById(R.id.strengthdown_player3);

        if (playerOneLevel >= 10 || playerTwoLevel >= 10 || playerThreeLevel >= 10) {
            plusLevelButtonPlayerOne.setEnabled(false);
            plusLevelButtonPlayerTwo.setEnabled(false);
            plusLevelButtonPlayerThree.setEnabled(false);
            minusLevelButtonPlayerOne.setEnabled(false);
            minusLevelButtonPlayerTwo.setEnabled(false);
            minusLevelButtonPlayerThree.setEnabled(false);
            plusStrengthButtonPlayerOne.setEnabled(false);
            plusStrengthButtonPlayerTwo.setEnabled(false);
            plusStrengthButtonPlayerThree.setEnabled(false);
            minusStrengthButtonPlayerOne.setEnabled(false);
            minusStrengthButtonPlayerTwo.setEnabled(false);
            minusStrengthButtonPlayerThree.setEnabled(false);

        } else {
            plusLevelButtonPlayerOne.setEnabled(true);
            plusLevelButtonPlayerTwo.setEnabled(true);
            plusLevelButtonPlayerThree.setEnabled(true);
            minusLevelButtonPlayerOne.setEnabled(true);
            minusLevelButtonPlayerTwo.setEnabled(true);
            minusLevelButtonPlayerThree.setEnabled(true);
            plusStrengthButtonPlayerOne.setEnabled(true);
            plusStrengthButtonPlayerTwo.setEnabled(true);
            plusStrengthButtonPlayerThree.setEnabled(true);
            minusStrengthButtonPlayerOne.setEnabled(true);
            minusStrengthButtonPlayerTwo.setEnabled(true);
            minusStrengthButtonPlayerThree.setEnabled(true);
        }

    }

    // methods for displaying Player 1 scores

    public void plusOneLevelPlayer1(View view) {
        playerOneLevel += 1;
        playerOneStrength += 1;
        displayLevelPlayerOne(playerOneLevel);
        displayStrengthPlayerOne(playerOneStrength);

        if (playerOneLevel >= 10) {
            winningMessage = playerOneName + " won!";
            displayWinningMessage(winningMessage);
            setButtonsClickable(true);

        }
    }

    public void plusOneStrengthPlayer1(View view) {
        playerOneStrength += 1;
        displayStrengthPlayerOne(playerOneStrength);
    }

    public void minusOneLevelPlayer1(View view) {
        playerOneLevel -= 1;
        playerOneStrength -= 1;
        displayStrengthPlayerOne(playerOneStrength);
        displayLevelPlayerOne(playerOneLevel);
    }

    public void minusOneStrengthPlayer1(View view) {
        playerOneStrength -= 1;
        displayStrengthPlayerOne(playerOneStrength);
    }

    // methods for displaying Player 2 scores

    public void plusOneLevelPlayer2(View view) {
        playerTwoLevel += 1;
        playerTwoStrength += 1;
        displayStrengthPlayerTwo(playerTwoStrength);
        displayLevelPlayerTwo(playerTwoLevel);

        if (playerTwoLevel >= 10) {
            winningMessage = playerTwoName + " won!";
            displayWinningMessage(winningMessage);
            setButtonsClickable(true);
        }

    }

    public void plusOneStrengthPlayer2(View view) {
        playerTwoStrength += 1;
        displayStrengthPlayerTwo(playerTwoStrength);
    }

    public void minusOneLevelPlayer2(View view) {
        playerTwoLevel -= 1;
        playerTwoStrength -= 1;
        displayStrengthPlayerTwo(playerTwoStrength);
        displayLevelPlayerTwo(playerTwoLevel);
    }

    public void minusOneStrengthPlayer2(View view) {
        playerTwoStrength -= 1;
        displayStrengthPlayerTwo(playerTwoStrength);
    }

    // methods for displaying Player 3 scores

    public void plusOneLevelPlayer3(View view) {
        playerThreeLevel += 1;
        playerThreeStrength += 1;
        displayStrengthPlayerThree(playerThreeStrength);
        displayLevelPlayerThree(playerThreeLevel);

        if (playerThreeLevel >= 10) {
            winningMessage = playerThreeName + " won!";
            displayWinningMessage(winningMessage);
            setButtonsClickable(true);
        }
    }

    public void plusOneStrengthPlayer3(View view) {
        playerThreeStrength += 1;
        displayStrengthPlayerThree(playerThreeStrength);
    }

    public void minusOneLevelPlayer3(View view) {
        playerThreeLevel -= 1;
        playerThreeStrength -= 1;
        displayStrengthPlayerThree(playerThreeStrength);
        displayLevelPlayerThree(playerThreeLevel);
    }

    public void minusOneStrengthPlayer3(View view) {
        playerThreeStrength -= 1;
        displayStrengthPlayerThree(playerThreeStrength);
    }

    //This method resets the scores of both teams

    public void resetScore(View view) {
        playerOneLevel = 0;
        displayLevelPlayerOne(playerOneLevel);
        playerOneStrength = 0;
        displayStrengthPlayerOne(playerOneStrength);
        playerTwoLevel = 0;
        displayLevelPlayerTwo(playerTwoLevel);
        playerTwoStrength = 0;
        displayStrengthPlayerTwo(playerTwoStrength);
        playerThreeLevel = 0;
        displayLevelPlayerThree(playerThreeLevel);
        playerThreeStrength = 0;
        displayStrengthPlayerThree(playerThreeStrength);
        setButtonsClickable(true);
        displayWinningMessage("The first player to reach level 10 wins");

    }
}
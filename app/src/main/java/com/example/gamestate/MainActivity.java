package com.example.gamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameState myGameState = new GameState();
        myGameState.toString(); //should print out all values

        editText = (EditText) findViewById(R.id.editText);
        editText.setOnClickListener(this);

        View runTest = findViewById(R.id.button);
        runTest.setOnClickListener(this);

    }

    public void onClick (View v){
        if (v.getId() == R.id.button){
            editText.getText().clear();
            GameState firstInstance = new GameState();
            GameState secondInstance = new GameState(firstInstance);
            secondInstance.setPlayerTurn(1);
            // Call each action method here when they are made, using the firstInstance to call them
            GameState thirdInstance = new GameState();
            GameState fourthInstance = new GameState(thirdInstance);
            fourthInstance.setPlayerTurn(1);
            editText.append(firstInstance.toString());
            editText.append("\n\n"+fourthInstance.toString());
        }
    }
}

package com.example.exe018;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultsScreen extends AppCompatActivity {
    Intent getResults;
    int blueresult = -1;
    int redresult = -1;

    TextView red, blue ,result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_results_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;




        });

        getResults = getIntent();
        blueresult = getResults.getIntExtra("Blue Result", -2);
        redresult = getResults.getIntExtra("Red Result", -2);
        red = findViewById(R.id.textRed);
        blue = findViewById(R.id.textBlue);
        result = findViewById(R.id.textWin);

        red.setText("Red Score: " + redresult);
        blue.setText("Blue Score: " + blueresult);
        if(redresult>blueresult){
            result.setText("red win");
        }
        if(redresult<blueresult){
            result.setText("blue win" );
        }
        if(redresult==blueresult){
            result.setText("tie");
        }


    }

    public void backbtn(View view) {
        setResult(RESULT_OK, getResults);
        finish();
    }
}
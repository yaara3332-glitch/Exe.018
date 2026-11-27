package com.example.exe018;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
int bluecount, redcount = 0;
Button redbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        redbtn = findViewById(R.id.redBtn);
        redbtn.setOnLongClickListener(this);
    }

    public void shortAdd(View view) {
        bluecount++;
    }

    @Override
    public boolean onLongClick(View v) {
        redcount+=2;
        return true;
    }

    public void newSc(View view) {
        Intent toresults = new Intent(MainActivity.this, ResultsScreen.class);
        toresults.putExtra("Blue Result", bluecount);
        toresults.putExtra("Red Result", redcount);
        startActivityForResult(toresults, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        bluecount = 0;
        redcount = 0;


    }
}
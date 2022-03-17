package edu.uic.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Facts extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);


        String name = getIntent().getStringExtra("name");
        TextView infoName = (TextView) findViewById(R.id.textName);
        TextView infoLife = (TextView) findViewById(R.id.textLife);
        TextView infoWeight = (TextView) findViewById(R.id.textWeight);
        TextView infoHabitat = (TextView) findViewById(R.id.textHabitat);
        TextView infoFeeding = (TextView) findViewById(R.id.textFeeding);
        TextView infoEndangered = (TextView) findViewById(R.id.textEndangered);

        InfoFacts animal = new InfoFacts(name);

        infoName.setText(animal.name);
        infoLife.setText(animal.lifespan);
        infoWeight.setText(animal.weight);
        infoHabitat.setText(animal.habitat);
        infoFeeding.setText(animal.feeding);
        infoEndangered.setText(animal.endangered);



    }
}
package edu.uic.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView image = (ImageView) findViewById(R.id.bigImage);
        //Toast.makeText(ImageActivity.this, intent.getIntExtra("img", 0), Toast.LENGTH_SHORT).show();
        image.setImageResource(getIntent().getIntExtra("img", 0));


        // get the name of the selected animal
        String name = getIntent().getStringExtra("name");

        //Toast.makeText(this, name,Toast.LENGTH_SHORT).show();


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageActivity.this, Facts.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}
package edu.uic.project_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView nameView = (RecyclerView) findViewById(R.id.recycler_view);

        List<String> names = Arrays.asList("Wolf", "Bear", "Leopard", "Lion", "Elephant", "Otter", "Zebra", "Capybara");

        myList = new ArrayList<>();
        myList.addAll(names);

        int[] animalsPicture = {R.drawable.a_wolf, R.drawable.b_bear, R.drawable.c_leopard,
                R.drawable.d_lion,R.drawable.e_elephant, R.drawable.f_otter,R.drawable.g_zebra, R.drawable.h_capybara};

        String [] links = {"https://en.wikipedia.org/wiki/Wolf", "https://en.wikipedia.org/wiki/Bear","https://en.wikipedia.org/wiki/Leopard",
        "https://en.wikipedia.org/wiki/Lion", "https://en.wikipedia.org/wiki/Elephant", "https://en.wikipedia.org/wiki/Otter",
                "https://en.wikipedia.org/wiki/Zebra", "https://en.wikipedia.org/wiki/Capybara"};

        //Define the listener with a lambda and access the list of names with the position passed in
        //  RVClickListener listener = (view, position)-> Toast.makeText(this, "position: "+position, Toast.LENGTH_LONG).show();

        //Define the listener with a lambda and access the name of the list item from the view
        RVClickListener listener = (view,position)->{
            TextView name = (TextView)view.findViewById(R.id.textView);
            //ImageView image = (ImageView) view.findViewById(R.id.imageView);
            //Toast.makeText(this,name.getText(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ImageActivity.class);
           // Toast.makeText(this,animalsPicture[position],Toast.LENGTH_SHORT).show();
            intent.putExtra("img", animalsPicture[position]);
            intent.putExtra("name", name.getText());
            startActivity(intent);
        };

        MyAdapter adapter = new MyAdapter(myList, animalsPicture, links ,listener);
        nameView.setHasFixedSize(true);
        nameView.setAdapter(adapter);
        nameView.setLayoutManager(new GridLayoutManager(this,2)); //use this line to see as a grid
        //nameView.setLayoutManager(new LinearLayoutManager(this)); //use this line to see as a standard vertical list



    }
}
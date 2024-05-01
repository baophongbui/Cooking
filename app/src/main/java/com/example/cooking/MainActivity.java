package com.example.cooking;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<String>recipeNameList = new ArrayList<>();
    private ArrayList<String>timeList = new ArrayList<>();
    private ArrayList<Integer>imageList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        adapter = new RecyclerAdapter(recipeNameList, timeList, imageList, MainActivity.this);
        recyclerView.setAdapter(adapter);

        recipeNameList.add("Bánh Crepe và Berries");
        recipeNameList.add("Hamburger");
        timeList.add("10:03");
        timeList.add("5:00");
        imageList.add(R.drawable.toast3);
        imageList.add(R.drawable.burger);
    }

}
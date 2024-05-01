package com.example.cooking;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class Details extends AppCompatActivity {
    private TextView textView, detail, txtInfo;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = findViewById(R.id.ic_back);
        detail = findViewById(R.id.txtDetail1);
        imageView = findViewById(R.id.imageView3);
        txtInfo = findViewById(R.id.txtInfo);


        int image = getIntent().getIntExtra("image",0);
        int string = getIntent().getIntExtra("detail",0);
        String info = getIntent().getStringExtra("info");

        imageView.setImageResource(image);
        detail.setText(string);
        txtInfo.setText(info);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });



    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
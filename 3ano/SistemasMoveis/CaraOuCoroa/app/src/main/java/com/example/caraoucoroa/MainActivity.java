package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button bSorteia;
    ImageView iMoeda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bSorteia=findViewById(R.id.bSorteia);
        iMoeda=findViewById(R.id.iMoeda);
        bSorteia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sorteia = new Random().nextInt(2);
                if(sorteia==1){
                    iMoeda.setImageResource(R.drawable.cara);
                }else{
                    iMoeda.setImageResource(R.drawable.coroa);
                }
            }
        });

    }
}
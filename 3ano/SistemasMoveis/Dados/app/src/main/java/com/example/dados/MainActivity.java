package com.example.dados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button bDados;
    ImageView iDados;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bDados = findViewById(R.id.bDados);
        iDados = findViewById((R.id.iDados));
        bDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sorteia = new Random().nextInt(6);
                switch (sorteia){
                    case 0:
                        iDados.setImageResource(R.drawable.dado1);
                        break;
                    case 1:
                        iDados.setImageResource(R.drawable.dado2);
                        break;
                    case 2:
                        iDados.setImageResource(R.drawable.dado3);
                        break;
                    case 3:
                        iDados.setImageResource(R.drawable.dado4);
                        break;
                    case 4:
                        iDados.setImageResource(R.drawable.dado5);
                        break;
                    case 5:
                        iDados.setImageResource(R.drawable.dado6);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
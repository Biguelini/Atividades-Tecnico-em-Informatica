package com.example.idadeemmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText itIdade;
    TextView tIdadeEmMeses;
    Button bCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itIdade = findViewById(R.id.itIdade);
        tIdadeEmMeses = findViewById(R.id.tIdadeEmMeses);
        bCalcular = findViewById(R.id.bCalcular);
        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idade = Integer.parseInt(itIdade.getText().toString());
                tIdadeEmMeses.setText("Já viveu " + Integer.toString(idade*12) + " meses");
            }
        });
    }
}
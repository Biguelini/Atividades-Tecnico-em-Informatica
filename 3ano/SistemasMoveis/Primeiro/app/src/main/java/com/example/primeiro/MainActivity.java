package com.example.primeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bOla;
    TextView tResultado;
    EditText tNome;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bOla = findViewById(R.id.bOla);
        tResultado = findViewById(R.id.tResultado);
        tNome = findViewById(R.id.tNome);
        bOla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tResultado.setText("Olá "+tNome.getText()+", seja bem vindo!");
            }
        });
    }
}
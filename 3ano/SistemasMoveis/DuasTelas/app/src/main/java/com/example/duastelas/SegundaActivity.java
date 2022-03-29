package com.example.duastelas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    TextView lOla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        lOla = findViewById(R.id.lOla);
        Bundle parametros = getIntent().getExtras();
        if (parametros!=null){
            String login = parametros.getString("login");
            lOla.setText("Olá"+login+"Seja bem-vindo");
        }
    }
}
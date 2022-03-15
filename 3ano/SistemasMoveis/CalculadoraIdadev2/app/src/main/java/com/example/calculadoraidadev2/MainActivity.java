package com.example.calculadoraidadev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText itIdade;
    TextView tResposta;
    Button bCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itIdade = findViewById(R.id.itIdade);
        tResposta = findViewById(R.id.tResposta);
        bCalcular = findViewById(R.id.bCalcular);
        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendario c = new Calendario();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    c.setDatanasc(Calendar.getInstance());
                    c.getDatanasc().setTime(sdf.parse(itIdade.getText().toString()));
                    c.calcula();
                    tResposta.setText("Você já viveu "+c.getMes()+" meses");
                } catch (ParseException e){
                    tResposta.setText("Erro de data");
                }
            }
        });

    }
}
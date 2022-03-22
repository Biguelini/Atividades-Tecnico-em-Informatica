package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button bVerificar;
    ImageView imgResultado;
    EditText itPeso, itAltura;
    double imc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bVerificar = findViewById(R.id.bVerificar);
        imgResultado = findViewById(R.id.imgResultado);
        itPeso = findViewById(R.id.itPeso);
        itAltura = findViewById(R.id.itAltura);
        bVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso = Double.parseDouble((itPeso.getText().toString()));
                double altura = Double.parseDouble((itAltura.getText().toString()));
                imc = peso/(altura*altura);
                if(imc>26){
                    imgResultado.setImageResource(R.drawable.emagrecer);
                } else {
                    imgResultado.setImageResource(R.drawable.saudavel);
                }
            }
        });
    }
}
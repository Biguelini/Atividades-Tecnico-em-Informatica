package com.example.anotacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;


public class MainActivity extends AppCompatActivity {
    EditText tTexto;
    Button bSalva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Antações do Bigue");
        tTexto = findViewById(R.id.tTexto);
        bSalva=findViewById(R.id.bSalva);
        bSalva.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textDigitado=tTexto.getText().toString();
                gravarTexto(textDigitado);
                Toast.makeText(MainActivity.this, "Texto salvo com sucesso!",Toast.LENGTH_SHORT).show();

            }
        }));
        String texto=lerTexto();
        if (texto!=null){
            tTexto.setText(texto);
        }
    }
    private void gravarTexto(String texto){
        try {
            OutputStreamWriter osw=new OutputStreamWriter((openFileOutput("anotacao.txt", Context.MODE_PRIVATE)));
            osw.write(texto);
            osw.close();
        } catch (IOException e){
            Log.v("MainActivity",e.getMessage());
        }
    }
    private String lerTexto(){
        String lido="";
        try {
            InputStream arq=openFileInput("anotacao.txt");
            if (arq!=null){
                InputStreamReader isr=new InputStreamReader(arq);
                BufferedReader bis=new BufferedReader(isr);
                String linhalida="";
                while((linhalida=bis.readLine())!=null){
                    lido+=linhalida+"\n";
                }
                arq.close();
            }
        }catch (IOException e){
            Log.v("MainActivity", e.getMessage());
        }
        return lido;
    }

}
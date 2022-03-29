package com.example.duastelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tLogin, tSenha;
    Button bLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tLogin = findViewById(R.id.tLogin);
        tSenha = findViewById(R.id.tSenha);
        bLogin = findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tLogin.getText().toString().equals("Fulano")&&tSenha.getText().toString().equals("1234")){
                    Intent i = new Intent(MainActivity.this, SegundaActivity.class);
                    i.putExtra("login",tLogin.getText().toString());
                    startActivity(i);

                } else{
                    Toast.makeText(MainActivity.this, "Login e/ou senha inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
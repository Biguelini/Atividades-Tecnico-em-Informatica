package com.example.crudmusicas;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

import com.example.crudmusicas.Musica;

public class EditActivity extends AppCompatActivity {
    EditText tId, tNome, tCantor, tAlbum;
    Button bSalva;
    Musica musica;
    BdMusica bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int id=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        musica = new Musica();
        bd = new BdMusica(getBaseContext());
        tId = findViewById(R.id.tId);
        tNome = findViewById(R.id.tNome);
        tCantor = findViewById(R.id.tCantor);
        tAlbum = findViewById(R.id.tAlbum);
        bSalva = findViewById(R.id.bSalva);
        Bundle extra = getIntent().getExtras();
        tId.setText("0"); if (extra != null) {
            id = extra.getInt("id");
        } else {
            id = 0;
        }
        if (id == 0) {
            setTitle("Novo Cadastro");
            bSalva.setText("Insere");
        } else {
            setTitle("Alteração");
            bSalva.setText("Altera");
            musica = bd.localiza(id);
            pessoaToTela();
        }
        bSalva.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            telaToPessoa();
            if (musica.getId() == 0)
                bd.insere(musica);
            else
                bd.altera(musica);
            finish();
        }
        });

    }
    private void pessoaToTela(){
        tId.setText(Integer.toString(musica.getId()));
        tNome.setText(musica.getNome());
        tCantor.setText(musica.getCantor());
        tAlbum.setText(musica.getAlbum());
    }
    private void telaToPessoa() {
        musica.setId(Integer.parseInt(tId.getText().toString()));
        musica.setNome(tNome.getText().toString());
        musica.setCantor(tCantor.getText().toString());
        musica.setAlbum(tAlbum.getText().toString());
    }

}
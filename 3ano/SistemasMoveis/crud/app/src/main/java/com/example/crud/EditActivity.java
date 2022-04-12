package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

public class EditActivity extends AppCompatActivity {
    EditText tId, tNome, tCpf;
    Button bSalva;
    Pessoa pessoa;
    BdPessoa bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int id=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        pessoa = new Pessoa();
        bd = new BdPessoa(getBaseContext());
        tId = findViewById(R.id.tId);
        tNome = findViewById(R.id.tNome);
        tCpf = findViewById(R.id.tCPF);
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
            pessoa = bd.localiza(id);
            pessoaToTela();
        }
        bSalva.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            telaToPessoa();
            if (pessoa.getId() == 0)
                bd.insere(pessoa);
            else
                bd.altera(pessoa);
            finish();
        }
        });

    }
    private void pessoaToTela(){
        tId.setText(Integer.toString(pessoa.getId()));
        tNome.setText(pessoa.getNome());
        tCpf.setText(pessoa.getCpf());
    }
    private void telaToPessoa() {
        pessoa.setId(Integer.parseInt(tId.getText().toString()));
        pessoa.setNome(tNome.getText().toString());
        pessoa.setCpf(tCpf.getText().toString());
    }

}
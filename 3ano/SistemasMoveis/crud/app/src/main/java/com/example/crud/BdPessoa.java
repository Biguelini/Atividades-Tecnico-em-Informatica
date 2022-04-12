package com.example.crud;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BdPessoa {
    private SQLiteDatabase db;
    private Bd banco;
    public BdPessoa(Context context){
        banco = new Bd(context);
    }
    public String insere(Pessoa pessoa){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("nome", pessoa.getNome());
        valores.put("cpf", pessoa.getCpf());

        resultado = db.insert("pessoa", null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
    public void altera(Pessoa pessoa){
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = "_id=" + pessoa.getId();
        valores = new ContentValues();
        valores.put("nome", pessoa.getNome());
        valores.put("cpf", pessoa.getCpf());
        db.update("pessoa",valores,where,null);
        db.close();
    }
    public void exclui(int id){
        String where = "_id=" + id;
        db = banco.getReadableDatabase();
        db.delete("pessoa",where,null);
        db.close();
    }
    public Pessoa localiza(int id){
        Cursor cursor;
        Pessoa pessoa=new Pessoa();
        String[] campos = {"_id","nome","cpf"};
        String where = "_id=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query("pessoa",campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
            pessoa.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            pessoa.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
            pessoa.setCpf(cursor.getString(cursor.getColumnIndexOrThrow("cpf")));
        }
        db.close();
        return pessoa;
    }
    public Cursor pesquisa(){
        Cursor cursor;
        String[] campos = {"_id","nome"};
        db = banco.getReadableDatabase();
        cursor = db.query("pessoa", campos, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close(); return cursor;
    }

}

package com.example.crudmusicas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BdMusica {
    private SQLiteDatabase db;
    private Bd banco;

    public BdMusica(Context context){
        banco = new Bd(context);
    }

    public String insere(Musica musica){ ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase(); valores = new ContentValues(); valores.put("nome", musica.getNome()); valores.put("cantor", musica.getCantor()); valores.put("album", musica.getAlbum());

        resultado = db.insert("musica", null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro"; else
            return "Registro Inserido com sucesso";
    }
    public void altera(Musica musica){ ContentValues valores;
        String where;
        db = banco.getWritableDatabase(); where = "_id=" + musica.getId(); valores = new ContentValues(); valores.put("nome", musica.getNome()); valores.put("cantor", musica.getCantor()); valores.put("album", musica.getAlbum()); db.update("musica",valores,where,null); db.close();
    }
    public void exclui(int id){ String where = "_id=" + id;
        db = banco.getReadableDatabase(); db.delete("musica",where,null); db.close();
    }
    public Musica localiza(int id){ Cursor cursor;
        Musica musica=new Musica();
        String[] campos = {"_id","nome","cantor", "album"}; String where = "_id=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query("musica",campos,where, null, null, null, null, null); if(cursor!=null){
            cursor.moveToFirst(); musica.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))); musica.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome"))); musica.setCantor(cursor.getString(cursor.getColumnIndexOrThrow("cantor")));musica.setAlbum(cursor.getString(cursor.getColumnIndexOrThrow("album")));
        }
        db.close(); return musica;
    }
    public Cursor pesquisa(){ Cursor cursor;
        String[] campos = {"_id","nome", "album", "cantor"};
        db = banco.getReadableDatabase();
        cursor = db.query("musica", campos, null, null, null, null, null, null); if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close(); return cursor;
    }
}


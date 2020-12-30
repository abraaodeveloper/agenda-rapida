package com.agendauniversitaria.agendarapida.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.model.Lembrete;
import com.agendauniversitaria.agendarapida.model.contrato.AgendaContrato;

import java.util.ArrayList;

public class LembreteDao {
    private AgendaOpenHelper agendaOpenHelper;
    private Context context;

    public LembreteDao(Context context) {
        agendaOpenHelper = new AgendaOpenHelper(context);
        this.context = context;
    }

    public int salvarLembrete(Lembrete l) {
        SQLiteDatabase db = agendaOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        long retornoDB;

        values.put(AgendaContrato.TabelaLembrete.NOME_LEMBR, l.getNome());
        values.put(AgendaContrato.TabelaLembrete.DESCRICAO, l.getDescricao());
        values.put(AgendaContrato.TabelaLembrete.HORA_ALARME, l.getHoraAlarme());

        retornoDB = db.insert(AgendaContrato.TabelaLembrete.NOME_TABELA, null, values);

        db.close();

        return (int)retornoDB;
    }

    public ArrayList<Lembrete> todosLembretes() {
        SQLiteDatabase db = agendaOpenHelper.getReadableDatabase();
        String[] colunas = {AgendaContrato.TabelaLembrete.ID, AgendaContrato.TabelaLembrete.NOME_LEMBR,
                AgendaContrato.TabelaLembrete.DESCRICAO, AgendaContrato.TabelaLembrete.HORA_ALARME};

        Cursor cursor;
        ArrayList<Lembrete> listaLembretes = new ArrayList<Lembrete>();
            cursor= db.query(
                    AgendaContrato.TabelaLembrete.NOME_TABELA, colunas, null, null, null, null, null);
            while (cursor.moveToNext()) {
                Lembrete l = new Lembrete();

                l.setId(cursor.getInt(0));
                l.setNome(cursor.getString(1));
                l.setDescricao(cursor.getString(2));
                l.setHoraAlarme(cursor.getString(3));

                listaLembretes.add(l);

            }
            db.close();
            return listaLembretes;

    }

    public boolean editarLembreteId(Lembrete l, int id) {
        SQLiteDatabase db = agendaOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        long retornoDB;

        values.put(AgendaContrato.TabelaLembrete.NOME_LEMBR, l.getNome());
        values.put(AgendaContrato.TabelaLembrete.DESCRICAO, l.getDescricao());
        values.put(AgendaContrato.TabelaLembrete.HORA_ALARME, l.getHoraAlarme());

        String selection = AgendaContrato.TabelaLembrete.ID + " LIKE ?";
        String[] selectionArgs = {"" + id};

            retornoDB = db.update(
                AgendaContrato.TabelaLembrete.NOME_TABELA, values, selection, selectionArgs);
            db.close();
            if (retornoDB == -1)
                return false;
            else
                return true;
    }

    public boolean excluirLembreteId(String nomeLembr) {
        SQLiteDatabase db = agendaOpenHelper.getWritableDatabase();
        long retornoDB;

        String selection = AgendaContrato.TabelaLembrete.NOME_LEMBR + " LIKE ?";
        String[] selectionArgs = {nomeLembr};

            retornoDB = agendaOpenHelper.getWritableDatabase().delete(
                    AgendaContrato.TabelaLembrete.NOME_TABELA, selection, selectionArgs);
            db.close();
            if (retornoDB == -1)
                return false;
            else
                return true;

    }

}

package com.agendauniversitaria.agendarapida.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.model.Disciplina;
import com.agendauniversitaria.agendarapida.model.contrato.AgendaContrato;

import java.util.ArrayList;

public class DisciplinaDao {

    private AgendaOpenHelper agendaOpenHelper;
    private Context context;

    public DisciplinaDao(Context context) {
        agendaOpenHelper = new AgendaOpenHelper(context);
        this.context = context;
    }

    public boolean salvarDisciplina(Disciplina d) {

        SQLiteDatabase db = agendaOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        long retornoDB;

        values.put(AgendaContrato.TabelaDisciplina.NOME_DISC, d.getNomeDisc());
        values.put(AgendaContrato.TabelaDisciplina.NOME_PROF, d.getNomeProf());
        values.put(AgendaContrato.TabelaDisciplina.SALA, d.getSala());
        values.put(AgendaContrato.TabelaDisciplina.DESCRICAO, d.getDescricao());

        retornoDB = db.insert(AgendaContrato.TabelaDisciplina.NOME_TABELA, null, values);
        db.close();
        if (retornoDB == -1)
            return false;
        else
            return true;
    }

    public ArrayList<Disciplina> todasDisciplinas() {

        SQLiteDatabase db = agendaOpenHelper.getReadableDatabase();

        String[] colunas = {AgendaContrato.TabelaDisciplina.ID, AgendaContrato.TabelaDisciplina.NOME_DISC,
                AgendaContrato.TabelaDisciplina.NOME_PROF, AgendaContrato.TabelaDisciplina.SALA, AgendaContrato.TabelaDisciplina.DESCRICAO};

        Cursor cursor = db.query(
                AgendaContrato.TabelaDisciplina.NOME_TABELA, colunas, null, null, null, null, null);

        ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
        while (cursor.moveToNext()) {
            Disciplina d = new Disciplina();

            d.setId(cursor.getInt(0));
            d.setNomeDisc(cursor.getString(1));
            d.setNomeProf(cursor.getString(2));
            d.setSala(cursor.getString(3));
            d.setDescricao(cursor.getString(4));

            listaDisciplinas.add(d);
        }
        db.close();
        return listaDisciplinas;


    }

    public boolean editarDisciplinaId(Disciplina d, int id) {
        SQLiteDatabase db = agendaOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        long retornoDB;

        values.put(AgendaContrato.TabelaDisciplina.NOME_DISC, d.getNomeDisc());
        values.put(AgendaContrato.TabelaDisciplina.NOME_PROF, d.getNomeProf());
        values.put(AgendaContrato.TabelaDisciplina.SALA, d.getSala());
        values.put(AgendaContrato.TabelaDisciplina.DESCRICAO, d.getDescricao());

        String selection = AgendaContrato.TabelaDisciplina.ID + " LIKE ?";
        String[] selectionArgs = {"" + id};

        retornoDB = db.update(AgendaContrato.TabelaDisciplina.NOME_TABELA, values, selection, selectionArgs);
        db.close();
        if (retornoDB == -1)
            return false;
        else
            return true;
    }

    public boolean excluirDisciplinaId(int id) {
        SQLiteDatabase db = agendaOpenHelper.getWritableDatabase();
        long retornoDB;

        String selection = AgendaContrato.TabelaDisciplina.ID +"="+id;

        retornoDB = db.delete(
                AgendaContrato.TabelaDisciplina.NOME_TABELA, selection,null);
        db.close();
        if (retornoDB == -1)
            return false;
        else
            return true;
    }

}

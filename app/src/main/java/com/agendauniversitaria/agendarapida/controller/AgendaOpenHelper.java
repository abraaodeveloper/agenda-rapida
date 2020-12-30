package com.agendauniversitaria.agendarapida.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.model.contrato.AgendaContrato;

public class AgendaOpenHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "agenda.db";
    private static final int VERSION = 1;
    private Context context;

    public AgendaOpenHelper(Context context) {
        super(context, NOME_BANCO, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaDiciplina  = "CREATE TABLE "+ AgendaContrato.TabelaDisciplina.NOME_TABELA+" (" +
                AgendaContrato.TabelaDisciplina.ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                AgendaContrato.TabelaDisciplina.NOME_DISC+" TEXT, "+
                AgendaContrato.TabelaDisciplina.NOME_PROF+" TEXT, "+
                AgendaContrato.TabelaDisciplina.SALA+" TEXT, "+
                AgendaContrato.TabelaDisciplina.DESCRICAO+" TEXT "+
                ");";
        String sqlTabelaLembrete  = "CREATE TABLE "+ AgendaContrato.TabelaLembrete.NOME_TABELA+" (" +
                AgendaContrato.TabelaLembrete.ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                AgendaContrato.TabelaLembrete.NOME_LEMBR+" TEXT, "+
                AgendaContrato.TabelaLembrete.DESCRICAO+" TEXT, "+
                AgendaContrato.TabelaLembrete.HORA_ALARME+" TEXT "+
                ");";
        try {
            db.execSQL(sqlTabelaDiciplina);
            db.execSQL(sqlTabelaLembrete);
        }catch (Exception e){
            Toast.makeText(context, "Ocorreu um erro ao criar base de dados: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDisc = "DROP TABLE IF EXISTS "+AgendaContrato.TabelaDisciplina.NOME_TABELA;
        String sqlLembr = "DROP TABLE IF EXISTS "+AgendaContrato.TabelaLembrete.NOME_TABELA;
        try {
            db.execSQL(sqlDisc);
            db.execSQL(sqlLembr);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context, "Ocorreu um erro ao atualizar base de dados: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

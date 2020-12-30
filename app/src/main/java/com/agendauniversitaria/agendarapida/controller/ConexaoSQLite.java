package com.agendauniversitaria.agendarapida.controller;

import android.content.Context;

public class ConexaoSQLite {

    private AgendaOpenHelper agendaOpenHelper;

    private ConexaoSQLite(Context context){
        agendaOpenHelper = new AgendaOpenHelper(context);
    }


}

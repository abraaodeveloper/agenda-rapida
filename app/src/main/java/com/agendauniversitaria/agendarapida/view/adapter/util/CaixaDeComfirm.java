package com.agendauniversitaria.agendarapida.view.adapter.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.R;

public final class CaixaDeComfirm {

    public static void caixaExcluir(final Context context, String msg){
        AlertDialog alerta;
        AlertDialog.Builder construcao = new AlertDialog.Builder(context);

        construcao.setTitle("Excluir?");
        construcao.setMessage(msg);
        construcao.setIcon(R.drawable.ic_delete_cinza_24dp);

        construcao.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,"Item excluido com sucesso!",Toast.LENGTH_SHORT).show();
            }
        });
        construcao.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,"Item não excluido!",Toast.LENGTH_SHORT).show();
            }
        });

        alerta = construcao.create();

        alerta.show();
    }

}

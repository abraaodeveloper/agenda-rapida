package com.agendauniversitaria.agendarapida.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.R;
import com.agendauniversitaria.agendarapida.controller.DisciplinaDao;
import com.agendauniversitaria.agendarapida.model.Disciplina;
import com.agendauniversitaria.agendarapida.model.Lembrete;
import com.agendauniversitaria.agendarapida.view.activity.ViewDisciplinaActivity;

import java.util.ArrayList;

public class AdapterListDisciplinas extends RecyclerView.Adapter<AdapterListDisciplinas.MyViewHolder>{

    private ArrayList<Disciplina> listaDisc;
    private Context context;
    private DisciplinaDao disciplinaDao;

    public AdapterListDisciplinas(ArrayList<Disciplina> listaDisc, Context context) {
        this.listaDisc = listaDisc;
        this.context = context;
        disciplinaDao = new DisciplinaDao(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_list_disciplinas,viewGroup,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull final  MyViewHolder myViewHolder, final int i) {
        myViewHolder.nomeDisc.setText(listaDisc.get(i).getNomeDisc());
        myViewHolder.nomeProf.setText(listaDisc.get(i).getNomeProf());
        myViewHolder.sala.setText(listaDisc.get(i).getSala());
        myViewHolder.btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Disciplina disciplina = listaDisc.get(i);
                PopupMenu popupMenu = new PopupMenu(context, myViewHolder.btMenu);
                popupMenu.inflate(R.menu.menupopup_lembrete);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.itemConpatilhar:
                                Toast.makeText(context, disciplina.getNomeDisc() + " pode ser compartilhado", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.itemEditar:
                                Toast.makeText(context, disciplina.getNomeDisc() + " pode ser editado", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.itemExcluir:

                                for(int i = 0; i< listaDisc.size(); i++){
                                    if(listaDisc.get(i).getId() == disciplina.getId()){

                                        disciplinaDao.excluirDisciplinaId(disciplina.getId());
                                        Toast.makeText(context, disciplina.getNomeDisc() + " pode ser excluido", Toast.LENGTH_LONG).show();
                                        listaDisc.remove(i);
                                        notifyItemRemoved(i);
                                    }
                                }
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        myViewHolder.cardViewDisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Disciplina disciplina = listaDisc.get(i);
                Toast.makeText(context,"funfou!!!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ViewDisciplinaActivity.class);
                intent.putExtra("nomeDisc", disciplina.getNomeDisc());
                intent.putExtra("nomeProf", disciplina.getNomeProf());
                intent.putExtra("nomeSala", disciplina.getSala());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDisc.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        final TextView nomeProf, nomeDisc, sala;
        final ImageView btMenu;
        final CardView cardViewDisc;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeDisc = itemView.findViewById(R.id.tvNomeDicipListada);
            nomeProf = itemView.findViewById(R.id.tvNomeProfListado);
            sala = itemView.findViewById(R.id.tvSalaListada);
            btMenu = itemView.findViewById(R.id.imgBtMenuListDisc);
            cardViewDisc = itemView.findViewById(R.id.cardViewListDisc);
        }
    }
}

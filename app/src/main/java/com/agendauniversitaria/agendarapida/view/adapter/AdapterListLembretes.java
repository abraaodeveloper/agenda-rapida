package com.agendauniversitaria.agendarapida.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.R;
import com.agendauniversitaria.agendarapida.model.Lembrete;

import java.util.ArrayList;

public class AdapterListLembretes extends RecyclerView.Adapter<AdapterListLembretes.MyViewHolder> {

    private ArrayList<Lembrete> listaLembr;
    private Context context;

    public AdapterListLembretes(ArrayList<Lembrete> listaLembr, Context context) {
        this.listaLembr = listaLembr;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View itemList = LayoutInflater.from(context)
                .inflate(R.layout.adapter_list_lembretes, viewGroup, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.nome.setText(listaLembr.get(i).getNome());
        myViewHolder.descricao.setText(listaLembr.get(i).getDescricao());
        myViewHolder.btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Lembrete lembrete = listaLembr.get(i);
                PopupMenu popupMenu = new PopupMenu(context, myViewHolder.btMenu);
                popupMenu.inflate(R.menu.menupopup_lembrete);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.itemConpatilhar:
                                Toast.makeText(context, lembrete.getNome() + " pode ser compartilhado", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.itemEditar:
                                Toast.makeText(context, lembrete.getNome() + " pode ser editado", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.itemExcluir:
                                Toast.makeText(context, lembrete.getNome() + " pode ser excluido", Toast.LENGTH_LONG).show();
                                listaLembr.remove(lembrete.getId()-1);
                                notifyItemRemoved(lembrete.getId()-1);
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        myViewHolder.cardViewListLembr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "funcionando!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaLembr.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        final TextView nome, descricao;
        final ImageView btMenu;
        final CardView cardViewListLembr;

        public MyViewHolder(View itemView) {
            super(itemView);
            btMenu = itemView.findViewById(R.id.imgBtMenuListLembr);
            nome = itemView.findViewById(R.id.tvNomeLembr);
            descricao = itemView.findViewById(R.id.tvDescrLembr);
            cardViewListLembr = itemView.findViewById(R.id.cardViewListLembr);
        }
    }
}
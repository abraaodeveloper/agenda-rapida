package com.agendauniversitaria.agendarapida.view.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.R;
import com.agendauniversitaria.agendarapida.controller.LembreteDao;
import com.agendauniversitaria.agendarapida.model.Lembrete;
import com.agendauniversitaria.agendarapida.view.adapter.AdapterListLembretes;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LembretesFragment extends Fragment {

    private RecyclerView recyclerViewLembr;
    private LembreteDao lembreteDao;
    private ArrayList<Lembrete> listLembr;
    private FloatingActionButton fab;

    public LembretesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_lembretes, container, false);

        recyclerViewLembr = view.findViewById(R.id.recyclerViewListLembretes);

        listLembr = new ArrayList<Lembrete>();
        lembreteDao = new LembreteDao(getContext());

        atualizarLista();

        /*fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"teste com aba lembrete", Toast.LENGTH_LONG).show();
            }
        });*/

        /*
        recyclerViewLembr.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerViewLembr,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {

                        /*

                                PopupMenu popup = new PopupMenu(getContext(), ib);
                                //Inflating the Popup using xml file
                                popup.getMenuInflater()
                                        .inflate(R.menu.menupopup_lembrete, popup.getMenu());

                                //registering popup with OnMenuItemClickListener
                                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                    public boolean onMenuItemClick(MenuItem item) {
                                        Toast.makeText(
                                                getContext(),
                                                "You Clicked : " + item.getTitle()+" "+ listLembr.get(position).getId(),
                                                Toast.LENGTH_SHORT
                                        ).show();
                                        return true;
                                    }
                                });

                                popup.show();

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }));*/


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        atualizarLista();
    }

    private void atualizarLista() {
        listLembr = lembreteDao.todosLembretes();

        AdapterListLembretes adapter = new AdapterListLembretes(listLembr, getContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewLembr.setLayoutManager(layoutManager);
        recyclerViewLembr.setHasFixedSize(true);
        // recyclerViewLembr.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerViewLembr.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

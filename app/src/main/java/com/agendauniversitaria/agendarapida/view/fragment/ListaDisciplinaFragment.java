package com.agendauniversitaria.agendarapida.view.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.R;
import com.agendauniversitaria.agendarapida.controller.DisciplinaDao;
import com.agendauniversitaria.agendarapida.model.Disciplina;
import com.agendauniversitaria.agendarapida.view.adapter.AdapterListDisciplinas;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDisciplinaFragment extends Fragment {

    private ArrayList<Disciplina> listDisc;
    private RecyclerView rcDisciplinas;
    private DisciplinaDao dd;
    private FloatingActionButton fab;

    public ListaDisciplinaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_disciplina, container, false);
        rcDisciplinas = view.findViewById(R.id.recyclerViewDisciplinas);

        fab = view.findViewById(R.id.fab);

/*        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"teste com aba disciplina", Toast.LENGTH_LONG).show();
            }
        });*/

        dd = new DisciplinaDao(getContext());
        atualizarLista();
        /*
        rcDisciplinas.addOnItemTouchListener(new RecyclerItemClickListener(getContext(),
                rcDisciplinas,
                new RecyclerItemClickListener.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }

                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));
         */

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        atualizarLista();

    }

    /**
     * método responsavel por iniciar os componetes principais: adaptador, recyclerView...
     */
    private void atualizarLista(){
        listDisc = dd.todasDisciplinas();

        AdapterListDisciplinas adapterListDisciplinas = new AdapterListDisciplinas(listDisc, getContext());


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcDisciplinas.setLayoutManager(layoutManager);
        rcDisciplinas.setHasFixedSize(true);
        rcDisciplinas.setAdapter(adapterListDisciplinas);
    }
}

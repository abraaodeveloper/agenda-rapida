package com.agendauniversitaria.agendarapida.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agendauniversitaria.agendarapida.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDisciplinaView extends Fragment {

    private TextView txtNomeDisc, txtNomeProf, txtSala;


    public FragmentDisciplinaView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exibir_disciplina, container, false);

        txtNomeDisc = view.findViewById(R.id.txtNomeDiscView);
        txtNomeProf = view.findViewById(R.id.txtNomeProfView);
        txtSala = view.findViewById(R.id.txtSalaView);

     //   txtNomeProf.setText();



        return view;

    }

}

package com.agendauniversitaria.agendarapida.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.agendauniversitaria.agendarapida.R;
import com.agendauniversitaria.agendarapida.controller.DisciplinaDao;
import com.agendauniversitaria.agendarapida.model.Disciplina;

public class AddDiscplina extends DialogFragment {

    private static final String DIALOG_TAG = "addDisciplins";
    private EditText txtNomeDisc, txtNomeProf, txtDescr;
    private Button btSalvar, btCancelar;

    public static AddDiscplina newInstance() {

        Bundle args = new Bundle();
        args.putSerializable("titulo","titulo");

        AddDiscplina fragment = new AddDiscplina();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_disciplina,container,false);

        txtNomeDisc = view.findViewById(R.id.addNomeDisc);
        txtNomeProf = view.findViewById(R.id.addNomeProf);
        txtDescr = view.findViewById(R.id.addDescr);
        btSalvar = view.findViewById(R.id.btSalvarDisc);
        btCancelar = view.findViewById(R.id.btCancelarAddDisci);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisciplinaDao dao = new DisciplinaDao(getContext());
                Disciplina d = new Disciplina();
                d.setNomeDisc(txtNomeDisc.getText().toString());
                d.setNomeProf(txtNomeProf.getText().toString());
                d.setDescricao(txtDescr.getText().toString());
                d.setSala("teste");

                dao.salvarDisciplina(d);
                dismiss();
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }


}

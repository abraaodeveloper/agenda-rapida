package com.agendauniversitaria.agendarapida.view.dialog;

import android.app.Dialog;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.R;
import com.agendauniversitaria.agendarapida.controller.LembreteDao;
import com.agendauniversitaria.agendarapida.model.Lembrete;


public class AddLembrete extends DialogFragment implements TextView.OnEditorActionListener{

    private static final String DIALOG_TAG = "addLembretes";
    private static final String EXTRA_LENBRETE = "lembrete";

    private EditText txtDescr;
    private Button btSalvar;

    private Lembrete lembrete;

    public static AddLembrete newInstance(Lembrete l) {

        Bundle args = new Bundle();
        args.putSerializable(EXTRA_LENBRETE, l);

        AddLembrete fragment = new AddLembrete();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lembrete = (Lembrete)getArguments().getSerializable(EXTRA_LENBRETE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_lembrete,container,false);

        txtDescr = view.findViewById(R.id.addLembrDescr);
        txtDescr.requestFocus();
        btSalvar = view.findViewById(R.id.btSalvarLembr);

        if(this.lembrete == null){
            this.lembrete.setHoraAlarme("horateste");
            this.lembrete.setDescricao(txtDescr.getText().toString());
            this.lembrete.setNome("nometeste");
        }

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Novo lembrete");

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LembreteDao dao = new LembreteDao(getContext());
                Lembrete l = new Lembrete();
                l.setHoraAlarme("horateste");
                l.setDescricao(txtDescr.getText().toString());
                l.setNome("nometeste");

                int b = dao.salvarLembrete(l);
                Log.d("lembrete",""+b);
                dismiss();
            }
        });

        return view;
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
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(EditorInfo.IME_ACTION_DONE == actionId){
            LembreteDao dao = new LembreteDao(getContext());
            int id = dao.salvarLembrete(this.lembrete);
            if(id != -1){
                Toast.makeText(getContext(), "Lembrete com id: "+id+" salvo com sucesso!",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "Erro ao salvar lembrete",Toast.LENGTH_SHORT).show();
            }
        }

        return false;
    }
}

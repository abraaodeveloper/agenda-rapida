package com.agendauniversitaria.agendarapida.view.activity;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.agendauniversitaria.agendarapida.R;

public class ViewDisciplinaActivity extends AppCompatActivity{

    private TextView txtNomeDisc, txtNomeProf, txtSala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_disciplina);

        txtNomeDisc = findViewById(R.id.txtNomeDiscView);
        txtNomeProf = findViewById(R.id.txtNomeProfView);
        txtSala = findViewById(R.id.txtSalaView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            txtNomeDisc.setText(extras.getString("nomeDisc"));
            txtNomeProf.setText(extras.getString("nomeProf"));
            txtSala.setText(extras.getString("nomeSala"));

        }

    }
}

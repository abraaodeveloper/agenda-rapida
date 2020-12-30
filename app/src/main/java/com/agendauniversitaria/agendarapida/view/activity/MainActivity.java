package com.agendauniversitaria.agendarapida.view.activity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.agendauniversitaria.agendarapida.R;
import com.agendauniversitaria.agendarapida.model.Lembrete;
import com.agendauniversitaria.agendarapida.view.adapter.FragmentPageAdapterAgenda;
import com.agendauniversitaria.agendarapida.view.adapter.util.ApoioStatusFragment;
import com.agendauniversitaria.agendarapida.view.dialog.AddDiscplina;
import com.agendauniversitaria.agendarapida.view.dialog.AddLembrete;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FloatingActionButton fab;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    ApoioStatusFragment apoioStatusFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);

        //tabLayout
        tabLayout = findViewById(R.id.tablayout_main);
        viewPager = findViewById(R.id.viewpage_main);


        String[] teste = {"Disciplinas","Lembretes"};
        viewPager.setAdapter(new FragmentPageAdapterAgenda(getSupportFragmentManager(),teste));

        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    /**
     *
     * @param view
     * método responsavel por interagir com o click do float action button principal
     */
    public void clickFab(View view){
        if(tabLayout.getSelectedTabPosition() == 0){
            DialogFragment newFragment = AddDiscplina.newInstance();
            newFragment.show(getSupportFragmentManager(), "titulo");

        }else if(tabLayout.getSelectedTabPosition() == 1){
            DialogFragment newFragment = AddLembrete.newInstance(new Lembrete());
            //  newFragment.getDialog().getWindow().setLayout((int)larguraDialog,(int) alturaDialog);
            newFragment.show(getSupportFragmentManager(), "titulo");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menuCalc) {
           // Intent intent = new Intent(this, CalculadoraActivity.class);
            //startActivity(intent);

        } else if (id == R.id.menuNotas) {

        } else if (id == R.id.menuHorario) {

        } else if (id == R.id.menuConConta) {

        } else if (id == R.id.menuConfApp){

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onClickBtMenuLembrete(View view){

    }

}

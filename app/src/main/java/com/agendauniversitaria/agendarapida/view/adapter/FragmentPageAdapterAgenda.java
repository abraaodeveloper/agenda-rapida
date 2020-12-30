package com.agendauniversitaria.agendarapida.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.agendauniversitaria.agendarapida.view.adapter.util.ApoioStatusFragment;
import com.agendauniversitaria.agendarapida.view.fragment.LembretesFragment;
import com.agendauniversitaria.agendarapida.view.fragment.ListaDisciplinaFragment;

public class FragmentPageAdapterAgenda extends FragmentStatePagerAdapter {

    private String[] tabs;

    public FragmentPageAdapterAgenda(FragmentManager fm, String[] nomeTabs) {
        super(fm);
        this.tabs = nomeTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new ListaDisciplinaFragment();
            case 1:

                return new LembretesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.tabs[position];
    }
}

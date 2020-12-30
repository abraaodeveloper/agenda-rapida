package com.agendauniversitaria.agendarapida.view.adapter.util;

public class ApoioStatusFragment {

    private int fragmentAtivo = 0;
    public static final int FRAGMENT_DISC = 0;
    public static final int FRAGMENT_LEMBR = 1;

    public void setFragmentAtivo(int fragmentAtivo){
         if(fragmentAtivo == FRAGMENT_DISC){
            this.fragmentAtivo = 0;
        }else if(fragmentAtivo == FRAGMENT_LEMBR ) {
             this.fragmentAtivo = 1;
         }
    }
    public int getFragmentAtivo(){
        return this.fragmentAtivo;
    }

}

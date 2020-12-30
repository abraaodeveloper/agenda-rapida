package com.agendauniversitaria.agendarapida.view.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.agendauniversitaria.agendarapida.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.Locale;

public class CalculadoraActivity extends AppCompatActivity {

    //private static final int ID_VOZ_ATUAL = 100;
    //final Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


    }
 /*
    public void btOuvirDecodificar(View view) {

        Intent IVoz = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        IVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        IVoz.putExtra(RecognizerIntent.EXTRA_PREFER_OFFLINE,true);
        IVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        IVoz.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale Agora!!!");

        try {

            startActivityForResult(IVoz, ID_VOZ_ATUAL);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Seu aparelho não possui suporte a esse recurso.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);


        if(result != null){
            if(result.getContents() != null){
                Toast.makeText(getApplicationContext(),
                        result.getContents(),Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),
                        "SCAN cancelado",Toast.LENGTH_LONG).show();
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == ID_VOZ_ATUAL) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> resul = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String resultado = resul.get(0);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void lerQRCode(View view) {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Camera SCAN!!!");
        integrator.setCameraId(0);
        integrator.initiateScan();
    }
    */

}
package com.example.digitalhouse.memoria;

import android.animation.ObjectAnimator;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentFicha.EnviarNumero, FragmentResultado.NuevoJuego {

    private Integer imagenSeleccionadaPrevia;
    private Integer contador;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FragmentResultado fragmentResultado;
    private List<Integer> listaDeImagenes;
    private List<Integer> holders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarJuego();
    }

    @Override
    public void enviarResultado(Integer imagenSeleccionada) {
        if (imagenSeleccionadaPrevia.equals(imagenSeleccionada)){
            cargarResultado(1);
            sacarFragmentsFichas();
        }else{
            contador--;
            if (contador.equals(0)){
                cargarResultado(0);
                sacarFragmentsFichas();
            }
        }
        imagenSeleccionadaPrevia = imagenSeleccionada;
    }

    @Override
    public void jugarDeNuevo() {
        sacarFragmentResultado();
        inicializarJuego();
    }

    private void inicializarJuego(){
        ObjectAnimator animacion2 = ObjectAnimator.ofFloat(findViewById(R.id.textViewReglas), View.ALPHA,0,1);
        animacion2.setDuration(700);
        animacion2.start();
        imagenSeleccionadaPrevia = 0;
        contador = 2;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        cargarListas();
        for (int i = 0 ; i<9; i++){
            fragmentTransaction.replace(holders.get(i),FragmentFicha.creadorDeFichas(i, listaDeImagenes.get((int) (Math.random()*4))));
        }
        fragmentTransaction.commit();
    }

    private void cargarResultado(Integer resultado){
        Bundle bundle = new Bundle();
        bundle.putInt(FragmentResultado.RESULTADO, resultado);
        fragmentResultado = new FragmentResultado();
        fragmentResultado.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.entrada_fragment, R.anim.salida_fragment);
        fragmentTransaction.replace(R.id.holderResultado, fragmentResultado);
        fragmentTransaction.commit();
    }

    private void sacarFragmentResultado(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.entrada_fragment, R.anim.salida_fragment);
        fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.holderResultado));
        fragmentTransaction.commit();
    }

    private void sacarFragmentsFichas(){
        ObjectAnimator animacion2 = ObjectAnimator.ofFloat(findViewById(R.id.textViewReglas), View.ALPHA,1,0);
        animacion2.setDuration(700);
        animacion2.start();
        for (int i = 0; i<9; i++){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.entrada_alpha_fragment, R.anim.salida_alpha_fragment);
            fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(holders.get(i)));
            fragmentTransaction.commit();
        }
    }

    private void cargarListas(){
        listaDeImagenes = new ArrayList<>();
        listaDeImagenes.add(R.drawable.ic_android_black_24dp);
        listaDeImagenes.add(R.drawable.ic_arrow_downward_black_24dp);
        listaDeImagenes.add(R.drawable.ic_wifi_black_24dp);
        listaDeImagenes.add(R.drawable.ic_brightness_2_black_24dp);

        holders = new ArrayList<>();
        holders.add(R.id.holder1);
        holders.add(R.id.holder2);
        holders.add(R.id.holder3);
        holders.add(R.id.holder4);
        holders.add(R.id.holder5);
        holders.add(R.id.holder6);
        holders.add(R.id.holder7);
        holders.add(R.id.holder8);
        holders.add(R.id.holder9);
    }
}

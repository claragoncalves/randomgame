package com.example.digitalhouse.memoria;


import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFicha extends Fragment {

    public static final String NUMEROFRAGMENT = "numeroFragment";
    public static final String IMAGENFRAGMENT = "imagenFragment";
    private FrameLayout frameLayoutCover;
    private EnviarNumero enviarNumero;
    private Integer idNumeroFoto;

    public static FragmentFicha creadorDeFichas(Integer numero, Integer imagen) {
        FragmentFicha fragmentFicha = new FragmentFicha();
        Bundle bundle = new Bundle();
        bundle.putInt(NUMEROFRAGMENT, numero);
        bundle.putInt(IMAGENFRAGMENT, imagen);
        fragmentFicha.setArguments(bundle);
        return fragmentFicha;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ficha, container, false);

        Bundle bundle = getArguments();

        ImageView imageView = (ImageView) view.findViewById(R.id.imagenFicha);
        idNumeroFoto = bundle.getInt(IMAGENFRAGMENT);
        imageView.setImageResource(idNumeroFoto);

        frameLayoutCover = (FrameLayout) view.findViewById(R.id.fichaCover);
        frameLayoutCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animacion2 = ObjectAnimator.ofFloat(frameLayoutCover, View.ALPHA,1,0);
                animacion2.setDuration(400);
                animacion2.start();
                enviarNumero.enviarResultado(idNumeroFoto);
                frameLayoutCover.setOnClickListener(null);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        enviarNumero = (EnviarNumero) activity;
    }

    public interface EnviarNumero {
        void enviarResultado(Integer imagenSeleccionada);
    }

}


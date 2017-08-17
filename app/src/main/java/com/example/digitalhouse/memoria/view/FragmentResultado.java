package com.example.digitalhouse.memoria.view;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitalhouse.memoria.R;
import com.example.digitalhouse.memoria.controller.ControllerResultado;
import com.example.digitalhouse.memoria.model.pojo.Resultado;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentResultado extends Fragment {

    public static final String RESULTADO = "resultado";
    private NuevoJuego jugarDeNuevo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_resultado, container, false);

        TextView textViewResultado = (TextView) view.findViewById(R.id.textViewResultado);
        TextView textViewCoincidencia = (TextView)view.findViewById(R.id.textViewCoincidencia);
        ImageView imageViewResultado = (ImageView) view.findViewById(R.id.imagenResultado);
        TextView textViewPorcentaje = (TextView) view.findViewById(R.id.textViewResultadoPorcentaje);

        ControllerResultado controllerResultado = new ControllerResultado();
        textViewPorcentaje.setText(controllerResultado.verResultados(getContext()) + getResources().getString(R.string.porcentaje_char));

        Bundle bundle = getArguments();

        if (bundle.getBoolean(RESULTADO)){
            imageViewResultado.setImageResource(R.drawable.ic_tag_faces_black_24dp);
            textViewCoincidencia.setText(R.string.coinciden);
            textViewResultado.setText(R.string.ganaste);
        }else {
            imageViewResultado.setImageResource(R.drawable.ic_mood_bad_black_24dp);
            textViewCoincidencia.setText(R.string.no_coinciden);
            textViewResultado.setText(R.string.perdiste);
        }

        TextView buttonJugarDeNuevo = (TextView) view.findViewById(R.id.buttonJugarDeNuevo);
        buttonJugarDeNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugarDeNuevo.jugarDeNuevo();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        jugarDeNuevo = (NuevoJuego) activity;
    }

    public interface NuevoJuego {
        void jugarDeNuevo();

    }
}

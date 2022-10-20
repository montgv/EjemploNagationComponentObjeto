package com.example.ejemplonagationcomponentobjeto.Fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejemplonagationcomponentobjeto.Persona;
import com.example.ejemplonagationcomponentobjeto.R;

public class FinalFragment extends Fragment {

    public FinalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_final, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        TextView txt1 = view.findViewById(R.id.edNombreSeg);
        TextView txt2 = view.findViewById(R.id.edTelefonoSeg);
        TextView txt3 = view.findViewById(R.id.edApellidosSeg);
        Button boton = view.findViewById(R.id.btInicio);

        if (getArguments() != null) {
            Persona registro = getArguments().getParcelable("persona");

            txt1.setText("El nombre es: " + registro.getNombre());
            txt2.setText("Los apellidos son: " + registro.getApellidos());
            txt3.setText("El telefono es: " + registro.getTelefono());
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_finalFragment_to_inicioFragment);
            }
        });
    }
}
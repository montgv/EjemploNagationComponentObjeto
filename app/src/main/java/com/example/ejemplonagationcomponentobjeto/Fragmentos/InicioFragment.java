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
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejemplonagationcomponentobjeto.Persona;
import com.example.ejemplonagationcomponentobjeto.R;

public class InicioFragment extends Fragment {

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        final EditText edit1 = view.findViewById(R.id.edNombre);
        final EditText edit2 = view.findViewById(R.id.edTelefono);
        final EditText edit3 = view.findViewById(R.id.edApellidos);
        final Button boton = view.findViewById(R.id.btSegunda);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = "";
                int telefono = 0;
                String apellidpos = "";

                if (edit1.getText().toString().isEmpty() || edit2.getText().toString().isEmpty() ||
                        edit3.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Debes introducir todos los datos", Toast.LENGTH_SHORT).show();
                } else {
                    Persona registro = new Persona(edit1.getText().toString(), edit2.getText().toString(), Integer.parseInt(edit3.getText().toString()));

                    Bundle bundle = new Bundle();
                    bundle.putParcelable("persona", registro);

                    navController.navigate(R.id.action_inicioFragment_to_finalFragment, bundle);
                }
            }
        });
    }
}
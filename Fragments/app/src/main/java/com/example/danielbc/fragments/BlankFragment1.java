package com.example.danielbc.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Aquest Fragment sí que s'ha de comunicar amb l'activity, per tant crearem una interface
 * de comunicació {@link BlankFragment1.ComunicaFragment1AmbActivity}.
 * Aquest fragment rebrà un missatge en un objecte EditText, i depenent del botó que polse l'usuari
 * enviarà eixe missatge a un fragment o a un altre.
 */
public class BlankFragment1 extends Fragment implements View.OnClickListener {
    private EditText etF1;
    private Button buttonBF, buttonBF2;
    private ComunicaFragment1AmbActivity mListener;


    public BlankFragment1() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);

        etF1 = v.findViewById(R.id.editTextBF1);
        buttonBF = v.findViewById(R.id.buttonBF);
        buttonBF2 = v.findViewById(R.id.buttonBF2);

        buttonBF.setOnClickListener(this);
        buttonBF2.setOnClickListener(this);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ComunicaFragment1AmbActivity) {
            mListener = (ComunicaFragment1AmbActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " has d'implementar la interfície ComunicaFragment1AmbActivity");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

        mListener = null;

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonBF) {
            Log.d("Manel", "He entrat en 2 ");
            mListener.enviaMissatgeEscritAActivity(2, etF1.getText().toString());
        }
        if (v.getId() == R.id.buttonBF2) {
            Log.d("Manel", "He entrat en 3 ");
            mListener.enviaMissatgeEscritAActivity(3, etF1.getText().toString());
        }
    }

    public interface ComunicaFragment1AmbActivity {
        // Mètode que ens enviarà el botó polsat i el missatge a enviar a l'activity
        void enviaMissatgeEscritAActivity(int destinatari, String missatge);

    }
}
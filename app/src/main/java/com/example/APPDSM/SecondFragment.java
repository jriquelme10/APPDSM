package com.example.APPDSM;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.APPDSM.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EditText txt_num1, txt_num2,txt_resultado;
    private Spinner spin_options;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        txt_num1 = (EditText)binding.txtNum1;
        txt_num2 = (EditText)binding.txtNum2;
        txt_resultado = (EditText)binding.txtResultado;
        spin_options = (Spinner)binding.spinOptions;

        String [] operations =
                {
                        "Sumar",
                        "Restar",
                        "Multiplicar",
                        "Dividir"

                };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(),R.layout.design_spinner,operations);
        spin_options.setAdapter(adapter);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });

        binding.btnCalcular.setOnClickListener((View v)->{
        String selected = spin_options.getSelectedItem().toString();

        switch (selected){
            case"Sumar":{
                sum();
                break;
            }
            case"Restar":{
                sub();
                break;
            }
            case"Multiplicar":{
                mul();
                break;
            }
            case"Dividir":{
                div();
                break;
            } default:{
                showMessage  ();
            }
        }
        });
    }

    public void showMessage(){
        Toast.makeText(this.getContext(),"No ha seleccionado ninguna opcion",Toast.LENGTH_SHORT);
    }


    public String sum() {
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        double sum = val_1 + val_2;
        String res = String.valueOf(sum);
        txt_resultado.setText(res);
        return res;
    }

    public String sub() {
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        double sum = val_1 - val_2;
        String res = String.valueOf(sum);
        txt_resultado.setText(res);
        return res;
    }

    public String mul() {
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        double sum = val_1 * val_2;
        String res = String.valueOf(sum);
        txt_resultado.setText(res);
        return res;
    }

    public String div() {
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        String res = "";
        if (val_2 != 0) {
            double sum = val_1 / val_2;
            res = String.valueOf(sum);
            txt_resultado.setText(res);
        } else {
            Toast.makeText(this.getContext(), "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
        }
        return res;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
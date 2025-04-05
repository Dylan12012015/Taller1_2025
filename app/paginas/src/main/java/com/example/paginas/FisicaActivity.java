package com.example.paginas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FisicaActivity extends AppCompatActivity {
    private EditText inputMetros;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);

        inputMetros = findViewById(R.id.inputMetros);
        resultado = findViewById(R.id.resultado);
    }

    public void convertir(View view) {
        double metros = Double.parseDouble(inputMetros.getText().toString());
        double kilometros = metros / 1000;
        resultado.setText("Kilómetros: " + kilometros);
    }
}
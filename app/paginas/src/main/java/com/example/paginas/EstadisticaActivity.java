package com.example.paginas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EstadisticaActivity extends AppCompatActivity {
    private EditText inputNumeros;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        inputNumeros = findViewById(R.id.inputNumeros);
        resultado = findViewById(R.id.resultado);
    }

    public void calcular(View view) {
        String[] strNumeros = inputNumeros.getText().toString().split(",");
        double[] numeros = Arrays.stream(strNumeros).mapToDouble(Double::parseDouble).toArray();
        double res = 0;

        if (((RadioButton) findViewById(R.id.media)).isChecked()) {
            res = Arrays.stream(numeros).average().orElse(0);
        } else if (((RadioButton) findViewById(R.id.mediana)).isChecked()) {
            Arrays.sort(numeros);
            int mid = numeros.length / 2;
            res = (numeros.length % 2 == 0) ? (numeros[mid - 1] + numeros[mid]) / 2 : numeros[mid];
        } else if (((RadioButton) findViewById(R.id.moda)).isChecked()) {
            Map<Double, Integer> frecuencia = new HashMap<>();
            for (double num : numeros) frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
            res = numeros[0];
            int maxFreq = 0;
            for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    res = entry.getKey();
                }
            }
        }
        resultado.setText("Resultado: " + res);
    }
}

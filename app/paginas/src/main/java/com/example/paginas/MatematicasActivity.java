package com.example.paginas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MatematicasActivity extends AppCompatActivity {
    private EditText num1, num2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultado = findViewById(R.id.resultado);
    }

    public void calcular(View view) {
        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());
        double res = 0;

        if (((RadioButton) findViewById(R.id.suma)).isChecked()) res = a + b;
        else if (((RadioButton) findViewById(R.id.resta)).isChecked()) res = a - b;
        else if (((RadioButton) findViewById(R.id.multiplicacion)).isChecked()) res = a * b;
        else if (((RadioButton) findViewById(R.id.division)).isChecked() && b != 0) res = a / b;

        resultado.setText("Resultado: " + res);
    }
}
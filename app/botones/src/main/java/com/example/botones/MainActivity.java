package com.example.botones;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView mensaje;
    Button aumentar, decrementar, cambioColor, cambiarFuente;
    float tamañoInicial;
    int colorIndex = 0;
    int fuenteIndex = 0;

    int[] colores = {Color.RED, Color.BLUE, Color.GREEN, Color.BLACK};


    String[] fuentes = {"sans-serif", "serif", "monospace"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mensaje = findViewById(R.id.txtmessage);
        aumentar = findViewById(R.id.button);
        decrementar = findViewById(R.id.button4);
        cambioColor = findViewById(R.id.button2);
        cambiarFuente = findViewById(R.id.button3);


        tamañoInicial = mensaje.getTextSize();


        aumentar.setOnClickListener(view -> {
            float tamañoActual = mensaje.getTextSize();
            if (tamañoActual < 100) { // Límite máximo
                mensaje.setTextSize(TypedValue.COMPLEX_UNIT_PX, tamañoActual + 10f);
                Toast.makeText(getApplicationContext(), "Tamaño: " + mensaje.getTextSize(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Tamaño máximo alcanzado", Toast.LENGTH_SHORT).show();
            }
        });


        decrementar.setOnClickListener(view -> {
            float tamañoActual = mensaje.getTextSize();
            if (tamañoActual > 30) { // Límite mínimo
                mensaje.setTextSize(TypedValue.COMPLEX_UNIT_PX, tamañoActual - 10f);
                Toast.makeText(getApplicationContext(), "Tamaño: " + mensaje.getTextSize(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Tamaño mínimo alcanzado", Toast.LENGTH_SHORT).show();
            }
        });


        cambioColor.setOnClickListener(view -> {
            colorIndex = (colorIndex + 1) % colores.length;
            mensaje.setTextColor(colores[colorIndex]);
        });


        cambiarFuente.setOnClickListener(view -> {
            fuenteIndex = (fuenteIndex + 1) % fuentes.length;
            mensaje.setTypeface(Typeface.create(fuentes[fuenteIndex], Typeface.NORMAL));
        });


    }
}

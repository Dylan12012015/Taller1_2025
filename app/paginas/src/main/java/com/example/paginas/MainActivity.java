package com.example.paginas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirMatematicas(View view) {
        startActivity(new Intent(this, MatematicasActivity.class));
    }

    public void abrirFisica(View view) {
        startActivity(new Intent(this, FisicaActivity.class));
    }

    public void abrirEstadistica(View view) {
        startActivity(new Intent(this, EstadisticaActivity.class));
    }
}
package com.ramon.ludiamanst;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private double diamantes = 20.0; // Tu saldo inicial
    private int anunciosVistosEnSesion = 0;
    private long tiempoUltimoBloqueo = 0;
    private boolean enEsperaEntreAnuncios = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVerAnuncio = findViewById(R.id.btn_ver_anuncio);

        btnVerAnuncio.setOnClickListener(v -> {
            long tiempoActual = System.currentTimeMillis();

            // 1. Verificar bloqueo de 1 hora (3600000 milisegundos)
            if (tiempoActual - tiempoUltimoBloqueo < 3600000) {
                long minutosRestantes = 60 - ((tiempoActual - tiempoUltimoBloqueo) / 60000);
                Toast.makeText(this, "Réessayez dans " + minutosRestantes + " minutes.", Toast.LENGTH_SHORT).show();
                return;
            }

            // 2. Verificar espera de 5 segundos entre anuncios
            if (enEsperaEntreAnuncios) {
                Toast.makeText(this, "Attendez 5 secondes...", Toast.LENGTH_SHORT).show();
                return;
            }

            // --- Aquí se ejecuta el anuncio de AdMob ---
            mostrarAnuncioRecompensado();
        });
    }

    private void mostrarAnuncioRecompensado() {
        // Simulación de que el anuncio se vio con éxito:
        
        diamantes += 0.4; // 0.4 * 250 anuncios = 100 diamantes
        anunciosVistosEnSesion++;

        String mensaje = "Félicitations ! Vous avez " + String.format("%.1f", diamantes) + " diamants.";
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();

        if (anunciosVistosEnSesion >= 6) {
            // Bloqueo por una hora tras 6 anuncios
            anunciosVistosEnSesion = 0;
            tiempoUltimoBloqueo = System.currentTimeMillis();
            Toast.makeText(this, "Session terminée. Revenez dans 1 heure.", Toast.LENGTH_LONG).show();
        } else {
            // Activar espera de 5 segundos para el siguiente
            enEsperaEntreAnuncios = true;
            new Handler().postDelayed(() -> {
                enEsperaEntreAnuncios = false;
            }, 5000);
        }
    }
}

package com.ludiamanst.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int diamantes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración del botón para ganar diamantes
        Button btnGagner = findViewById(R.id.btn_ver_anuncio);
        btnGagner.setOnClickListener(v -> {
            // Aquí se activará el anuncio de AdMob
            diamantes++;
            String mensaje = "Félicitations ! Vous avez " + diamantes + " diamants.";
            Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
        });
    }
}

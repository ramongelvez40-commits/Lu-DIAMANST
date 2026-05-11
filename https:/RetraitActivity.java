package com.ludiamanst.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RetraitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrait);

        EditText idJoueur = findViewById(R.id.id_joueur);
        Button btnDemander = findViewById(R.id.btn_demander);

        btnDemander.setOnClickListener(v -> {
            String id = idJoueur.getText().toString();
            if (!id.isEmpty()) {
                Toast.makeText(this, "Demande envoyée ! ID: " + id, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Veuillez entrer votre ID", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

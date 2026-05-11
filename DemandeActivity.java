// 1. Déclaration des composants
EditText inputIdJoueur = findViewById(R.id.id_joueur);
Button btnDemander = findViewById(R.id.btn_demander);

// 2. Logique du bouton
btnDemander.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // On récupère l'ID et on enlève les espaces inutiles avec .trim()
        String id = inputIdJoueur.getText().toString().trim();

        if (!id.isEmpty()) {
            // Message de succès en français
            String messageSucces = "Demande envoyée ! ID : " + id;
            Toast.makeText(getApplicationContext(), messageSucces, Toast.LENGTH_LONG).show();
            
            // Ici, vous pouvez ajouter la logique pour envoyer les données au serveur
        } else {
            // Message d'erreur si le champ est vide
            Toast.makeText(getApplicationContext(), "Veuillez entrer votre ID", Toast.LENGTH_SHORT).show();
        }
    }
});

package com.example.tesisjoelapppruebabalanza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class prueba1 extends AppCompatActivity {

    Button btn_at, btn_productos, btn_perfil;
    EditText perfilnombre, perfilcorreo, perfilllave;

    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prueba1);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        btn_at = findViewById(R.id.btn_at);
        btn_productos = findViewById(R.id.btn_productos);
        //btn_perfil = findViewById(R.id.btn_perfil);
        perfilcorreo = findViewById(R.id.perfilcorreo);
        perfilnombre = findViewById(R.id.perfilnombre);
        perfilllave = findViewById(R.id.perfilllave);

        Bundle bundle = getIntent().getExtras();
        String correo1 = bundle.getString("correo");

        btn_at.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(prueba1.this, LoginAdministrador.class));
            }
        });

        btn_productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(prueba1.this, productos.class));
            }
        });

        mFirestore.collection("user").whereEqualTo("email", correo1).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        // Log.d(TAG, document.getId() + " => " + document.getData());
                        String email = document.getData().get("email").toString().trim();
                        String llave = document.getData().get("llave").toString().trim();
                        String name = document.getData().get("name").toString().trim();

                        perfilcorreo.setText(email);
                        perfilllave.setText(llave);
                        perfilnombre.setText(name);
                        //editTotalCajas.setText(peso);



                        // Toast.makeText(pesajetipocaja.this, day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();

                        //prueba.setText(document.getData().get("llave").toString());
                    }
                } else {
                    // Log.d(TAG, "Error getting documents: ", task.getException());
                    Toast.makeText(prueba1.this, "No se obtuvieron los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*btn_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(prueba1.this, perfilAdministrador.class));

            }
        });*/

    }
}
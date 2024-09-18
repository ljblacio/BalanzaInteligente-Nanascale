package com.example.tesisjoelapppruebabalanza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
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

public class opcionesOperador extends AppCompatActivity {

    Button btn_close, btn_produ;
    EditText operadorperfnombre, operadorperfemail;
    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opciones_operador);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        btn_close = findViewById(R.id.btn_close);
        btn_produ = findViewById(R.id.btn_produ);

        operadorperfemail = findViewById(R.id.operadorperfemail);
        operadorperfnombre = findViewById(R.id.operadorperfnombre);

        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        Bundle bundle = getIntent().getExtras();
        String correo1 = bundle.getString("correo");

        mFirestore.collection("user").whereEqualTo("email", correo1).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        // Log.d(TAG, document.getId() + " => " + document.getData());
                        String email = document.getData().get("email").toString().trim();
                        //String llave = document.getData().get("llave").toString().trim();
                        String name = document.getData().get("name").toString().trim();

                        operadorperfemail.setText(email);
                        //perfilllave.setText(llave);
                        operadorperfnombre.setText(name);
                        //editTotalCajas.setText(peso);



                        // Toast.makeText(pesajetipocaja.this, day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();

                        //prueba.setText(document.getData().get("llave").toString());
                    }
                } else {
                    // Log.d(TAG, "Error getting documents: ", task.getException());
                    Toast.makeText(opcionesOperador.this, "No se obtuvieron los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(opcionesOperador.this, LoginActivity.class));
            }
        });

        btn_produ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(opcionesOperador.this, productosOperador.class));
            }
        });



    }
}
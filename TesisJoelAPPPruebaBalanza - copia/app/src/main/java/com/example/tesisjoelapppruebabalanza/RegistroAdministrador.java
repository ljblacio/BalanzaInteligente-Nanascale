package com.example.tesisjoelapppruebabalanza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

public class RegistroAdministrador extends AppCompatActivity {

    Button btn_register, btn_ventanaanterior;
    EditText name, hotmail, password, llave, prueba;
    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;
    //TextView prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_administrador);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.name);
        hotmail = findViewById(R.id.hotmail);
        password = findViewById(R.id.password);
        llave = findViewById(R.id.llave);

        prueba = findViewById(R.id.prueba);

        btn_register = findViewById(R.id.btn_register);
        btn_ventanaanterior = findViewById(R.id.btn_ventanaanterior);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameUser = name.getText().toString().trim();
                String emailUser = hotmail.getText().toString().trim();
                String passUser = password.getText().toString().trim();
                String llaUser = llave.getText().toString().trim();

                if(nameUser.isEmpty() && emailUser.isEmpty() && passUser.isEmpty() && llaUser.isEmpty()){
                    Toast.makeText(RegistroAdministrador.this, "Complete los datos", Toast.LENGTH_SHORT).show();
                   /* mFirestore.collection("administrador").document("hWm6XeJdO8WWsKntxvZJ").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if(documentSnapshot.exists()){
                                String correo = documentSnapshot.getString("correo");
                                String llave = documentSnapshot.getString("llave");

                                prueba.setText("correo" + correo + "llave" + llave);


                            }
                        }
                    });*/


                    /*mFirestore.collection("administrador")
                            .whereEqualTo("correo", "donosodebbie1@gmail.com")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            Log.d(TAG, document.getId() + " => " + document.getData());
                                            prueba.setText(document.getData().get("llave").toString());
                                        }
                                    } else {
                                        Log.d(TAG, "Error getting documents: ", task.getException());
                                    }
                                }
                            });*/



                }else{


                    mFirestore.collection("administrador")
                            .whereEqualTo("correo", emailUser)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                           // Log.d(TAG, document.getId() + " => " + document.getData());
                                            String clave = document.getData().get("llave").toString().trim();
                                            String correo = document.getData().get("correo").toString().trim();

                                            if(emailUser.equals(correo) && llaUser.equals(clave)){

                                                registerUser(nameUser, emailUser, passUser, llaUser);
                                            }

                                            //prueba.setText(document.getData().get("llave").toString());
                                        }
                                    } else {
                                       // Log.d(TAG, "Error getting documents: ", task.getException());
                                        Toast.makeText(RegistroAdministrador.this, "Los datos no coinciden", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                    //registerUser(nameUser, emailUser, passUser, llaUser);

                        //Toast.makeText(Registro.this, "Registro", Toast.LENGTH_SHORT).show();

                    }
                }


        });


        btn_ventanaanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                startActivity(new Intent(RegistroAdministrador.this, LoginAdministrador.class));
            }
        });

    }

    private void registerUser(String nameUser, String emailUser, String passUser, String llaUser) {

        mAuth.createUserWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("name", nameUser);
                map.put("email", emailUser);
                map.put("password", passUser);
                map.put("llave", llaUser);

                mFirestore.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        startActivity(new Intent(RegistroAdministrador.this, LoginAdministrador.class));
                        Toast.makeText(RegistroAdministrador.this, "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegistroAdministrador.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegistroAdministrador.this, "Error al registrar", Toast.LENGTH_SHORT ).show();
            }
        });



    }



}
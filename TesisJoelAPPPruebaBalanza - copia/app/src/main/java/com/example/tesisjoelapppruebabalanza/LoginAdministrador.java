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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAdministrador extends AppCompatActivity {

    Button btn_in, btn_design, btn_back;
    EditText email, pass;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_administrador);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        btn_back = findViewById(R.id.btn_back);
        btn_in = findViewById(R.id.btn_in);
        btn_design = findViewById(R.id.btn_design);



        btn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = email.getText().toString().trim();
                String passUser = pass.getText().toString().trim();

                if(emailUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(LoginAdministrador.this, "Ingresar los datos", Toast.LENGTH_SHORT).show();


                }else{

                    LoginUser(emailUser, passUser);

                }

            }
        });

        btn_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LoginAdministrador.this, RegistroAdministrador.class));
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LoginAdministrador.this, ROL.class));
            }
        });



    }

    private void LoginUser(String emailUser, String passUser) {

        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    //startActivity(new Intent(LoginAdministrador.this, prueba1.class));
                    Toast.makeText(LoginAdministrador.this, "Bienvenido", Toast.LENGTH_SHORT).show();

                    //startActivity(new Intent(opcionesProductosAdministrador.this, pesajetipocaja.class));
                    Intent intent = new Intent(LoginAdministrador.this, prueba1.class);
                    intent.putExtra("correo", emailUser);
                    startActivity(intent);

                }else {
                    Toast.makeText(LoginAdministrador.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginAdministrador.this, "Error al iniciar sesión" , Toast.LENGTH_SHORT).show();
            }
        });

    }
}
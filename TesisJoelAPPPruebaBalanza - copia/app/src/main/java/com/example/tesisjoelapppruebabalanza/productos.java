package com.example.tesisjoelapppruebabalanza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class productos extends AppCompatActivity {

    Button btn_gobackatr, btn_31lb, btn_41lb, btn_43lb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_productos);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        btn_gobackatr = findViewById(R.id.btn_gobackatr);
        btn_31lb = findViewById(R.id.btn_31lb);
        btn_41lb = findViewById(R.id.btn_41lb);
        btn_43lb = findViewById(R.id.btn_43lb);

        btn_gobackatr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(productos.this, LoginAdministrador.class));
            }
        });

        btn_31lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_31lb = (Button)v;
                String txt31lb = btn_31lb.getText().toString();
                Intent intent = new Intent(productos.this, opcionesProductosAdministrador.class);
                intent.putExtra("nombreBoton", txt31lb);
                startActivity(intent);
            }
        });

        btn_41lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_41lb = (Button)v;
                String txt41lb = btn_41lb.getText().toString();
                Intent intent2 = new Intent(productos.this, opcionesProductosAdministrador.class);
                intent2.putExtra("nombreBoton", txt41lb);
                startActivity(intent2);
            }
        });

        btn_43lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_43lb = (Button)v;
                String txt43lb = btn_43lb.getText().toString();
                Intent intent3 = new Intent(productos.this, opcionesProductosAdministrador.class);
                intent3.putExtra("nombreBoton", txt43lb);
                startActivity(intent3);
            }
        });

    }
}
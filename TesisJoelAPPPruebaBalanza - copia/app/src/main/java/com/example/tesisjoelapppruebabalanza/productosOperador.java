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

public class productosOperador extends AppCompatActivity {

    Button btn_chao, btn_caja31, btn_caja41, btn_caja43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_productos_operador);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/


        btn_chao = findViewById(R.id.btn_chao);
        btn_caja31 = findViewById(R.id.btn_caja31);
        btn_caja41 = findViewById(R.id.btn_caja41);
        btn_caja43 = findViewById(R.id.btn_caja43);

        btn_chao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(productosOperador.this, LoginActivity.class));
            }
        });

        btn_caja31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_31lb = (Button)v;
                String txt31lb = btn_31lb.getText().toString();
                Intent intent = new Intent(productosOperador.this, pesajetipocajaOperador.class);
                intent.putExtra("nombreBoton", txt31lb);
                startActivity(intent);
            }
        });

        btn_caja41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_41lb = (Button)v;
                String txt41lb = btn_41lb.getText().toString();
                Intent intent2 = new Intent(productosOperador.this, pesajetipocajaOperador.class);
                intent2.putExtra("nombreBoton", txt41lb);
                startActivity(intent2);
            }
        });

        btn_caja43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_43lb = (Button)v;
                String txt43lb = btn_43lb.getText().toString();
                Intent intent3 = new Intent(productosOperador.this, pesajetipocajaOperador.class);
                intent3.putExtra("nombreBoton", txt43lb);
                startActivity(intent3);
            }
        });

    }
}
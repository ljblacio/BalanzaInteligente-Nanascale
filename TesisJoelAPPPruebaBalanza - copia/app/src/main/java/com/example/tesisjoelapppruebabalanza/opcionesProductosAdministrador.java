package com.example.tesisjoelapppruebabalanza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class opcionesProductosAdministrador extends AppCompatActivity {

    Button btn_pesaje, btn_comeatras, btn_ventas, btn_ganancia, btn_perdida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opciones_productos_administrador);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/


        btn_pesaje = findViewById(R.id.btn_pesaje);
        btn_comeatras = findViewById(R.id.btn_comeatras);
        btn_ventas = findViewById(R.id.btn_ventas);
        btn_ganancia = findViewById(R.id.btn_ganancia);
        btn_perdida = findViewById(R.id.btn_perdida);

        Bundle bundle = getIntent().getExtras();
        String datoCaja = bundle.getString("nombreBoton");

        btn_pesaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(opcionesProductosAdministrador.this, pesajetipocaja.class));
                Intent intent = new Intent(opcionesProductosAdministrador.this, pesajetipocaja.class);
                intent.putExtra("nombreBoton", datoCaja);
                startActivity(intent);

            }
        });


        if(datoCaja.equalsIgnoreCase("Caja de 31 lb")){

            btn_perdida.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, perdidasCaja31lb.class));
                }
            });

        }


        if(datoCaja.equalsIgnoreCase("Caja de 31 lb")){

            btn_ganancia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, gananciasAdministrador.class));
                }
            });

        }


        if(datoCaja.equalsIgnoreCase("Caja de 31 lb")){

            btn_ventas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, ventasAdministrador.class));
                }
            });

        }

        if(datoCaja.equalsIgnoreCase("caja de 41 lb")){

            btn_ventas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, ventasAdministrador41lb.class));
                    //Toast.makeText(opcionesProductosAdministrador.this, "PRUEBA 41LB", Toast.LENGTH_SHORT).show();
                }
            });

        }


        if(datoCaja.equalsIgnoreCase("caja de 41 lb")){

            btn_ganancia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, gananciasAdministrador41lb.class));
                    //Toast.makeText(opcionesProductosAdministrador.this, "PRUEBA 41LB", Toast.LENGTH_SHORT).show();
                }
            });

        }

        if(datoCaja.equalsIgnoreCase("caja de 41 lb")){

            btn_perdida.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, perdidasCaja41lb.class));
                    //Toast.makeText(opcionesProductosAdministrador.this, "PRUEBA 41LB", Toast.LENGTH_SHORT).show();
                }
            });

        }

        /*if(datoCaja.equalsIgnoreCase("caja de 41 lb")){

            btn_ventas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, jplotprueba.class));
                    //Toast.makeText(opcionesProductosAdministrador.this, "PRUEBA 41LB", Toast.LENGTH_SHORT).show();
                }
            });

        }*/

        if(datoCaja.equalsIgnoreCase("caja de 43 lb")){

            btn_ventas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, ventasAdministrador43lb.class));
                }
            });

        }


        if(datoCaja.equalsIgnoreCase("caja de 43 lb")){

            btn_ganancia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, gananciasAdministrador43lb.class));
                }
            });

        }

        if(datoCaja.equalsIgnoreCase("caja de 43 lb")){

            btn_perdida.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(opcionesProductosAdministrador.this, perdidasCaj43lb.class));
                }
            });

        }



        btn_comeatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(opcionesProductosAdministrador.this, productos.class));
            }
        });

    }
}
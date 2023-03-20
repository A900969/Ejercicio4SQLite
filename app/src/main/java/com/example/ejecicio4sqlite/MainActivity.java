package com.example.ejecicio4sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Persona> listaPersonas;
    private RecyclerView recyclerView;
    private SQLiteDatabase personasBBDD;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycledView);
        listaPersonas = new ArrayList<>();
        dbHelper = new DbHelper(this);


        insertaPersonas();
        setPersonaInfo();
        setAdapter();
    }

    private void insertaPersonas() {
        addPersonaInfo("45623568T", "Pepe", "Rodríguez de la Fuente", 16 , "C/Romero 14" );
        addPersonaInfo("45782154M", "Rocío", "Gutierrez Gómez", 23 , "C/Tordesillas 25" );
        addPersonaInfo("52368954B", "Manuel", "Díaz Hurtado", 42 , "C/San Pío XII 34" );
        addPersonaInfo("58471253F", "Rosa", "Benítez Quintero", 31 , "C/Picasso 3" );
        addPersonaInfo("14253698V", "Francisca", "Altúnez Fraile ", 53 , "C/Cruz 45" );
    }

    private void addPersonaInfo(String dni,String nombre,String apellidos,int edad,String direccion) {
        personasBBDD = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("dni", dni);
        values.put("nombre", nombre);
        values.put("apellidos", apellidos);
        values.put("edad", edad);
        values.put("direccion", direccion);

        personasBBDD.insert(DbHelper.TABLE_PERSONAS, null, values);
        personasBBDD.close();
    }

    private void setAdapter(){
        Adapter adapter = new Adapter(listaPersonas, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setPersonaInfo() {
        personasBBDD = dbHelper.getReadableDatabase();
        Cursor cursor = personasBBDD.rawQuery("SELECT * FROM " + DbHelper.TABLE_PERSONAS + " GROUP BY edad" , null);
        while (cursor.moveToNext()){
            listaPersonas.add(new Persona(cursor.getString(cursor.getColumnIndexOrThrow("dni")),cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                    cursor.getString(cursor.getColumnIndexOrThrow("apellidos")),cursor.getInt(cursor.getColumnIndexOrThrow("edad")),
                    cursor.getString(cursor.getColumnIndexOrThrow("direccion"))));
        }

        cursor.close();
        personasBBDD.close();



    }
}
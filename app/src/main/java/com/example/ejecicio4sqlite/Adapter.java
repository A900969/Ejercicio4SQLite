package com.example.ejecicio4sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements AdapterView.OnItemClickListener{
    private ArrayList<Persona> listaPersonas;
    private Context contexto;

    public Adapter(ArrayList<Persona> lista, Context contexto){
        listaPersonas = lista;
        this.contexto = contexto;

    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView apellidos;
        private TextView edad;

        public MyViewHolder(final View view){
            super(view);
            nombre = view.findViewById(R.id.txt_nombre);
            apellidos = view.findViewById(R.id.txt_apellidos);
            edad = view.findViewById(R.id.txt_edad);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Intent intento = new Intent(, SecondActivity.class);
//          intento.putExtra("Empleado", listaEmpleados.get(i));
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento,parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
//        holder.itemView.setOnClickListener(view -> {
//            Intent intento = new Intent(contexto, SecondActivity.class);
//            intento.putExtra("Empleado", listaEmpleados.get(position));
//            holder.itemView.getContext().startActivity(intento);
//        });
        String name = listaPersonas.get(position).getNombre();
        holder.nombre.setText(name);
        String surname = listaPersonas.get(position).getApellidos();
        holder.apellidos.setText(surname);
        int age = listaPersonas.get(position).getEdad();
        holder.edad.setText(Integer.toString(age));
//        int photo = listaEmpleados.get(position).getImage();
//        holder.photo.setImageResource(photo);
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }
}


package com.cdp.malaga_ocio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador_Ubicaciones extends RecyclerView.Adapter<Adaptador_Ubicaciones.ViewHolderUbicaciones> {

    ArrayList<LugaresVO> listaLugares;
    final Adaptador_Ubicaciones.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(LugaresVO item);
    }


    public Adaptador_Ubicaciones(ArrayList<LugaresVO> listaLugares, Adaptador_Ubicaciones.OnItemClickListener listener) {
        this.listaLugares = listaLugares;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderUbicaciones onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderUbicaciones(view);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderUbicaciones holder, int position) {
        holder.Nombre.setText(listaLugares.get(position).getNombre());
        holder.edad.setText(listaLugares.get(position).getEdad());
        holder.precio.setText(listaLugares.get(position).getPrecio());
        holder.ubicacion.setText(listaLugares.get(position).getUbicacion());
        holder.descripcion.setText(listaLugares.get(position).getDescripcion());
        holder.imagen.setImageResource(listaLugares.get(position).getImagen());
        holder.bindData(listaLugares.get(position));
    }

    @Override
    public int getItemCount() {
        return listaLugares.size();
    }

    public class ViewHolderUbicaciones extends RecyclerView.ViewHolder {

        TextView Nombre, edad, precio, ubicacion, descripcion;
        ImageView imagen;
        CardView cv;
        public ViewHolderUbicaciones(@NonNull View itemView) {
            super(itemView);
            Nombre=(TextView) itemView.findViewById(R.id.Nombre);
            edad=(TextView) itemView.findViewById(R.id.edad);
            precio=(TextView) itemView.findViewById(R.id.precio);
            ubicacion=(TextView) itemView.findViewById(R.id.ubicacion);
            descripcion=(TextView) itemView.findViewById(R.id.descripcion);
            imagen=(ImageView) itemView.findViewById(R.id.imagen);
            cv = itemView.findViewById(R.id.cv);
        }

        public void bindData(final LugaresVO item) {
            Nombre=(TextView) itemView.findViewById(R.id.Nombre);
            edad=(TextView) itemView.findViewById(R.id.edad);
            precio=(TextView) itemView.findViewById(R.id.precio);
            ubicacion=(TextView) itemView.findViewById(R.id.ubicacion);
            descripcion=(TextView) itemView.findViewById(R.id.descripcion);
            imagen=(ImageView) itemView.findViewById(R.id.imagen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}

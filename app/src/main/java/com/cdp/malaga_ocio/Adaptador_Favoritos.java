package com.cdp.malaga_ocio;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cdp.malaga_ocio.databinding.ActivityAgregarFavoritoBinding;
import com.cdp.malaga_ocio.entidades.Favorito;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_Favoritos extends RecyclerView.Adapter<Adaptador_Favoritos.ViewHolderFavoritos> {
private ArrayList<Favorito> listaLugares;
 final Adaptador_Favoritos.OnItemClickListener listener;


    public void RemoveItem(int position) {

        listaLugares.remove(position);
        notifyItemRemoved(position);
    }

    public interface OnItemClickListener {
        void onItemClick(Favorito favorito);
    }


    public Adaptador_Favoritos(ArrayList<Favorito> listaLugares, Adaptador_Favoritos.OnItemClickListener listener) {
        this.listaLugares = listaLugares;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderFavoritos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_2, null, false);
        return new ViewHolderFavoritos(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavoritos holder, int position) {
            holder.tv_fav_nombre.setText(listaLugares.get(position).getNombre());
            holder.tv_fav_ubicacion.setText(listaLugares.get(position).getUbicacion());
            holder.bind(listaLugares.get(position));
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setPosition(holder.getAdapterPosition());

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaLugares.size();
    }

    public class ViewHolderFavoritos extends RecyclerView.ViewHolder {

        TextView tv_fav_nombre, tv_fav_ubicacion;

        public ViewHolderFavoritos(@NonNull View itemView) {
            super(itemView);
            tv_fav_nombre = (TextView) itemView.findViewById(R.id.tv_fav_nombre);
            tv_fav_ubicacion = (TextView) itemView.findViewById(R.id.tv_fav_ubicacion);
            position = getAdapterPosition();



        }
        public void bind(final Favorito favorito){
            tv_fav_nombre = (TextView) itemView.findViewById(R.id.tv_fav_nombre);
            tv_fav_ubicacion = (TextView) itemView.findViewById(R.id.tv_fav_ubicacion);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(favorito);
                }
            });

        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }



}

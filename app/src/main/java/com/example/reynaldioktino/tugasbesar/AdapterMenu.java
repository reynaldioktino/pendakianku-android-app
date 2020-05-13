package com.example.reynaldioktino.tugasbesar;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.ChatHolder> {

    Context context;
    List<Menu> menu;
    LayoutInflater inflater;

    public AdapterMenu(Context context, List<Menu> menu) {
        this.context = context;
        this.menu = menu;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterMenu.ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list, parent,  false);
        return new ChatHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMenu.ChatHolder holder, final int position) {
        Glide.with(context)
                .load(menu.get(position).getImg())
                .into(holder.menuIcon);

        holder.judul.setText(menu.get(position).getJudul());

        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu.get(position).getJudul().equals("Profil")) {
                    Intent i = new Intent(v.getContext(), Profile.class);
                    v.getContext().startActivity(i);
                } else if (menu.get(position).getJudul().equals("Cerita Mendaki")) {
                    Intent i = new Intent(v.getContext(), Cerita.class);
                    v.getContext().startActivity(i);
                } else if (menu.get(position).getJudul().equals("Daftar Gunung")) {
                    Intent i = new Intent(v.getContext(), Gunung.class);
//                    i.putExtra("id_judul", menu.get(position).getJudul());
//                    i.putExtra("id_gambar", menu.get(position).getImg());
//                    i.putExtra("id_nama", "Reynaldi Oktino");
//                    i.putExtra("id_nim", "1641720176");
//                    i.putExtra("id_nomor", "085706526558");
                    v.getContext().startActivity(i);
                } else if (menu.get(position).getJudul().equals("Daftar Pendakian")) {
                    Intent i = new Intent(v.getContext(), Pendakian.class);
                    v.getContext().startActivity(i);
                } else if (menu.get(position).getJudul().equals("Ambil Foto")) {
                    Intent i = new Intent(v.getContext(), Kamera.class);
                    v.getContext().startActivity(i);
                } else if (menu.get(position).getJudul().equals("Tentang Kami")) {
                    Intent i = new Intent(v.getContext(), Login.class);
                    v.getContext().startActivity(i);
                }
                else if (menu.get(position).getJudul().equals("Logout")) {
                    Intent i = new Intent(v.getContext(), Login.class);
                    v.getContext().startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }

    public class ChatHolder extends RecyclerView.ViewHolder {

        CardView cardItem;
        TextView judul;
        ImageView menuIcon;

        public ChatHolder(@NonNull View itemView) {
            super(itemView);
            cardItem = (CardView) itemView.findViewById(R.id.card_view);
            menuIcon = (ImageView) itemView.findViewById(R.id.daftar_icon);
            judul = (TextView) itemView.findViewById(R.id.daftar_judul);
        }
    }
}

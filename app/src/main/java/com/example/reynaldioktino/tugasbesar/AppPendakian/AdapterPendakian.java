package com.example.reynaldioktino.tugasbesar.AppPendakian;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reynaldioktino.tugasbesar.R;

import java.util.List;

public class AdapterPendakian extends RecyclerView.Adapter<AdapterPendakian.ViewHolder> {

    List<ModelPendakian> modelspendakian;

    Context context;
    LayoutInflater inflater;

    public AdapterPendakian(Context context, List<ModelPendakian> modelspendakian) {
        this.modelspendakian = modelspendakian;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterPendakian.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pendakian_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPendakian.ViewHolder holder, int position) {
        holder.namaGunung.setText(modelspendakian.get(position).getNamaGunung());
        holder.tanggal.setText(modelspendakian.get(position).getTanggal());
        holder.kota.setText(modelspendakian.get(position).getKota());
    }

    @Override
    public int getItemCount() {
        return modelspendakian.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardItem;
        TextView namaGunung, tanggal, kota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardItem = (CardView) itemView.findViewById(R.id.card_view_pendakian);
            namaGunung = (TextView) itemView.findViewById(R.id.txt_gunung);
            tanggal = (TextView) itemView.findViewById(R.id.txt_tanggal);
            kota = (TextView) itemView.findViewById(R.id.txt_kota);
        }
    }
}

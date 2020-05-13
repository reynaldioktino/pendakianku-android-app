package com.example.reynaldioktino.tugasbesar.AppGunung;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reynaldioktino.tugasbesar.R;
import com.example.reynaldioktino.tugasbesar.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterGunung extends RecyclerView.Adapter<AdapterGunung.ViewHolder> {

    List<ModelGunung> listGunung;
//    Context context;
//    LayoutInflater inflater;

    public AdapterGunung(List<ModelGunung> listGunung) {
        this.listGunung = listGunung;
        //inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterGunung.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gunung_list, parent, false);
        ViewHolder mHolder = new ViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGunung.ViewHolder holder, final int position) {
        holder.txtnama.setText(listGunung.get(position).getNama());

        if (listGunung.get(position).getFoto().length()>0){
//
            Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+"application/"+listGunung.get(position).getFoto());
// .into(holder.mPhotoid);

            Glide.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+"application/"+listGunung.get(position
            ).getFoto())
                    .into(holder.mPhotoid);
        }else{
//
            Picasso.with(holder.itemView.getContext()).load(R.drawable.ic_launcher_background).into(holder.mPhotoid)
            ;

            Glide.with(holder.itemView.getContext()).load(R.drawable.ic_launcher_background).into(holder.mPhotoid);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Detail_gunung.class);
                intent.putExtra("nama",listGunung.get(position).getNama());
                intent.putExtra("lokasi",listGunung.get(position).getLokasi());
                intent.putExtra("deskripsi",listGunung.get(position).getDeskripsi());
                intent.putExtra("latitude_gunung",listGunung.get(position).getLatitude_gunung());
                intent.putExtra("longitude_gunung",listGunung.get(position).getLongitude_gunung());
                intent.putExtra("foto",listGunung.get(position).getFoto());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listGunung.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mPhotoid;
        TextView txtnama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mPhotoid = (ImageView) itemView.findViewById(R.id.foto_gunung);
            txtnama = (TextView) itemView.findViewById(R.id.txt_namagunung);
        }
    }
}

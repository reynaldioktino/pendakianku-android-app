package com.example.reynaldioktino.tugasbesar.AppCerita;

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
import com.example.reynaldioktino.tugasbesar.AppGunung.AdapterGunung;
import com.example.reynaldioktino.tugasbesar.AppGunung.ModelGunung;
import com.example.reynaldioktino.tugasbesar.R;
import com.example.reynaldioktino.tugasbesar.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCerita extends RecyclerView.Adapter<AdapterCerita.ViewHolder> {

    List<ModelCerita> listCerita;
//    Context context;
//    LayoutInflater inflater;

    public AdapterCerita(List<ModelCerita> listCerita) {
        this.listCerita = listCerita;
        //inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterCerita.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cerita_list, parent, false);
        ViewHolder mHolder = new ViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCerita.ViewHolder holder, final int position) {
        holder.txtnamagunung.setText(listCerita.get(position).getNamagunung());
        holder.txtcerita.setText(listCerita.get(position).getCerita());
        if (listCerita.get(position).getPhoto_id().length()>0){
//
            Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+"application/"+listCerita.get(position).getPhoto_id());
// .into(holder.mPhotoid);

            Glide.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+"application/"+listCerita.get(position
            ).getPhoto_id())
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
                Intent intent = new Intent(view.getContext(), PutDelCeritaActivity.class);
                intent.putExtra("id_cerita",listCerita.get(position).getId_cerita());
                intent.putExtra("nama_gunung",listCerita.get(position).getNamagunung());
                intent.putExtra("cerita",listCerita.get(position).getCerita());
                intent.putExtra("photo_id",listCerita.get(position).getPhoto_id());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCerita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mPhotoid;
        TextView txtnamagunung, txtcerita;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mPhotoid = (ImageView) itemView.findViewById(R.id.gambar_gunung);
            txtnamagunung = (TextView) itemView.findViewById(R.id.textNama);
            txtcerita = (TextView) itemView.findViewById(R.id.textCerita);
        }
    }
}

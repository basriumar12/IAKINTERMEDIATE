package info.blogbasbas.iakintermediate.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import info.blogbasbas.iakintermediate.DetailActivity;
import info.blogbasbas.iakintermediate.R;
import info.blogbasbas.iakintermediate.pojo.ResepItem;

/**
 * Created by User on 10/02/2018.
 */

public class AdapterResep extends
        RecyclerView.Adapter<AdapterResep.MyHolder>{

    //variabel
    Context context;
    List<ResepItem> dataresep;

    //constructor
    public AdapterResep(Context context, List<ResepItem> dataresep) {
        this.context = context;
        this.dataresep = dataresep;
    }

    @Override
    public AdapterResep.MyHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_resep,
                        parent,
                        false);
    return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterResep.MyHolder holder, final int position) {
            //set textview
        holder.txtMakanan.setText(dataresep.get(position)
                        .getNamaResep1());
        Glide.with(context)
                .load("http://192.168.1.33/db_resep/foto_makanan/"
                        +dataresep.get(position).getGambar1())
                .into(holder.imgmakanan);
        //onklik itemview
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           Intent kirimdata = new Intent(context, DetailActivity.class);
           kirimdata.putExtra("NAMA", dataresep.get(position).getNamaResep1());
           kirimdata.putExtra("DETAIL", dataresep.get(position).getDetail1());
           kirimdata.putExtra("GAMBAR", dataresep.get(position).getGambar1());
           context.startActivity(kirimdata);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataresep.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
       //variabel
        ImageView imgmakanan;
       TextView txtMakanan;

        public MyHolder(View itemView) {
            super(itemView);
            //inisialisasi
            imgmakanan = (ImageView) itemView.findViewById(R.id.imgmakanan);
            txtMakanan = (TextView)itemView.findViewById(R.id.txtnama);


        }
    }
}

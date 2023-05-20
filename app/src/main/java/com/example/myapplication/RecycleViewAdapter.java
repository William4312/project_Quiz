package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private final Context ctx;
    private ArrayList<medichine_detailData> temp_data_medichine = new ArrayList<>();

    public RecycleViewAdapter(Context ctx, ArrayList<medichine_detailData> temp_data_medichine) {
        this.ctx = ctx;
        this.temp_data_medichine = temp_data_medichine;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(Integer.valueOf(temp_data_medichine.get(position).getImage_medichine()));;
        holder.md_name.setText(String.valueOf(temp_data_medichine.get(position).getMedichine_name()));
        holder.md_manufacture.setText(String.valueOf(temp_data_medichine.get(position).getMedichine_manufactur()));
        holder.md_price.setText(String.valueOf(NumberFormat.getIntegerInstance(Locale.GERMAN).format(temp_data_medichine.get(position).getMadichine_price())));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toDetailPage = new Intent(ctx, MainActivity2.class);
                toDetailPage.putExtra("dataImage_DetailPage", (Integer) temp_data_medichine.get(position).getImage_medichine());
                toDetailPage.putExtra("dataTitle_DetailPage", (String) temp_data_medichine.get(position).getMedichine_name());
                toDetailPage.putExtra("dataManufacture_DetailPage", (String) temp_data_medichine.get(position).getMedichine_manufactur());
                toDetailPage.putExtra("dataPrice_DetailPage", NumberFormat.getIntegerInstance(Locale.GERMAN).format(temp_data_medichine.get(position).getMadichine_price()));
                toDetailPage.putExtra("dataDetail_DetailPage", (String) temp_data_medichine.get(position).getMedichine_detail());
                toDetailPage.putExtra("posisiData", (Integer) position);
                ctx.startActivity(toDetailPage);
            }
        });
    }

    @Override
    public int getItemCount() {
        return temp_data_medichine.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ShapeableImageView imageView;
        private TextView md_name, md_price, md_manufacture;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_medichine_model);
            md_name = itemView.findViewById(R.id.name_medichine);
            md_price = itemView.findViewById(R.id.price_medichine);
            md_manufacture = itemView.findViewById(R.id.manufactur_medichine);
            cardView = itemView.findViewById(R.id.cardView_medichine);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

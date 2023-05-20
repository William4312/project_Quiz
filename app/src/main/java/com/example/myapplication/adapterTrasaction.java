package com.example.myapplication;

import static com.example.myapplication.login.tempPosisi;
import static com.example.myapplication.registerPage.account_dataTemp_arrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class adapterTrasaction extends RecyclerView.Adapter<adapterTrasaction.ViewHolder> {
    ArrayList<trasaction> trasactionsData;
    Context ctx;
    OnItemClickListener listener;
    OnItemClickListenerUpdate listenerUpdate;
    @NonNull
    @Override
    public adapterTrasaction.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trasaction, parent, false);
        return new ViewHolder(view, listener, listenerUpdate);
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public interface OnItemClickListenerUpdate{
        void onItemClickUpdate(int position, int tempData);
    }
    public void setOnItemClickListener(OnItemClickListener clicData){
        listener = clicData;
    }

    public void setOnItemClickListenerUpdate(OnItemClickListenerUpdate clicData){
        listenerUpdate = clicData;
    }

    @Override
    public void onBindViewHolder(@NonNull adapterTrasaction.ViewHolder holder, int position) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<trasactionsData.size(); i++){
            if(trasactionsData.get(i).getDataPersonlitas().getUserID().equals(account_dataTemp_arrayList.get(tempPosisi).getUserID())){
                temp.add(i);
            }
        }
        for(int x=0; x<temp.size(); x++){
            holder.UserID.setText(trasactionsData.get(temp.get(x)).getDataPersonlitas().getUserID());
            holder.username.setText(trasactionsData.get(temp.get(x)).getDataPersonlitas().getName());
            holder.price.setText(NumberFormat.getIntegerInstance(Locale.GERMAN).format(trasactionsData.get(temp.get(x)).getDetailMedical().getMadichine_price()*trasactionsData.get(temp.get(x)).getQuantity()));
            holder.quantity.setText(String.valueOf(trasactionsData.get(temp.get(x)).getQuantity()));
            holder.date.setText(String.valueOf(trasactionsData.get(temp.get(x)).getDateTransaction()));
            holder.nameMedichine.setText(String.valueOf(trasactionsData.get(temp.get(x)).getDetailMedical().getMedichine_name()));
        }
//        holder.update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Integer temp = Integer.valueOf(holder.customQuantityLayout.getEditText().getText().toString());
//                if(temp <= 0){
//                    Toast.makeText(ctx, "Must be Bigger than or equal 1", Toast.LENGTH_LONG).show();
//                } else if (temp >= 1) {
//                    Toast.makeText(ctx, "credensial fill the requiretment", Toast.LENGTH_LONG).show();
//                    trasactionsData.get(position).setQuantity(temp);
//                    notifyDataSetChanged();
//                    holder.customQuantityEditText.setText("");
//                }
//            }
//        });
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                trasactionsData.remove(position);
//                Toast.makeText(ctx, "removed item : Transaction -" + position, Toast.LENGTH_LONG).show();
//                notifyItemRemoved(position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for(int i = 0; i<trasactionsData.size(); i++){
            if(trasactionsData.get(i).getDataPersonlitas().getUserID().equalsIgnoreCase(account_dataTemp_arrayList.get(tempPosisi).getUserID())){
                count++;
            }
        }
        return count;
    }

    public adapterTrasaction(Context ctx, ArrayList<trasaction> trasactionsData) {
        this.trasactionsData = trasactionsData;
        this.ctx = ctx;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameMedichine, price, quantity, username, UserID, date;
        private Button update, delete;
        private TextInputLayout customQuantityLayout;
        private TextInputEditText customQuantityEditText;
        public ViewHolder(@NonNull View itemView, OnItemClickListener listener, OnItemClickListenerUpdate listenerUpdate) {
            super(itemView);
            date = itemView.findViewById(R.id.date_trasaction);
            UserID = itemView.findViewById(R.id.user_idCode);
            customQuantityLayout = itemView.findViewById(R.id.quantity_columnUpdateData);
            customQuantityEditText = itemView.findViewById(R.id.editTextQuantity);
            nameMedichine = itemView.findViewById(R.id.name_medichine);
            price = itemView.findViewById(R.id.price_medichinetrasactionTotal);
            quantity = itemView.findViewById(R.id.quantity_countNumber);
            username = itemView.findViewById(R.id.user_idName);
            update = itemView.findViewById(R.id.update_quantity);
            delete = itemView.findViewById(R.id.delete_quantity);
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenerUpdate.onItemClickUpdate(getAdapterPosition(), Integer.valueOf(customQuantityLayout.getEditText().getText().toString()));
                    customQuantityEditText.setText("");
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
        public Integer dataItem(){
            return Integer.valueOf(customQuantityLayout.getEditText().getText().toString());
        }
    }
}

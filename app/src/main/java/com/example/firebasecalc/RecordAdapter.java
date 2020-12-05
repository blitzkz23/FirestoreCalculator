package com.example.firebasecalc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class RecordAdapter extends FirestoreRecyclerAdapter<RecordModel, RecordAdapter.RecordHolder> {

    public RecordAdapter(@NonNull FirestoreRecyclerOptions<RecordModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecordHolder holder, int position, @NonNull RecordModel model) {
        holder.num1.setText(String.valueOf(model.getNum1()));
        holder.num2.setText(String.valueOf(model.getNum2()));
        holder.tandaHitung.setText(model.getTandaHitung());
        holder.result.setText(String.valueOf(model.getResult()));
    }

    @NonNull
    @Override
    public RecordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
        return new RecordHolder(view);
    }

    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class RecordHolder extends RecyclerView.ViewHolder{
        TextView num1;
        TextView num2;
        TextView tandaHitung;
        TextView result;

        public RecordHolder(@NonNull View itemView) {
            super(itemView);
            num1 = itemView.findViewById(R.id.num1);
            num2 = itemView.findViewById(R.id.num2);
            tandaHitung = itemView.findViewById(R.id.tandaHitung);
            result = itemView.findViewById(R.id.result);
        }
    }
}

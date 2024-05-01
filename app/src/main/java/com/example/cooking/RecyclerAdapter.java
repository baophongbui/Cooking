package com.example.cooking;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.FoodViewHolder> {

    private ArrayList<String> recipeNameList;
    private ArrayList<String>timeList;
    private ArrayList<Integer>imageList;
    private Context context;

    public RecyclerAdapter(ArrayList<String> recipeNameList, ArrayList<String> timeList, ArrayList<Integer> imageList, Context context) {
        this.recipeNameList = recipeNameList;
        this.timeList = timeList;
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.txtRecipe.setText(recipeNameList.get(position));
        holder.txtTime.setText(timeList.get(position));
        holder.imgRecipe.setImageResource(imageList.get(position));
        holder.btnXemNgay.setOnClickListener(v -> {
            if (position == 0){
                Intent intent = new Intent(context,Details.class);
                intent.putExtra("detail",R.string.crepe);
                intent.putExtra("image",R.drawable.toast3);
                intent.putExtra("info",recipeNameList.get(position).toString());
                context.startActivity(intent);
            } else if (position == 1){
                Intent intent = new Intent(context,Details.class);
                intent.putExtra("detail",R.string.burger);
                intent.putExtra("image",R.drawable.burger);
                intent.putExtra("info",recipeNameList.get(position).toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeNameList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private TextView txtRecipe,txtTime;
        private ImageView imgRecipe;
        private Button btnXemNgay;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            txtRecipe = itemView.findViewById(R.id.txtRecipe);
            txtTime = itemView.findViewById(R.id.txtTime);
            imgRecipe = itemView.findViewById(R.id.imgRecipe);
            btnXemNgay = itemView.findViewById(R.id.btnXemNgay);
        }
    }
}

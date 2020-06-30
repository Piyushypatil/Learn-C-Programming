package com.dypiet.app.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dypiet.app.LoadPDF;
import com.dypiet.app.Model.QuestionPaperPDF;
import com.dypiet.app.R;

public class PPaperAdapter extends RecyclerView.Adapter<PPaperAdapter.PaperViewHolder> {

    private final Context context;
    ArrayList<QuestionPaperPDF> mPaperList;

    public PPaperAdapter(ArrayList<QuestionPaperPDF> mPaperList, Context context){
        this.mPaperList = mPaperList;
        this.context = context;
    }

    @NonNull
    @Override
    public PaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pitem_pdf,parent,false);
        PaperViewHolder viewHolder = new PaperViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PaperViewHolder holder, int position) {
        String name = mPaperList.get(position).name;
        String exam = mPaperList.get(position).exam;
        final String url = mPaperList.get(position).url;
        holder.setData(name, exam);
        Log.e("URL",url);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
                Toast.makeText(context.getApplicationContext(), " Wait...!", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPaperList.size();
    }

    public static class PaperViewHolder extends RecyclerView.ViewHolder {
        TextView examView;
        TextView nameView;
        CardView card;

        public PaperViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_exam);
            examView = itemView.findViewById(R.id.examview);
            nameView = itemView.findViewById(R.id.nameview);
        }

        public void setData(String name, String exam) {
            this.nameView.setText(name);
            this.examView.setText(exam);
        }

    }
}

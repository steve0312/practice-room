package com.example.graduationproject.result;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduationproject.R;
import com.example.graduationproject.UploadedSurveyDTO;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IndividualViewRV extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private ArrayList<IndividualViewDTO> datas;
    private int form_id;

    IndividualViewDTO data;

    public IndividualViewRV(Context context,ArrayList<IndividualViewDTO> datas,int form_id){
        this.mContext=context;
        this.datas=datas;
        this.form_id=form_id;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtIndex;
        TextView txtTime;

        public ViewHolder(View v){
            super(v);
            txtIndex=(TextView)v.findViewById(R.id.txtIndex);
            txtTime=(TextView)v.findViewById(R.id.txtTime);


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(mContext,IndividualResultActivity.class);
                    intent.putExtra("form_id",form_id);
                    intent.putExtra("result",datas.get(getAdapterPosition()));

//                    Log.v("뷰홀더테스트1", "datas.size : " + datas.size());
                    Log.v("뷰홀더테스트2", "getAdapterPosition() : " + getAdapterPosition());
                    Log.v("뷰홀더테스트3", "datas.get(getAdapterPosition()) : " + datas.get(getAdapterPosition()));
                    Log.v("뷰홀더테스트4", "datas.get(0) : " + datas.get(0));
                    Log.v("뷰홀더테스트5", "datas.get(1) : " + datas.get(1));



                    mContext.startActivity(intent);
                    Toast.makeText(mContext,"결과로 갑니다",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView= LayoutInflater.from(mContext).inflate(R.layout.activity_individualview_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(itemView);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        IndividualViewDTO vo=datas.get(position);

        Log.v("뷰홀더테스트6", "datas.get(position) : " + datas.get(position));


        ((ViewHolder)holder).txtIndex.setText(String.valueOf(vo.getIndex()));
        ((ViewHolder)holder).txtTime.setText(vo.getTime());

    }
    @Override
    public int getItemCount() {
        return datas.size();
    }
}

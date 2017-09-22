package com.infotech.getbase;

/**
 * Created by sk_mbuguah on 9/21/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by csa on 3/6/2017.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyHolder>{

    List<ListData> listdata;

    public RecyclerviewAdapter(List<ListData> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {
        ListData data = listdata.get(position);
        holder.vname.setText(data.getName());
        holder.vjob.setText(data.getJob());
        holder.vgender.setText(data.getGender());
        holder.vemail.setText(data.getEmail());
        holder.vcity.setText(data.getCity());
        holder.vcountry.setText(data.getCountry());

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView vname,vjob,vgender,vemail,vcity,vcountry;

        public MyHolder(View itemView) {
            super(itemView);
            vname = (TextView) itemView.findViewById(R.id.vname);
            vjob = (TextView) itemView.findViewById(R.id.vjob);
            vgender = (TextView) itemView.findViewById(R.id.vgender);
            vemail = (TextView) itemView.findViewById(R.id.vemail);
            vcity = (TextView) itemView.findViewById(R.id.vcity);
            vcountry = (TextView) itemView.findViewById(R.id.vcountry);

        }
    }


}
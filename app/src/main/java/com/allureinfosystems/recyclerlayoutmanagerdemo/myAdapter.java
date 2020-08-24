package com.allureinfosystems.recyclerlayoutmanagerdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class myAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Object> hmap;
    Context context;
    private final int USER = 0, IMAGE = 1;
    public myAdapter(Context context,ArrayList<Object> hmap)
    {
        this.hmap = hmap;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (hmap.get(position) instanceof TextData) {
            return USER;
        } else if (hmap.get(position) instanceof Imagedata) {
            return IMAGE;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case USER:
                View v1 = inflater.inflate(R.layout.rowdata_layout, parent, false);
                viewHolder = new MyadapterData(v1);
                break;
            case IMAGE:
                View v2 = inflater.inflate(R.layout.adlayout, parent, false);
                viewHolder = new AdvertisementHolder(v2);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case USER:
                MyadapterData vh1 = (MyadapterData) holder;
               ((MyadapterData) holder).name.setText(((TextData) hmap.get(position)).getText());
               ((MyadapterData) holder).image.setText(((TextData) hmap.get(position)).getImagedata());
                break;
            case IMAGE:
                AdvertisementHolder ad = (AdvertisementHolder)holder;
                ((AdvertisementHolder) holder).imageAdv.setImageResource(((Imagedata) hmap.get(position)).getText());
                break;

        }

    }



    @Override
    public int getItemCount() {
        return hmap.size();
    }
 class MyadapterData extends  RecyclerView.ViewHolder{

      private TextView name;
      private TextView image;

     public MyadapterData(@NonNull View itemView) {
         super(itemView);
         name = itemView.findViewById(R.id.name);
         image = itemView.findViewById(R.id.num);

     }
 }

    class AdvertisementHolder extends RecyclerView.ViewHolder{

        public ImageView imageAdv;

        public AdvertisementHolder(View view){
            super(view);
            imageAdv = (ImageView)view.findViewById(R.id.adtext);
        }
    }

}

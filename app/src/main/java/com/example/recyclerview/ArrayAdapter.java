package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ViewHolder> {

    private static final String TAG = "test.sliit.recyclerview.RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();
    private Context mContext;

    public ArrayAdapter(ArrayList<String> mImageNames, ArrayList<String> mImage, Context mContext) {
        this.mImageNames = mImageNames;
        this.mImage = mImage;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return (viewHolder);

    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBIndViewHolder: Cancelled");
        Glide.with(mContext).asBitmap().load(mImage.get(position)).into(holder.image);

        holder.imageName.setText(mImageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: clicked on" +mImageNames.get(position));
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

                View imageView =  LayoutInflater.from(mContext).inflate(R.layout.image_view,null,false);

                builder.setView(imageView);
                ImageView imageView1 = imageView.findViewById(R.id.view_image);

                Glide.with(mContext).asBitmap().load(mImage.get(position)).into(imageView1);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                Toast.makeText(mContext,mImageNames.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.imageText);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}

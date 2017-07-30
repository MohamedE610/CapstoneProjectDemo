package com.example.e610.capstoneproject.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.e610.capstoneproject.R;
import com.example.e610.capstoneproject.Models.Example;
import com.squareup.picasso.Picasso;



public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder>  {
    Example example;
    Context context;
    int  LastPosition=-1;
    RecyclerViewClickListener ClickListener ;
    public RecipeAdapter(){}
    public RecipeAdapter(Example example, Context context){
        this.example=new Example();
        this.example=example;
        this.context=context;
    }

    public void setClickListener(RecyclerViewClickListener clickListener){
       this.ClickListener= clickListener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_article,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(example.data.get(position).attributes.titles.en);
        String str=example.data.get(position).attributes.posterImage.original;

            Picasso.with(context).load(str).placeholder(R.drawable.asd)
                    .error(R.drawable.asd).into(holder.imageView);

        setAnimation(holder.cardView,position);

    }

    @Override
    public int getItemCount() {
        return example.data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView=(TextView)itemView.findViewById(R.id.text);
            imageView=(ImageView) itemView.findViewById(R.id.img);
            cardView=(CardView) itemView.findViewById(R.id.card);
        }

        @Override
        public void onClick(View view) {
            if(ClickListener!=null)
            ClickListener.ItemClicked(view ,getAdapterPosition());
        }

        public void clearAnimation()
        {
            cardView.clearAnimation();
        }
    }

    public interface RecyclerViewClickListener
    {

        public void ItemClicked(View v, int position);
    }

    private void setAnimation(View viewToAnimate, int position)
    {

        if (position > LastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            LastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
             holder.clearAnimation();
    }



}


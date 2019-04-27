package com.botimounir.horizontal_listview.HorizListView;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.botimounir.horizontal_listview.R;

import java.util.List;
import java.util.Random;

public class HorizListAdapter extends RecyclerView.Adapter<HorizListAdapter.HorizListHolder> {

    private OnHorizListListener onHorizListListener;

    public void setOnHorizListListener(OnHorizListListener listener) {
        onHorizListListener = listener;
    }



    private List<String> _data;
    private Context _context;

    private int lastPosition = -1;

    HorizListAdapter(List<String> data, Context context) {
        _data =data;
        _context=context;
    }

    @NonNull
    @Override
    public HorizListHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        final HorizListHolder horizListHolder = new HorizListHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = String.valueOf((horizListHolder._name).getText());
                int position = horizListHolder.getAdapterPosition();
                onHorizListListener.onElementSelected(position, value);
            }
        });
        return horizListHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull HorizListHolder viewHolder, int i) {
        String data= _data.get(i);
        viewHolder._name.setText(data);

        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        viewHolder._ll_parent.setBackgroundColor(color);
        setAnimation(viewHolder._ll_parent, i);
    }


    private void setAnimation(View viewToAnimate, int position) {
        //if the view is not display => she's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(_context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


    @Override
    public int getItemCount() {
        return _data.size();
    }

    class HorizListHolder extends RecyclerView.ViewHolder {

        TextView _name;
        LinearLayout _ll_parent;

        HorizListHolder(View itemView) {
            super(itemView);
            _ll_parent = itemView.findViewById(R.id.ll_row_parent);
            _name = itemView.findViewById(R.id.tv_name);
        }
    }
}

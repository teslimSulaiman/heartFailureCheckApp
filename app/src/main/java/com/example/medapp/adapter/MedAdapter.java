package com.example.medapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.medapp.R;
import com.example.medapp.model.User;

import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MedAdapter extends RecyclerView.Adapter<MedAdapter.viewHolder> {
    private List<User> users;
    private Context context;

    public MedAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        /*@Nullable
        @BindView(R.id.txtId)
        TextView id;

        @BindView(R.id.txtName)
        TextView name;

        @BindView(R.id.txtScore)
        TextView score;*/
        public TextView id;
        public TextView name;
        public TextView score;

        public viewHolder(View view) {
            super(view);
            //ButterKnife.bind(this, view);
            id = (TextView) itemView.findViewById(R.id.txtId);
            name = (TextView) itemView.findViewById(R.id.txtName);
            score = (TextView) itemView.findViewById(R.id.txtScore);
        }
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View displayView = inflater.inflate(R.layout.record_item_card, parent, false);
        return new viewHolder(displayView);
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, final int position) {
        User singleUser = users.get(position);
        holder.id.setText(String.valueOf(singleUser.getId()));
        holder.name.setText(singleUser.getName());
        int totalScore = singleUser.getTotalScore();

        holder.score.setText("100% heart failure probability");
        if(totalScore == 0) {
            holder.score.setText("16.7% heart failure probability");
        }
        if(totalScore == 1) {
            holder.score.setText("33.8% heart failure probability");
        }
        if(totalScore == 2) {
            holder.score.setText("59.1% heart failure probability");
        }
        if(totalScore == 3) {
            holder.score.setText("73.8% heart failure probability");
        }
        if(totalScore == 4) {
            holder.score.setText("95.4% heart failure probability");
        }

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return users.size();
    }
}

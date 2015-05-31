package com.pratamawijaya.pratamawijayacommvp.views.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pratamawijaya.pratamawijayacommvp.R;
import com.pratamawijaya.pratamawijayacommvp.models.Post;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by pratama on 5/31/15.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeAdapterHolder> {

    private Context context;
    private List<Post> posts;

    public HomeAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public HomeAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new HomeAdapterHolder(v);
    }

    @Override
    public void onBindViewHolder(HomeAdapterHolder holder, int position) {
        holder.title.setText("" + posts.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class HomeAdapterHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.txtTitle)
        TextView title;

        public HomeAdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}

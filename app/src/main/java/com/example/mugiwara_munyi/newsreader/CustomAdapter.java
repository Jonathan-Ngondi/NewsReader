package com.example.mugiwara_munyi.newsreader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**Custom Adapter for the RecyclerView.
 *
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    List<NewsItem> mList;
    Context mContext;

  /**Constructor for the Custom Adapter.
   *
   * @param mList takes in a List of News Items.
   * @param mContext also requires the application Context for Glide.
   */

  public CustomAdapter(List<NewsItem> mList, Context mContext) {
        this.mContext = mContext;
        this.mList = mList;
    }

  /**ViewHolder for the CustomAdapter implements OnClickListener.
   *
   */

  public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title;

    /**Constructor for the ViewHolder.
     * @param itemView takes in a View to hold and binds both the image and title to it.
     */

    public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            image = itemView.findViewById(R.id.newsImage);
            title = itemView.findViewById(R.id.newsTitle);



        }

        @Override
        public void onClick(View v) {
          //This method is empty for now.
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.news_item_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

        holder.title.setText(mList.get(position).getTitle());
        String imageURL = mList.get(position).getUrlToImage();
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);
        Glide.with(mContext).load(imageURL).apply(options).into(holder.image);



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

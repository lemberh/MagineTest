package test.roman.maginetest.movies_list.adapters;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import test.roman.maginetest.R;
import test.roman.maginetest.movies_list.models.Video;
import test.roman.maginetest.rest_api.RestApi;
import test.roman.maginetest.video_player.VideoPlayerAct;

/**
 * Created by Roman on 2016-10-22.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Video> videos = new ArrayList<>();
    private Handler handler;

    public MoviesAdapter(){
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.update(videos.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), VideoPlayerAct.class);
                i.putExtra(VideoPlayerAct.VIDEO_URL,videos.get(holder.getAdapterPosition()).getSources().get(0));
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
        handler.post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView studio;
        private TextView title;
        private ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            studio = (TextView) itemView.findViewById(R.id.studio);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.image);
        }

        void update(Video model){
            title.setText(model.getTitle());
            studio.setText(model.getStudio());
            Picasso.with(image.getContext()).
                    load(String.format(RestApi.MOVIE_IMAGE_URL,model.getImage480x270())).
                    placeholder(R.drawable.placeholder).
                    into(image);
        }
    }
}

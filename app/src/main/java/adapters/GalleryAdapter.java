package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.galleryapp.galleryapp.R;

import java.util.List;

import Utils.utilities;
import database.ImageModel;

/**
 * Created by haseeb on 10/5/17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {
    public int VIEW_ITEM = 0;
    public int VIEW_LOAD = 1;
    int HolderId = 0;

    private List<ImageModel> data;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView grid;

        public MyViewHolder(View view, int ViewType) {
            super(view);
            if (ViewType == VIEW_ITEM) {
                HolderId = 0;
                grid = (ImageView) view.findViewById(R.id.grid);

            } else if (ViewType == VIEW_LOAD){
                HolderId = 1;
            }
        }
    }


    public GalleryAdapter(List<ImageModel> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public GalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_item, parent, false);
        int height = parent.getMeasuredWidth() / 4;
        itemView.setMinimumHeight(height);
        return new GalleryAdapter.MyViewHolder(itemView, viewType);

    }

    @Override
    public void onBindViewHolder(GalleryAdapter.MyViewHolder holder, final int position) {
        ImageModel item = data.get(position);
        if (HolderId == VIEW_ITEM) {
            holder.grid.setImageBitmap(utilities.getImage(item.getImage()));
        }
        else {

        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (data.get(position) != null) {
            return VIEW_ITEM;
        } else {
            return VIEW_LOAD;
        }
    }
}

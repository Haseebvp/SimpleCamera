package fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galleryapp.galleryapp.R;

import java.util.List;

import adapters.GalleryAdapter;
import database.ImageModel;
import database.ImageRepo;

/**
 * Created by haseeb on 10/5/17.
 */

public class GridFragment extends Fragment {

    RecyclerView recyclerView;
    TextView empty;
    GalleryAdapter adapter;


    public static GridFragment newInstance(){
        return new GridFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_grid, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        empty = (TextView) view.findViewById(R.id.emptymessage);
        GetData();
        return view;
    }

    private void GetData() {
        ImageRepo imageRepo = new ImageRepo();
        List<ImageModel> data = imageRepo.getData();
        System.out.println("JJJJ : "+data.size());
        if (data.size() == 0){
            empty.setVisibility(View.VISIBLE);
        }
        else {

            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 4, GridLayoutManager.VERTICAL, false);
            adapter = new GalleryAdapter(data, getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
        }
    }


}

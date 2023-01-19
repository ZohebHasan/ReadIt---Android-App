package com.example.readit;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment {

    String apiKey = "14743ceffafd4a93a409776a41a9379f";
    ArrayList<ModelClass> modelClassList;
    Adapter adapter;
    String country = "us";
    private String category = "science";

    private RecyclerView recyclerViewOfScience;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view  = inflater.inflate(R.layout.sciencefragment, null);

        recyclerViewOfScience = view.findViewById(R.id.recyclerViewOfScience);
        modelClassList = new ArrayList<>();
        recyclerViewOfScience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassList);
        recyclerViewOfScience.setAdapter(adapter);

        findNews();


        return view;

    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country, category, 100, apiKey).enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                if(response.isSuccessful()) {
                    assert response.body() != null;
                    modelClassList.addAll(response.body().getNewsList());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {

            }
        });
    }
}

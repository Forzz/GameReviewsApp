package com.example.gamereviewsapp.Presentation.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gamereviewsapp.Domain.Model.Game;
import com.example.gamereviewsapp.Presentation.View.Adapters.GamesListAdapter;
import com.example.gamereviewsapp.Presentation.ViewModel.GamesListViewModel;
import com.example.gamereviewsapp.R;
import com.example.gamereviewsapp.databinding.FragmentGamesListBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class GamesListFragment extends Fragment {

    private GamesListViewModel gamesListVM;
    private FragmentGamesListBinding binding;

    public GamesListFragment() {
    }

    public static GamesListFragment newInstance() {
        return new GamesListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGamesListBinding.inflate(getLayoutInflater(), container, false);
        binding.gamesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gamesListVM = new ViewModelProvider(this).get(GamesListViewModel.class);
        gamesListVM.getGamesList().observe(getViewLifecycleOwner(), (List<Game> gamesList) ->
                binding.gamesRecycler.setAdapter(new GamesListAdapter(gamesList)));
    }
}
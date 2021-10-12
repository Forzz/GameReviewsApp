package com.example.gamereviewsapp.Presentation.View.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamereviewsapp.Domain.Model.Game;
import com.example.gamereviewsapp.R;
import com.example.gamereviewsapp.databinding.GameItemBinding;

import java.util.List;

public class GamesListAdapter extends RecyclerView.Adapter<GamesListAdapter.GameViewHolder> {

    private List<Game> games;

    public GamesListAdapter(List<Game> games) {
        this.games = games;
    }

    @NonNull
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GameItemBinding binding = GameItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new GameViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        holder.binding.gameItemTitle.setText(games.get(position).getTitle());
        holder.binding.gameItemDescription.setText(games.get(position).getDescription());
        holder.binding.criticsScore.setText(games.get(position).getCriticsScore() + " / 100");
        holder.binding.usersScore.setText(games.get(position).getUsersScore() + " / 10");

        holder.binding.gameItemAddReviewButton.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("gameText", holder.binding.gameItemTitle.getText().toString());
            Navigation.findNavController(view).navigate(R.id.addReviewFragment, bundle);
        });
    }

    public int getItemCount() {
        return games.size();
    }

    public List<Game> getData() {
        return games;
    }

    class GameViewHolder extends RecyclerView.ViewHolder {

        GameItemBinding binding;

        public GameViewHolder(GameItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}

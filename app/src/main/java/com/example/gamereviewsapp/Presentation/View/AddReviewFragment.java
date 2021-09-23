package com.example.gamereviewsapp.Presentation.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gamereviewsapp.Presentation.ViewModel.AddReviewViewModel;
import com.example.gamereviewsapp.R;
import com.example.gamereviewsapp.databinding.FragmentAddReviewBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AddReviewFragment extends Fragment {

    private AddReviewViewModel addReviewVM;
    private FragmentAddReviewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String gameTitle = getArguments().getString("gameText");

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.GONE);

        binding = FragmentAddReviewBinding.inflate(getLayoutInflater(), container, false);

        binding.buttonApply.setOnClickListener((View view) -> {
                if (!binding.editTextReview.getText().toString().isEmpty() && !binding.editTextScore.getText().toString().isEmpty()) {
                    addReviewVM.addReview(gameTitle, binding.editTextReview.getText().toString(), Integer.parseInt(binding.editTextScore.getText().toString()));
                    getParentFragmentManager().popBackStack();
                } else {
                    Toast.makeText(getContext(), "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addReviewVM = new ViewModelProvider(this).get(AddReviewViewModel.class);
    }

    @Override
    public void onDestroy() {
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.VISIBLE);

        super.onDestroy();

        addReviewVM = null;
        binding = null;
    }
}
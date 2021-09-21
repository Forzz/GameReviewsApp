package com.example.gamereviewsapp.Presentation.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.GONE);

        binding = FragmentAddReviewBinding.inflate(getLayoutInflater(), container, false);

        binding.buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextReview.getText().toString().isEmpty() && !binding.editTextNumberScore.getText().toString().isEmpty()) {
                    addReviewVM.addReview("123", binding.editTextReview.getText().toString(), Integer.parseInt(binding.editTextNumberScore.getText().toString()));
                    Navigation.findNavController(view).popBackStack();
                } else {
                    Toast.makeText(getContext(), "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.VISIBLE);

        super.onDestroy();
    }
}
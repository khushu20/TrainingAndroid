package com.example.newapplication.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import com.example.newapplication.R;
import com.example.newapplication.databinding.FragmentHomeBinding;

public class DashboardFragment extends Fragment {

private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.textHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Navigation to nextfragment
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_nav_home_to_nextFragment);

            }
        });

    View root = binding.getRoot();


        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
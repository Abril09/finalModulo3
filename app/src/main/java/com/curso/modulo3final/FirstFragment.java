package com.curso.modulo3final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.curso.modulo3final.databinding.FragmentFirstBinding;
import com.curso.modulo3final.model.Apartment;
import com.curso.modulo3final.util.ApartamentData;
import com.curso.modulo3final.util.ApartmentAdapter;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class FirstFragment extends Fragment implements ApartmentAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private ApartmentAdapter adapter;
    private FragmentFirstBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = Objects.requireNonNull(binding.myRecyclerView);

        adapter = new ApartmentAdapter(ApartamentData.apartmentList(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

     /*   view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/
    }

    @Override
    public void onClick(ApartmentAdapter.ApartmentHolder viewHolder, Optional<Apartment> apartment) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("apartment",apartment.get());
        NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);
    }
}
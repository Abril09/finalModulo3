package com.curso.modulo3final.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.curso.modulo3final.R;
import com.curso.modulo3final.model.Apartment;

import java.util.List;
import java.util.Optional;

public class ApartmentAdapter extends RecyclerView.Adapter<ApartmentAdapter.ApartmentHolder>  {
    private  List<Apartment> apartmentList;
    private  OnItemClickListener listener;

    public ApartmentAdapter(List<Apartment> apartments, OnItemClickListener listener) {
      this.apartmentList = apartments;
      this.listener = listener;
    }

    @Override
    public ApartmentAdapter.ApartmentHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_apartment, parent, false);
        return new ApartmentHolder(view);
    }

    @Override
    public void onBindViewHolder(ApartmentHolder holder, int position) {
        Apartment apartment = this.apartmentList.get(position);
        holder.buildingName.setText(apartment.getBuildingName());
        holder.projectName.setText(apartment.getProjectName());
        holder.unitId.setText(apartment.getUnitId());
        holder.adress.setText(apartment.getAddress());
    }

    @Override
    public int getItemCount() {
        return this.apartmentList.size();
    }

    public class ApartmentHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView buildingName;
        private TextView projectName;
        private TextView unitId;
        private TextView adress;

        public ApartmentHolder(@NonNull View itemView ) {
            super(itemView);
            unitId = itemView.findViewById(R.id.tvUnitId);
            buildingName = itemView.findViewById(R.id.tvBuildingName);
            projectName = itemView.findViewById(R.id.tvProjectName);
            adress   = itemView.findViewById(R.id.tvAddress);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(this,getApartmentByPosition(getAdapterPosition()));
        }
    }

    public Optional<Apartment> getApartmentByPosition(int position){
        if (position != RecyclerView.NO_POSITION){
            return Optional.ofNullable(this.apartmentList.get(position));
        } else {
            return Optional.empty();
        }
    }

    public interface OnItemClickListener{
         void onClick(ApartmentAdapter.ApartmentHolder viewHolder, Optional<Apartment> apartment);
    }
}

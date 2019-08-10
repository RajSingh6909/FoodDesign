package com.example.fooddesign.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import retrofit2.Callback;

public class SectorAdapter {
//        extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder> {
//
//    private Context context;
//    private List<Sector_> sector_s= new ArrayList<Sector_>();
//    ArrayAdapter aasector;
//    String stringArrayList;
//    ArrayList<String> strings=new ArrayList<String>();
//    public SectorAdapter(Context context, List<Sector_> sector_s) {
//        this.context = context;
//        this.sector_s = sector_s;
//    }
//
//    @NonNull
//    @Override
//    public SectorAdapter.SectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//
//        return 0;
//
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull SectorAdapter.SectorViewHolder holder, int position) {
//        System.out.println("finallistspiner"+aasector);
//        strings.add("Select sector");
//           for (int j = 0; j < sector_s.size(); j++)
//               strings.add(sector_s.get(j).getName());
//            ArrayAdapter aasector = new ArrayAdapter(context, android.R.layout.simple_spinner_item, strings);
//            aasector.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            holder.spinnersectorname.setAdapter(aasector);
//    }
//
//    @Override
//    public int getItemCount() {
//        return 1;
//    }
//
//    public class SectorViewHolder extends RecyclerView.ViewHolder {
//        Spinner spinnersectorname;
//
//        public SectorViewHolder(@NonNull View itemView) {
//
//            super(itemView);
//            spinnersectorname=itemView.findViewById(R.id.spinnersectorname);
//        }
//    }
}

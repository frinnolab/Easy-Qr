package com.example.easyqrscanner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dummyModels.DataAPI;
import dummyModels.DataModel;

public class ScannedFragment extends Fragment {
    private ListAdapter mListadapter;
    View rootView;
    RecyclerView.LayoutManager manager;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_scanned,container,false);

        recyclerView = rootView.findViewById(R.id.rv_scanned);


        manager = new LinearLayoutManager(getActivity());
        ((LinearLayoutManager) manager).setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(manager);
        ArrayList data = new ArrayList<DataAPI>();

        for (int i = 0; i < DataAPI.names.length;i++){
            data.add(new DataModel(
                    DataAPI.names[i],
                    DataAPI.address[i],
                    DataAPI.codeNo_[i]
            ));
        }
        mListadapter = new ListAdapter(data);
        recyclerView.setAdapter(mListadapter);
        return rootView;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

        private ArrayList<DataModel> dataList;

        public ListAdapter(ArrayList<DataModel> data)
        {
            this.dataList = data;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scanned_card, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.mName.setText(dataList.get(position).getName());
            holder.mAddress.setText(dataList.get(position).getAddress());
            holder.mCode.setText(dataList.get(position).getCode());

            //Recycler Item Click
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView mName, mAddress, mCode;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                mName = itemView.findViewById(R.id.nameTxtView);
                mAddress = itemView.findViewById(R.id.addressTxtView);
                mCode = itemView.findViewById(R.id.codeTxtView);
            }
        }
    }
}

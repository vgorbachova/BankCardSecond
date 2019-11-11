package com.example.bankcard;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    interface IMainFragment{
        void inItemClick(int position);
    }

    public static MainFragment newInstance () {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public MainFragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    Button bt;
    IMainFragment listener;

    MainFragment setListener(IMainFragment listener){
        this.listener = listener;
        return this;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = view.findViewById(R.id.view);
        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        bt = view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddCardActivity.class);
                startActivity (intent);
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        int itemPosition = (int) view.getTag();
        if (null != listener) {
            listener.inItemClick(itemPosition);
        }
    }

    public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder> {
        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView text1;
            TextView text2;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                text1 = itemView.findViewById(android.R.id.text1);
                text2 = itemView.findViewById(android.R.id.text2);
            }
            public void bind(BankCard data, int position) {
                text2.setText(data.getNum());
                text1.setText(data.getOwnerName());
                itemView.setTag(position);
                itemView.setOnClickListener(MainFragment.this);

            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
            return new MyAdapter.ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bind(BankCardManager.getCard(position), position);

        }

        @Override
        public int getItemCount() {

            return BankCardManager.getCardsCount();
        }
    }

}

package com.tomasforsman.qwizly.adapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.tomasforsman.qwizly.R;
import com.tomasforsman.qwizly.ui.QwizlyFragment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public String[][] mDataset;
    public String[][] mData;
    public Context context;
    public Boolean[] ansF;




    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView mTextView;
        public RadioButton mFalse;
        public RadioButton mTrue;
        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.name);
            mFalse = (RadioButton) v.findViewById(R.id.rbNo);
            mTrue = (RadioButton) v.findViewById(R.id.rbYes);



        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)

    private static String[][]  readSavedHiddenFormulas(Context context) {
        String[][]  savedArrayList = null;
        try {
            FileInputStream inputStream = context.openFileInput("HiddenFormulas.txt");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            savedArrayList = (String[][] ) in.readObject();
            in.close();
            inputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return savedArrayList;
    }


    public void saveHiddenFormulas(Context context, String[][] hiddenFormulas) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("HiddenFormulas.txt", Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(hiddenFormulas);
            out.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyAdapter(String[][] myDataset, Boolean[] be) {

            ansF = be;
            mDataset = myDataset;




    }

    public boolean ansTrue;
    public boolean ansFalse;



    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Boolean[] F = ansF;
        String t = mDataset[0][position]; //+" : "+mDataset[1][position]+" : "+mDataset[2][position];
        holder.mTextView.setText(t);
        final int pos = position;
        holder.mFalse.setChecked(F[pos]);
        holder.mFalse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                F[pos] = true;
            }
        });

/*
        if (!ansFalse) {
            holder.mFalse.setChecked(false);
        }else if(ansFalse) {
            holder.mFalse.setChecked(true);
        }
        if (!ansTrue) {
            holder.mTrue.setChecked(false);
        }else if(ansTrue) {
            holder.mTrue.setChecked(true);
        }

        holder.mFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ansFalse ^= true;
            }
        });

        holder.mTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataset[3][position] = "true";

            }
        });
*/
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = mDataset[0][position];
                Log.d("CardView", "CardView Clicked: " + currentValue);
            }

        });
    }

    @Override
    public int getItemCount() {
        return mDataset[0].length;
    }

}
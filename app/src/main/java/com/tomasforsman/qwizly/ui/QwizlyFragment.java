package com.tomasforsman.qwizly.ui;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tomasforsman.qwizly.R;
import com.tomasforsman.qwizly.adapter.MyAdapter;

public class QwizlyFragment extends Fragment {

    public QwizlyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_qwizly, container, false);


        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        rv.setItemViewCacheSize(8);
        MyAdapter adapter = new MyAdapter(new String[][]
               { {
                   "USA have had a president named Chester Arthur",
                       "Sweden is famous for their chocolate",
                       "The Christian cross is the most recognised symbol in the world",
                       "The largest ant colony in the world is more than 10 km from side to side",
                       "USA have had a president named Chester Arthur",
                       "Sweden is famous for their chocolate",
                       "The Christian cross is the most recognised symbol in the world",
                       "The largest ant colony in the world is more than 10 km from side to side",},
                {
                    "yes",
                        "no",
                        "no",
                        "yes",
                        "yes",
                        "no",
                        "no",
                        "yes",
                },
                {
                    "He became president in 1881 when James Garfield was murdered.",
                        "It's actually Switzerland who has the chocolate. Sweden is a norse country famous for Abba, Vikings and Ikea.",
                        "More people recognise the McDonalds symbol than the Christian cross.",
                        "In 2000 a new supercolony was found spanning 6000km along the Mediterranean and Atlantic coasts in Southern Europe.",
                        "He became president in 1881 when James Garfield was murdered.",
                        "It's actually Switzerland who has the chocolate. Sweden is a norse country famous for Abba, Vikings and Ikea.",
                        "More people recognise the McDonalds symbol than the Christian cross.",
                        "In 2000 a new supercolony was found spanning 6000km along the Mediterranean and Atlantic coasts in Southern Europe."
               },
                       {
                           "true",
                           "false",
                           "false",
                           "false",
                               "false",
                               "false",
                               "true",
                               "false",

                       },
                       {
                           "false",
                           "false",
                           "true",
                           "false",
                               "false",
                               "false",
                               "false",
                               "false",

                       },


               }, new Boolean[]{false,false,false,false,false,false,false,false});




        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}
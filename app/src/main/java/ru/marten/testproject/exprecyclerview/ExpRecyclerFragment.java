package ru.marten.testproject.exprecyclerview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ca.barrenechea.widget.recyclerview.decoration.DividerDecoration;
import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderDecoration;
import ru.marten.testproject.R;
import ru.marten.testproject.exprecyclerview.data.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpRecyclerFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private StickyHeaderDecoration decor;


    public ExpRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exp_resycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_test);
        adapter = new RecyclerAdapter(getContext());

//        DividerDecoration divider = new DividerDecoration(getContext());

//        recyclerView.addItemDecoration(divider);

        adapter.setPersonArrayList(Person.getTestPersonList());
        adapter.setHeaders(Person.getHeaders());
        decor = new StickyHeaderDecoration(adapter);
        recyclerView.addItemDecoration(decor);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

}

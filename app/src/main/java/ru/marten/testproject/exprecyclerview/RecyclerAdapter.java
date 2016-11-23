package ru.marten.testproject.exprecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderAdapter;
import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderDecoration;
import ru.marten.testproject.R;
import ru.marten.testproject.exprecyclerview.data.Person;

/**
 * Created by marten on 15.09.16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ChildViewHolder> implements StickyHeaderAdapter<RecyclerAdapter.HeaderHolder> {

    private ArrayList<Person> personArrayList = new ArrayList<>();
    private ArrayList<String> headersList = new ArrayList<>();
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_person, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChildViewHolder holder, int position) {
        Person item = personArrayList.get(position);
        holder.name.setText(item.getName());
        holder.weight.setText(String.valueOf(item.getWeight()));
        if (item.getSex())
            holder.sex.setText("male");
        else
            holder.sex.setText("female");
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }


    // header adapter

    @Override
    public long getHeaderId(int position) {

        return (long) position / headersList.size();
    }

    public void setHeaders(ArrayList<String> headersList) {
        this.headersList = headersList;
    }

    @Override
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_header, parent);
        return new HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {
        String header = headersList.get(position);
        viewholder.header.setText(header);
    }

    static class ChildViewHolder extends RecyclerView.ViewHolder {

        private TextView name, weight, sex;

        public ChildViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.person_name);
            weight = (TextView) itemView.findViewById(R.id.person_weight);
            sex = (TextView) itemView.findViewById(R.id.person_sex);
        }
    }

    static class HeaderHolder extends RecyclerView.ViewHolder {

        private TextView header;

        public HeaderHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.tv_recycler_header);
        }
    }


}

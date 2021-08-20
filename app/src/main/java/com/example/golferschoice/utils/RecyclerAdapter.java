package com.example.golferschoice.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.golferschoice.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class RecyclerAdapter  extends ExpandableRecyclerViewAdapter<ViewHolder,CourseViewHolder> {
    private Activity activity;

    public RecyclerAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public CourseViewHolder onCreateChildViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.child_view_holder, parent, false);

        return new CourseViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(CourseViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Course course = ((CourseInfo) group).getItems().get(childIndex);
        holder.onBind(course,group);
    }

    @Override
    public void onBindGroupViewHolder(ViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);
    }
}

package com.example.golferschoice.utils;

import android.view.View;
import android.widget.TextView;

import com.example.golferschoice.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class CourseViewHolder  extends ChildViewHolder {
    private final TextView phoneName;

    public CourseViewHolder(View itemView) {
        super(itemView);

        phoneName = itemView.findViewById(R.id.phone_name);
    }

    public void onBind(Course phone, ExpandableGroup group) {
        phoneName.setText(phone.getName());
    }
}
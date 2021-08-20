package com.example.golferschoice.utils;



import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class CourseInfo  extends ExpandableGroup<Course> {

    public CourseInfo(String title, List<Course> items) {
        super(title, items);
    }
}

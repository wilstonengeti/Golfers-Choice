package com.example.golferschoice.utils;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.golferschoice.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;


public class ViewHolder extends GroupViewHolder {
    private final TextView cName;
    private final View view;

    public ViewHolder(View itemView) {
        super(itemView);

        cName = itemView.findViewById(R.id.course_os);
        view   = itemView.findViewById(R.id.view_header);
    }

    @Override
    public void expand() {
        view.setBackgroundResource(R.drawable.bg_item_white_half_bottom);
        cName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_btn_expand, 0); //down_arrow
        Log.i("Adapter", "expand");
    }

    @Override
    public void collapse() {
        cName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_btn_collapse, 0); //up_arrow
        Log.i("Adapter", "collapse");
    }

    public void setGroupName(ExpandableGroup group) {
        cName.setText(group.getTitle());
    }
}

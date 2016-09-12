package com.blossoming.maker.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blossoming.maker.Model.EventsInfo;
import com.blossoming.schoolradio.R;

import java.util.List;

/**
 * Created by Blossoming on 2016/9/12.
 */
public class EventsAdapter extends ArrayAdapter<EventsInfo> {
    private int resourceId;
    private Context mContext;
    public EventsAdapter(Context context, int resource, List<EventsInfo> objects) {
        super(context, resource, objects);
        resourceId=resource;
        mContext=context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        EventsInfo eventsInfo=getItem(position);
        ViewHolder holder;
        if(convertView!=null)
        {
            view=convertView;
            holder= (ViewHolder) view.getTag();
        }
        else
        {
            holder=new ViewHolder();
            view= LayoutInflater.from(mContext).inflate(resourceId,null);
            holder.iv_events= (ImageView) view.findViewById(R.id.iv_events_item);
            holder.tv_events= (TextView) view.findViewById(R.id.tv_events_item);
            view.setTag(holder);
        }
        holder.iv_events.setImageResource(eventsInfo.getEventImage());
        holder.tv_events.setText(eventsInfo.getEventInfo());
        return view;
    }
    class ViewHolder
    {
        public ImageView iv_events;
        public TextView tv_events;
    }
}

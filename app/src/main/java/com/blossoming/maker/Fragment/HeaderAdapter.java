package com.blossoming.maker.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.blossoming.maker.Model.ItemEvents;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blossoming on 2016/9/12.
 */
public class HeaderAdapter extends PagerAdapter {
    private Activity context;
    private List<ItemEvents> events;
    private List<SimpleDraweeView> images=new ArrayList<SimpleDraweeView>();
    public HeaderAdapter(Activity context, List<ItemEvents> events)
    {
        this.context=context;
        Fresco.initialize(context);
        if(events==null||events.size()==0)
        {
            this.events=new ArrayList<>();
        }
        else
        {
            this.events=events;
        }
        for(int i=0;i<events.size();i++)
        {
            SimpleDraweeView image=new SimpleDraweeView(context);
            Uri uri=Uri.parse(events.get(i).getImageUrl());
            image.setImageURI(uri);
            images.add(image);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(View) object;
    }

}

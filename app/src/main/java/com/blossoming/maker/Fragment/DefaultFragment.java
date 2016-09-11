package com.blossoming.maker.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.blossoming.schoolradio.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blossoming on 2016/9/9.
 */
public class DefaultFragment extends Fragment{
    private View pageOne;
    private View pageTwo;
    private View pageThree;
    private List<View> lists;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fg_default,container,false);
        return view;
    }
    private void initView()
    {
        LayoutInflater inflate = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        pageOne=inflate.inflate(R.layout.fg_page_one,null);
        pageTwo=inflate.inflate(R.layout.fg_page_two,null);
        pageThree=inflate.inflate(R.layout.fg_page_three,null);
        lists=new ArrayList<View>();
        lists.add(pageOne);
        lists.add(pageTwo);
        lists.add(pageThree);
        new PagerAdapter() {
            @Override
            public int getCount() {
                return lists.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return false;
            }    @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(lists.get(position));

            }

            @Override
            public int getItemPosition(Object object) {

                return super.getItemPosition(object);
            }

            @Override
            public CharSequence getPageTitle(int position) {

                return (CharSequence) lists.get(position);//直接用适配器来完成标题的显示，所以从上面可以看到，我们没有使用PagerTitleStrip。当然你可以使用。

            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(lists.get(position));
                weibo_button=(Button) findViewById(R.id.button1);//这个需要注意，我们是在重写adapter里面实例化button组件的，如果你在onCreate()方法里这样做会报错的。
                weibo_button.setOnClickListener(new OnClickListener() {

                    public void onClick(View v) {
                        intent=new Intent(ViewPagerDemo.this,WeiBoActivity.class);
                        startActivity(intent);
                    }
                });
                return viewList.get(position);
            }
        };
    }
}

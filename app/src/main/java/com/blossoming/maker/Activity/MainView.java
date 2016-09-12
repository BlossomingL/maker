package com.blossoming.maker.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.blossoming.maker.Fragment.DefaultFragment;
import com.blossoming.maker.Fragment.FourthFragment;
import com.blossoming.maker.Fragment.SecondFragment;
import com.blossoming.maker.Fragment.ThirdFragment;
import com.blossoming.schoolradio.R;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MainView extends Activity {
    private ImageView iv_userimage;
    private TextView tv_username;
    private ImageView iv_extendsFunc;
    private Button btn_defaultfg;
    private Button btn_secondfg;
    private Button btn_thirdfg;
    private Button btn_fourthfg;
    private Fragment defaultFg;
    private ListView lv_mytoast;

    private void init()
    {
        iv_userimage= (ImageView) findViewById(R.id.iv_user_image);
        tv_username= (TextView) findViewById(R.id.tv_username);
        iv_extendsFunc= (ImageView) findViewById(R.id.iv_muchfunc);
        btn_defaultfg= (Button) findViewById(R.id.btn_default);
        btn_secondfg= (Button) findViewById(R.id.btn_second);
        btn_thirdfg= (Button) findViewById(R.id.btn_third);
        btn_fourthfg= (Button) findViewById(R.id.btn_fourth);
        iv_extendsFunc= (ImageView) findViewById(R.id.iv_muchfunc);

        defaultFg=new DefaultFragment();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fg_default,defaultFg);
        transaction.commit();

    }
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main_view);
        init();
        btn_secondfg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFg=new SecondFragment();
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.fg_default,secondFg);
                transaction.commit();
            }
        });
        btn_defaultfg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.fg_default,defaultFg);
                transaction.commit();
            }
        });
        btn_thirdfg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdFragment thirdFg=new ThirdFragment();
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.fg_default,thirdFg);
                transaction.commit();
            }
        });
        btn_fourthfg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FourthFragment fourthFg=new FourthFragment();
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.fg_default,fourthFg);
                transaction.commit();
            }
        });
        iv_extendsFunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showToast();



            }
        });
    }
    //点击右上角的图片之后显示
        public void showToast()
        {
            WindowManager.LayoutParams params=new WindowManager.LayoutParams();
            WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
            params.height= WindowManager.LayoutParams.WRAP_CONTENT;
            params.width= WindowManager.LayoutParams.WRAP_CONTENT;
            params.format = PixelFormat.TRANSLUCENT;
            params.type = WindowManager.LayoutParams.TYPE_PRIORITY_PHONE;
            params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
            View view = View.inflate(this, R.layout.mytoast_view, null);
            String data[]={"haah","hehe","xixi"};
            lv_mytoast= (ListView) view.findViewById(R.id.lv_mytoast);
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainView.this,android.R.layout.simple_list_item_1,data);
            lv_mytoast.setAdapter(adapter);
            wm.addView(view,params);
        }


}

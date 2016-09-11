package com.blossoming.maker.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blossoming.maker.Fragment.DefaultFragment;
import com.blossoming.maker.Fragment.FourthFragment;
import com.blossoming.maker.Fragment.SecondFragment;
import com.blossoming.maker.Fragment.ThirdFragment;
import com.blossoming.schoolradio.R;

public class MainView extends Activity {
    private ImageView iv_userimage;
    private TextView tv_username;
    private ImageView ib_muchfunc;
    private Button btn_defaultfg;
    private Button btn_secondfg;
    private Button btn_thirdfg;
    private Button btn_fourthfg;
    private Fragment defaultFg;
    private void init()
    {
        iv_userimage= (ImageView) findViewById(R.id.iv_user_image);
        tv_username= (TextView) findViewById(R.id.tv_username);
        ib_muchfunc= (ImageView) findViewById(R.id.ib_muchfunc);
        btn_defaultfg= (Button) findViewById(R.id.btn_default);
        btn_secondfg= (Button) findViewById(R.id.btn_second);
        btn_thirdfg= (Button) findViewById(R.id.btn_third);
        btn_fourthfg= (Button) findViewById(R.id.btn_fourth);
        defaultFg=new DefaultFragment();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fg_default,defaultFg);
        transaction.commit();
    }
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }

}

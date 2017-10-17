package com.example.myapplicationsk;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 삼성 on 2017-10-17.
 */

public class SubActivity extends Activity {
    int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentActivity1 fragment = new FragmentActivity1();

        fragmentTransaction.add(R.id.container,fragment);
        fragmentTransaction.commit();
    }
    public void onClick(View view)
    {
        finish();
    }

    public void onChangeFragment(View v){
        Fragment fragment;

        switch(flag){
            default:
                case 0:{
                    fragment = new FragmentActivity1(); //블루
                    flag=1;
                    break;
            }
            case 1:{
                    fragment= new FragmentActivity2(); //레드
                    flag=0;
                    break;
            }
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }

}

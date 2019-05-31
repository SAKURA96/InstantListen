package com.example.instantlisten;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.library.NetworkManager;
import com.example.library.annotation.Network;
import com.example.library.listener.NetChangeObserver;
import com.example.library.type.NetType;
import com.example.library.utils.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册
//        NetworkManager.getDefault().setListener(this);
        NetworkManager.getDefault().registerObserver(this);
    }

   @Network(netType = NetType.AUTO)
    public void network(NetType netType) {
        switch(netType) {
            case WIFI:
                Log.e(Constants.LOG_TAG,"MainActivity >>> WIFI");
                break;

            case CMNET:
            case CMWAP:
                //流量网络
                Log.e(Constants.LOG_TAG,"MainActivity >>> " + netType.name());
                break;

            case NONE:
                //没有网络，提示用户跳转到设置界面
                Log.e(Constants.LOG_TAG,"MainActivity >>> 没有网络");
                break;
        }
   }

    @Network(netType = NetType.AUTO)
    private void abc(NetType netType) {
        Log.e(Constants.LOG_TAG,"MainActivity22 >>> " + netType.name());
    }


    private void bce() {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetworkManager.getDefault().unRegisterObserver(this);

    }
}

package com.example.library.utils;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.library.NetworkManager;
import com.example.library.type.NetType;

public class NetWorkUtils {

    //网络是否可用
    @SuppressLint("MissingPermission")
    public static boolean isNetWorkAvailable(){
        ConnectivityManager connMgr = (ConnectivityManager) NetworkManager.getDefault().getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connMgr == null) return false;

        //返回有用网络信息
        NetworkInfo[] info = connMgr.getAllNetworkInfo();
        if(info != null) {
            for(NetworkInfo anInfo:info){
                if(anInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    //获取当前网络类型 -1没有网络，1WIFI，2WAP， 3net
    @SuppressLint("MissingPermission")
    public static NetType getNetType(){
        ConnectivityManager connMgr = (ConnectivityManager) NetworkManager.getDefault().getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connMgr == null) return NetType.NONE;

        //获取当前激活的网络连接信息
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo == null) return NetType.NONE;

        int nType = networkInfo.getType();

        if(nType == ConnectivityManager.TYPE_MOBILE){
            if(networkInfo.getExtraInfo().toLowerCase().equals("cmnet")){
                return NetType.CMNET;
            } else {
                return NetType.CMWAP;
            }
        } else if (nType == ConnectivityManager.TYPE_WIFI){
            return NetType.WIFI;
        }
        return NetType.NONE;
    }

}

package com.example.library.listener;

import com.example.library.type.NetType;

//网络监听接口
public interface NetChangeObserver {

    void onConnect(NetType type);

    void onDisconnect();
}

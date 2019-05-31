package com.example.library.type;

//网络类型
public enum NetType {

    //主要关注WIFI和CMWAP

    //只要有网络，WIFI,GPRS
    AUTO,

    WIFI,

    //PC，笔记本电脑，PDA设备（定制化安卓）
    CMNET,

    //手机上网
    CMWAP,

    //没有网络
    NONE;
}



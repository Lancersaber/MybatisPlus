package com.lancer.创建型模式.建造者模式.model;

public class MobilePackage {

    //花费
    private float money;
    //短信
    private int shortInfo;
    //彩铃
    private String music;

    public float getMoney(){
        return money;
    }

    public void setMoney(float money){
        this.money=money;
    }

    public int getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(int shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}

package com.lancer.创建型模式.原型模式.pojo;

//在java中，只有实现了Cloneable接口的类才会被虚拟机认为是能够克隆的
public class DayLife implements Cloneable {

    //起床
    private String getUp;
    //坐公交
    private String byBus;
    //下车，买早餐
    private String getFood;
    //中午休息
    private String noon;
    //下午开始工作
    private String afternoonWork;
    //下班回家
    private String goHome;
    //晚上休闲
    private String night;

    public String getGetUp() {
        return getUp;
    }

    public void setGetUp(String getUp) {
        this.getUp = getUp;
    }

    public String getByBus() {
        return byBus;
    }

    public void setByBus(String byBus) {
        this.byBus = byBus;
    }

    public String getGetFood() {
        return getFood;
    }

    public void setGetFood(String getFood) {
        this.getFood = getFood;
    }

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon;
    }

    public String getAfternoonWork() {
        return afternoonWork;
    }

    public void setAfternoonWork(String afternoonWork) {
        this.afternoonWork = afternoonWork;
    }

    public String getGoHome() {
        return goHome;
    }


    public void setGoHome(String goHome) {
        this.goHome = goHome;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public void print(){
        System.out.println(this.getGetUp());
        System.out.println(getByBus());
        System.out.println(getGetFood());
        System.out.println(getNoon());
        System.out.println(getAfternoonWork());
        System.out.println(getGoHome());
        System.out.println(getNight());
    }

    @Override
    public DayLife clone() {
        try{
            return (DayLife) super.clone();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

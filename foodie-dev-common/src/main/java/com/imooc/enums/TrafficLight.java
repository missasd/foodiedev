package com.imooc.enums;

public class TrafficLight {
    Signal color = Signal.RED;

    public void change(){
        switch (color) { // 使用枚举来做比较
            case RED:
                color = Signal.GREEN;
                break;
            case YELLOW:
                color = Signal.RED;
            case GREEN:
                color = Signal.YELLOW;
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println(Color.GREEN.name());
    }
}

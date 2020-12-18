package com.imooc.enums;

public enum Color {
    RED("红色", 1), YELLOW("黄色", 2), GREEN("绿色", 3);

    private String name;
    private Integer index;

    Color(String name, Integer index){
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}

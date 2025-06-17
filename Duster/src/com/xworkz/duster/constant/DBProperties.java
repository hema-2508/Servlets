package com.xworkz.duster.constant;

public enum DBProperties {

    URL("jdbc:mysql://localhost:3306/weather"),
    USER_NAME("root"),
    SECRET("Hema@342434"),
    VERSION_8;

    private String prop;

    private  DBProperties(String prop)
    {
        this.prop=prop;
    }
    private DBProperties()
    {

    }

    public String getProp() {
        return prop;
    }
}

package com.abel.packagetrackingservice;

public enum PackageState  {

    PICKED_UP(0),
    IN_TRANSIT(1),
    WAREHOUSE(2),
    DELIVERED(3);

    public final int code;

    private PackageState(int code) {
        this.code = code;
    }
}

package com.renanbandeira.accelerometer;
import com.google.gson.annotations.SerializedName;

public class SensorData {
    private long timestamp;

    @SerializedName("X")
    private double x;

    @SerializedName("Y")
    private double y;

    @SerializedName("Z")
    private double z;

    public SensorData() {}

    public SensorData(long timestamp, double x, double y, double z) {
        this.timestamp = timestamp;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String toString() {
        return "t=" + timestamp + ", x=" + x + ", y=" + y + ", z=" + z;
    }
}
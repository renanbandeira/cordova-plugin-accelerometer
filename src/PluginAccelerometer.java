package com.renanbandeira.accelerometer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.google.gson.Gson;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by renan on 24/03/18.
 */

public class PluginAccelerometer extends CordovaPlugin implements SensorEventListener {
    private ArrayList<SensorData> accelerometerData;
    private SensorManager sensorManager;
    Sensor accelerometer;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("start")) {
            start();
            callbackContext.success();
            return true;
        }

        if (action.equals("stop")) {
            sensorManager.unregisterListener(this);
            callbackContext.success(new Gson().toJson(accelerometerData));
            accelerometerData.clear();
            return true;
        }
        callbackContext.error(1);
        return false;
    }

    public void start() {
        sensorManager = (SensorManager) cordova.getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelerometerData = new ArrayList<SensorData>();
        accelerometer = sensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer,
                SensorManager.SENSOR_STATUS_ACCURACY_HIGH);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        double x = event.values[0];
        double y = event.values[1];
        double z = event.values[2];
        long timestamp = System.currentTimeMillis();
        SensorData data = new SensorData(timestamp, x, y, z);
        if (event.sensor.equals(accelerometer)) {
            accelerometerData.add(data);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

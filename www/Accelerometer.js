var Accelerometer = {
};

Accelerometer.start = function(onSuccess, onError) {
    cordova.exec(onSuccess, onError, "PluginAccelerometer", "start", []);
};

Accelerometer.stop = function(onSuccess, onError) {
    cordova.exec(onSuccess, onError, "PluginAccelerometer", "stop", []);
};

module.exports = Accelerometer;

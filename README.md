# cordova-plugin-accelerometer
Plugin Accelerometer for Cordova. It makes you get accelerometer data from a range of time. You call start method to start collecting Accelerometer Data and then call stop method to stop collecting it and fetch the collected data to hybrid layer.

## Instalation

```
cordova plugin add https://github.com/renanbandeira/cordova-plugin-accelerometer.git
```

## Usage

### Start Collecting data

```
Accelerometer.start(function () { console.log('Starting to fetch Accelerometer Data'); });
```

### Stop Collecting Data and Fetch it

```
Accelerometer.stop(function (data) { console.log('Stopped to fetch Accelerometer Data. Data length: ' + data.length); });
```

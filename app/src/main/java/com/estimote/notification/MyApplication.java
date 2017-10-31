package com.estimote.notification;

import android.app.Application;

import com.estimote.notification.estimote.BeaconNotificationsManager;
import com.estimote.coresdk.common.config.EstimoteSDK;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

public class MyApplication extends Application {

    private boolean beaconNotificationsEnabled = false;

    @Override
    public void onCreate() {
        super.onCreate();

        // TODO: put your App ID and App Token here
        // You can get them by adding your app on https://cloud.estimote.com/#/apps
        EstimoteSDK.initialize(getApplicationContext(), "embeddedsystem-996", "f7f4b3bb37821b0298137f266958d91a");

        // uncomment to enable debug-level logging
        // it's usually only a good idea when troubleshooting issues with the Estimote SDK
//        EstimoteSDK.enableDebugLogging(true);
    }

    public void enableBeaconNotifications() {
        if (beaconNotificationsEnabled) { return; }

        BeaconNotificationsManager beaconNotificationsManager = new BeaconNotificationsManager(this);
        beaconNotificationsManager.addNotification(
                "2237fbe66fa7fe58013b4c1986516e2d",
                "Hello, world.",
                "Goodbye, world.");
        beaconNotificationsManager.startMonitoring();

        beaconNotificationsEnabled = true;
    }

    public boolean isBeaconNotificationsEnabled() {
        return beaconNotificationsEnabled;
    }
}

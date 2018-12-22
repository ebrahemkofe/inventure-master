package com.example.android.inventure.youssef;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class Firebase_Messaging_Service extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        handleNotification(remoteMessage.getNotification().getBody());
    }
    private void handleNotification(String body) {

        Intent pushNotification = new Intent(Config.STR_PUSH);
        pushNotification.putExtra("message" , body);
        LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);
    }
}

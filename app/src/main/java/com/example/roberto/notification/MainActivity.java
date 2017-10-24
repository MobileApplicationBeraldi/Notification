package com.example.roberto.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClicked(View view) {


        //Define the intent and pending Intent, for flag see documentation
        Intent intent = new Intent(this,ResultActivity.class);

        //getActivity is a Factory method
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT);


        //Define a new Notification from the compatibility builder
        NotificationCompat.Builder mBulider = new NotificationCompat.Builder(this);

        //Set the main paramters....
        mBulider
                .setContentTitle("This is a notification")
                .setContentText("Hello!")
                .setSmallIcon(R.drawable.mail)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);


        //Build the notification
        Notification notification = mBulider.build();

        //Send the notification to the notification manager..
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,notification);

    }
}

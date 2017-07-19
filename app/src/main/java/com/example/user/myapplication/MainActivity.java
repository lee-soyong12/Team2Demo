package com.example.user.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView imageview = null;
    public static final String PREFS_NAME = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        boolean silent = settings.getBoolean("SilentMode",true);
        Log.d("my",""+silent);
        Toast.makeText(getApplicationContext(),""+silent,Toast.LENGTH_SHORT).show();

        Button button = (Button) findViewById(R.id.noti);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                NotificationSomethings();
            }
        });


        Button hi = (Button) findViewById(R.id.button6);
        hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("발사");
                builder.setTitle("상명대학교_이소용")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.show();
            }
        });

}

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("silentMode", true);

        editor.commit();
    }

    public void NotificationSomethings() {
        Intent intent = new Intent(this, ResultActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        builder.setSmallIcon(R.drawable.blackpic);
        builder.setTicker("tickerText");
        builder.setContentTitle("contentTitle");
        builder.setContentText("contentText");
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.getNotification();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, notification);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.select, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.kart1:
                Toast.makeText(getApplicationContext(), "kartrider", Toast.LENGTH_SHORT).show();
                imageview = (ImageView)findViewById(R.id.nope);
                imageview.setImageResource(R.drawable.kart);
                Intent kart2 = new Intent(this, kart.class);
                startActivity(kart2);
                Intent kartservice = new Intent(this, MyIntentService.class);
                startService(kartservice);
                return true;

            case R.id.over1:
                Toast.makeText(getApplicationContext(), "overwatch", Toast.LENGTH_SHORT).show();
                imageview = (ImageView)findViewById(R.id.nope);
                imageview.setImageResource(R.drawable.overwatch);
                Intent over2 = new Intent(this,over.class);
                startActivity(over2);

                return true;

            case R.id.star1:
                Toast.makeText(getApplicationContext(), "starcraft", Toast.LENGTH_SHORT).show();
                imageview = (ImageView)findViewById(R.id.nope);
                imageview.setImageResource(R.drawable.starcraft);
                Intent star2 = new Intent(this,star.class);
                startActivity(star2);
                Intent starservice = new Intent(this, MyIntentService.class);
                startService(starservice);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void slash(View view){
        imageview = (ImageView)findViewById(R.id.nope);
        imageview.setImageResource(R.drawable.blackpic);
        Toast.makeText(getApplicationContext(),"clean",Toast.LENGTH_SHORT).show();
    }

    public void showPopup(View view){
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.select,popup.getMenu());
        popup.show();
    }

}



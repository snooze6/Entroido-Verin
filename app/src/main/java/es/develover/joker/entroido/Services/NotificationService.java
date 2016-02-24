package es.develover.joker.entroido.Services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import es.develover.joker.entroido.Activities.ConcursoActivity;
import es.develover.joker.entroido.R;

/**
 * Created by entakitos on 7/02/16.
 */
public class NotificationService extends Service {

    private Context c;

    public void lanzarNotificacion(){

        if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("notificación",true)) {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.ic_contacts_white_24dp_2x)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon))
                            .setVibrate(new long[]{1000, 1000})
                            .setLights(Color.GREEN, 1000, 3000)
                            .setContentTitle("Entroido Verin App")
                            .setContentText("Participa en nuestro concurso de disfraces!");

            // Creates an explicit intent for an Activity in your app
            Intent resultIntent = new Intent(this, ConcursoActivity.class);

            // The stack builder object will contain an artificial back stack for the
            // started Activity.
            // This ensures that navigating backward from the Activity leads out of
            // your application to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(ConcursoActivity.class);
            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            // mId allows you to update the notification later on.
            mNotificationManager.notify(0, mBuilder.build());

            PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("notificación",false).commit();
        }
    }

    public NotificationService() { }

    @Override
    public void onCreate() {
        Log.e("[NOTIFICACIOM]", "[FUCHICURRULA A CREACION]");

        lanzarNotificacion();
        stopSelf();

        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}

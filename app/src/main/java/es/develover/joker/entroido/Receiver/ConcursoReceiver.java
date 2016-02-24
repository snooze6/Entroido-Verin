package es.develover.joker.entroido.Receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import es.develover.joker.entroido.Services.NotificationService;

/**
 * Created by entakitos on 7/02/16.
 */
public class ConcursoReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("[NOTIFICACIOM]","[NOTIFICACIOM]");

        //Calendar firingCal= Calendar.getInstance();
        //firingCal.set(Calendar.HOUR, 0); // At the hour you wanna fire
        //firingCal.set(Calendar.MINUTE, 28); // Particular minute
        //firingCal.set(Calendar.SECOND, 0); // particular second

        Intent i = new Intent(context, NotificationService.class);
        //TODO: revisar argumentos
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, i, 0);


        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 3000,pendingIntent);


    }
}

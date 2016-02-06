package hu.alit.notifyperhour;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Calendar;

/**
 * Created by alit on 05/02/2016.
 */
public class NotifyService extends Service {
	protected int PERIOD_OF_TIME = 3000;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);

		AlarmManager mgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		Intent i = new Intent(this, NotifyMeReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);

		Calendar time = Calendar.getInstance();
		time.setTimeInMillis(System.currentTimeMillis());
		time.add(Calendar.SECOND, 3);
		mgr.setRepeating(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), PERIOD_OF_TIME, pi);

		return START_STICKY;
	}

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}







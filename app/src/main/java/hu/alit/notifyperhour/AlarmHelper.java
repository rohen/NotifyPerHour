package hu.alit.notifyperhour;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.util.Calendar;

/**
 * Created by alit on 06/02/2016.
 */
public class AlarmHelper {

	AlarmManager alarmManager;
	PendingIntent pendingIntent;
	Context context;
	
	public AlarmHelper(Context context) {
		this.context = context;
		
		alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

		Intent intent = new Intent(context, NotifyMeReceiver.class);
		pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
	}

	public void setAlarm() {


		Calendar time = Calendar.getInstance();
		time.setTimeInMillis(System.currentTimeMillis());
		time.add(Calendar.SECOND, 3);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), 3000, pendingIntent);
	}

	public void enableReceiver() {
		ComponentName receiver = new ComponentName(context, NotifyMeReceiver.class);
		PackageManager pm = context.getPackageManager();

		pm.setComponentEnabledSetting(receiver,
				PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
				PackageManager.DONT_KILL_APP);
	}

	public void disableReceiver() {
		ComponentName receiver = new ComponentName(context, NotifyMeReceiver.class);
		PackageManager pm = context.getPackageManager();

		pm.setComponentEnabledSetting(receiver,
				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
				PackageManager.DONT_KILL_APP);
	}

	public void cancelAlarm() {
		if (alarmManager!= null) {
			alarmManager.cancel(pendingIntent);
		}
	}
}

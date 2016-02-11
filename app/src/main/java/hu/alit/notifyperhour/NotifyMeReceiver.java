package hu.alit.notifyperhour;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/**
 * Created by alit on 05/02/2016.
 */
public class NotifyMeReceiver extends BroadcastReceiver {

	private static final long REMOVE_NOTIFICATION_TIME_IN_MILLIS = 3000;

	@Override
	public void onReceive(final Context context, Intent intent) {
		String intentAction = intent.getAction();
		if (intentAction != null && intentAction.equals("android.intent.action.BOOT_COMPLETED")) {
			AlarmHelper alarmManager = new AlarmHelper(context);
			alarmManager.setAlarm();
//		} else if (intentAction != null && intentAction.equals("android.intent.action.TIME_SET")) {
		} else {
			Notification notification = NotificationUtils.createNotification(context);
			NotificationUtils.notify(context, 123, notification);

			removeNotificationAfterTime(context);

		}
	}

	private void removeNotificationAfterTime(final Context context) {
		Handler handler = new Handler();
		handler.postDelayed(
				new Runnable() {
					@Override
					public void run() {
						NotificationUtils.removeNotification(context);
					}
				}, REMOVE_NOTIFICATION_TIME_IN_MILLIS);
	}
}

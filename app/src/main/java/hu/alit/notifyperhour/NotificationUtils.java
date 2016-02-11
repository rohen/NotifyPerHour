package hu.alit.notifyperhour;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * Created by alit on 07/02/2016.
 */
public class NotificationUtils {
	public static Notification createNotification(Context context) {
		NotificationCompat.Builder builder =
				new NotificationCompat.Builder(context)
						.setSmallIcon(android.R.drawable.alert_light_frame)
						.setContentTitle(context.getString(R.string.notification_title))
						.setContentText(context.getString(R.string.notification_text));
		return builder.build();
	}

	public static void notify(Context context, int notificationId, Notification notification) {
		NotificationManager notificationManager =
				(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(notificationId, notification);
	}

	public static void removeNotification(Context context) {
		NotificationManager notificationManager =
				(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.cancelAll();
	}
}

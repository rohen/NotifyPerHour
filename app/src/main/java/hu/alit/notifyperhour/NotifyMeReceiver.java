package hu.alit.notifyperhour;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by alit on 05/02/2016.
 */
public class NotifyMeReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
			AlarmHelper.setAlarm(context);
		} else if(intent.getAction().equals("android.intent.action.TIME_SET")) {
			//notify
		}
	}
}

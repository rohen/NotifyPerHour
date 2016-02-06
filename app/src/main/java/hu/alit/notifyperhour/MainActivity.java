package hu.alit.notifyperhour;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by alit on 05/02/2016.
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_activity);

		final AlarmHelper alarmHelper = new AlarmHelper(this);

		Button startAlarmButton = (Button)findViewById(R.id.start_alarm_id);
		startAlarmButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				alarmHelper.enableReceiver();
				alarmHelper.setAlarm();
			}
		});

		Button stopAlarmButton = (Button)findViewById(R.id.stop_alarm_id);
		stopAlarmButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				alarmHelper.disableReceiver();
				alarmHelper.cancelAlarm();
			}
		});
	}
}

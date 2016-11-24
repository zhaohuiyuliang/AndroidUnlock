package yu.jishang.com.unlock.com.broadcast.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SystemReceiver extends BroadcastReceiver {
	private int i = -1;

	@Override
	public void onReceive(Context context, Intent arg1) {
		i++;
		if ("android.intent.action.ACTION_SHUTDOWN".compareTo(arg1.getAction()) == 0) {
			Toast.makeText(context, "关机" + i, Toast.LENGTH_LONG).show();
			Log.e("SystemReceiver", arg1.getAction());
		} else if ("android.intent.action.USER_PRESENT".compareTo(arg1
				.getAction()) == 0) {
			Toast.makeText(context, "屏幕开启" + i, Toast.LENGTH_LONG).show();

			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					android.os.Process.killProcess(android.os.Process.myPid());
				}
			}).start();
		}

	}

}

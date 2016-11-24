package yu.jishang.com.unlock.com.demo.app.statistics;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import yu.jishang.com.unlock.R;


public class AppStatistics extends Activity {
	private Button bt_app_statistics;
	private TextView tv_content_statistics;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_statistics);
		bt_app_statistics = (Button) findViewById(R.id.bt_start_statistics);
		tv_content_statistics = (TextView) findViewById(R.id.tv_content_statistics);
		setListener();
	}

	private void setListener() {
		bt_app_statistics.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				PackageManager pm = getPackageManager();
				// 获取指定程序的PackageInfo对象
				try {
					PackageInfo pi = pm.getPackageInfo("com.example.test",
							PackageManager.GET_CONFIGURATIONS);
					Log.i("AppStatistics", pi.lastUpdateTime + "");
				} catch (NameNotFoundException e1) {
					e1.printStackTrace();
				}
				new Thread(new Runnable() {

					@Override
					public void run() {
						boolean threadRunning = true;
						while (threadRunning) {
							try {
								Toast.makeText(
										getApplicationContext(),
										Statistic.getInstance()
												.getCurrentRunAppId(),
										Toast.LENGTH_LONG).show();
								Log.i("AppStatistics", Statistic.getInstance()
										.look_up_pid());
								Thread.sleep(5000L);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}
				});// .start();
				tv_content_statistics.setText(Statistic.getInstance()
						.getCurrentRunAppId());
			}
		});
	}

}

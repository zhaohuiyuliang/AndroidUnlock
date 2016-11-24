package yu.jishang.com.unlock.com.demo.app.statistics;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import yu.jishang.com.unlock.com.example.shareproject.MyApplication;

public class Statistic {
	MyApplication application = MyApplication.getApplication();
	private static Statistic msStatistic;

	private Statistic() {

	}

	public static Statistic getInstance() {
		if (msStatistic == null) {
			msStatistic = new Statistic();
		}
		return msStatistic;
	}

	public String getCurrentRunAppId() {
		ActivityManager localActivityManager = (ActivityManager) application
				.getSystemService(Context.ACTIVITY_SERVICE);
		String runningAppID = "";
		int versionCode = Build.VERSION.SDK_INT;
		if (versionCode >= 21) {
			try {
				Iterator<ActivityManager.RunningAppProcessInfo> localIterator1 = localActivityManager
						.getRunningAppProcesses().iterator();
				if (localIterator1.hasNext()) {
					ActivityManager.RunningAppProcessInfo localRunningTaskInfo = localIterator1
							.next();
					runningAppID = localRunningTaskInfo.pkgList[0];
				}
			} catch (Exception e) {
				Log.d("AppStatistics", e.getMessage(), e);
			}
		} else {
			Iterator<RunningTaskInfo> localIterator1 = localActivityManager
					.getRunningTasks(1).iterator();
			if (localIterator1.hasNext()) {
				RunningTaskInfo localRunningTaskInfo = localIterator1.next();
				runningAppID = localRunningTaskInfo.topActivity
						.getPackageName();
			}
		}
		return runningAppID;
	}

	public String look_up_pid() {
		BufferedReader reader = null;
		String content = "";
		try {
			Process process = Runtime.getRuntime().exec("ps -P");
			reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			StringBuffer output = new StringBuffer();
			String read;
			char[] buffer = new char[4096];
			output.append(read = reader.readLine() + "\n");
			while (!TextUtils.isEmpty((read = reader.readLine()))) {
				if (isTVPID(read)) {
					output.append(read + "\n");
				}
			}
			reader.close();
			content = output.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	private boolean isTVPID(String lineStr) {
		boolean flag = false;
		String[] strs = lineStr.split(" ");
		List<String> list = Arrays.asList(strs);
		flag = list.contains("tv");
		return flag;
	}

}

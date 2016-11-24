package yu.jishang.com.unlock.com.example.shareproject;

import android.app.Application;
import android.widget.Toast;

public class MyApplication extends Application {
	private static MyApplication application;

	public static MyApplication getApplication() {
		return application;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
		Toast.makeText(getApplicationContext(), getPackageName() + " 已被安装",
				Toast.LENGTH_LONG).show();
	}

}

package yu.jishang.com.unlock.com.example.shareproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import yu.jishang.com.unlock.R;


public class SharedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_view);
		if (getIntent().getData() != null) {
			String data = getIntent().getData().getHost();
			Bundle bundle = getIntent().getExtras();
			String value = bundle.getString("value");
			Toast.makeText(getApplicationContext(), data + " :" + value,
					Toast.LENGTH_LONG).show();

		}
	}
}

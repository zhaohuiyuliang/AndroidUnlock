package yu.jishang.com.unlock.com.contentprovider.demo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class FlowerContentProvider extends ContentProvider {
	// 常量UriMatcher.NO_MATCH表示不匹配任何路径的返回码
	UriMatcher sMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	// 如果match()方法匹配content://com.ljq.provider.personprovider/person路径，返回匹配码为1
	{
		sMatcher.addURI("com.example.dameonservice", "flower", 1);// 添加需要匹配uri，如果匹配就会返回匹配码
		// 如果match()方法匹配content://com.ljq.provider.personprovider/person/230路径，返回匹配码为2
		sMatcher.addURI("com.example.dameonservice", "flower/#", 2);// #号为通配符
	}

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		switch (sMatcher.match(arg0)) {
		case 1:
			break;
		case 2:
			break;
		default:// 不匹配
			break;
		}
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		return null;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		return null;
	}

	@Override
	public boolean onCreate() {
		return false;
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
			String arg4) {
		return null;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		return 0;
	}

}

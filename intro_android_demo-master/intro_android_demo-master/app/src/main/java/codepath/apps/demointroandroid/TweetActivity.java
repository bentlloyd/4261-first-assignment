package codepath.apps.demointroandroid;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;

public class TweetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet);
		TwitterSession session = TwitterCore.getInstance().getSessionManager()
				.getActiveSession();
		Intent intent = new ComposerActivity.Builder(TweetActivity.this)
				.session(session)
				.createIntent();
		startActivity(intent);
	}

}

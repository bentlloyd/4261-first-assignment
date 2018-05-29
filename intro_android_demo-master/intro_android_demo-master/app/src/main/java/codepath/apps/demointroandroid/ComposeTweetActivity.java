package codepath.apps.demointroandroid;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;

public class ComposeTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_tweet);

        TwitterSession session = TwitterCore.getInstance().getSessionManager()
                .getActiveSession();
        Intent intent = new ComposerActivity.Builder(ComposeTweetActivity.this)
                .session(session)
                .text("Cavs in 4")
                .createIntent();
        startActivity(intent);
    }

}

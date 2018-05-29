package codepath.apps.demointroandroid;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DistanceToCancun extends Activity {

	private Button b;
	private TextView t;
	private LocationManager locationManager;
	private LocationListener listener;
	Location targetLocation;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_time_picker_demo);

		t = (TextView) findViewById(R.id.textView);
		b = (Button) findViewById(R.id.button);

		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		targetLocation = new Location("");//provider name is unnecessary
		targetLocation.setLatitude(21.1619d);//your coords of course
		targetLocation.setLongitude(-86.8515d);


		listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location location) {
				System.out.println("lat1: " + location.getLatitude());
				System.out.println("long1: " + location.getLongitude());

				System.out.println("lat2: " + targetLocation.getLatitude());

				System.out.println("long2: " + targetLocation.getLongitude());

				t.append("\n " + targetLocation.distanceTo(location)/1000 + " km");
			}

			@Override
			public void onStatusChanged(String s, int i, Bundle bundle) {

			}

			@Override
			public void onProviderEnabled(String s) {

			}

			@Override
			public void onProviderDisabled(String s) {

			}
		};

		configure_button();
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		switch (requestCode){
			case 10:
				configure_button();
				break;
			default:
				break;
		}
	}

	void configure_button(){
		// first check for permissions
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
				requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
						,10);
			}
			return;
		}
		// this code won't execute IF permissions are not allowed, because in the line above there is return statement.
		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//noinspection MissingPermission
				locationManager.requestLocationUpdates("gps", 5000, 0, listener);
			}
		});
	}
}

package com.marakana.android.logservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class LogService extends Service {
	private static final String TAG = "LogService";
	private ILogServiceImpl service;

	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate()'d");
		super.onCreate();
		this.service = new ILogServiceImpl(super.getApplicationContext());
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind()'d");
		return this.service;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d(TAG, "onUnbind()'d");
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy()'d");
		super.onDestroy();
	}
}

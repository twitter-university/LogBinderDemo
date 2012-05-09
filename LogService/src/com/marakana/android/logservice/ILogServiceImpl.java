package com.marakana.android.logservice;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;

import com.marakana.android.logcommon.ILogService;
import com.marakana.android.logcommon.LogMessage;

public class ILogServiceImpl extends ILogService.Stub {

	private static final String TAG = "ILogServiceImpl";

	private final Context context;

	public ILogServiceImpl(Context context) {
		this.context = context;
	}

	@Override
	public void log(LogMessage logMessage) throws RemoteException {
		Log.d(TAG, "Logging message");
		if (logMessage.getTag().length() > 10
				|| logMessage.getMsg().length() > 80) {
			this.context.enforceCallingPermission(
					Manifest.permission.USE_LONG_LOG_SERVICE, "Go away!");
		}
		Log.println(logMessage.getPriority(), logMessage.getTag(),
				logMessage.getMsg());
	}
}

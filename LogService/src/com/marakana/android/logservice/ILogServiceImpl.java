package com.marakana.android.logservice;

import android.os.RemoteException;
import android.util.Log;

import com.marakana.android.logcommon.ILogService;
import com.marakana.android.logcommon.LogMessage;

public class ILogServiceImpl extends ILogService.Stub {

	private static final String TAG = "ILogServiceImpl";

	@Override
	public void log(LogMessage logMessage) throws RemoteException {
		Log.d(TAG, "Logging message");
		Log.println(logMessage.getPriority(), logMessage.getTag(),
				logMessage.getMsg());
	}
}

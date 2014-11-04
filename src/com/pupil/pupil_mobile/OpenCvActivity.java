package com.pupil.pupil_mobile;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;

import android.app.Activity;
import android.util.Log;

/**
 * Base class for Activities using OpenCv.
 * It is responsible for loading the OpenCv libraries asynchronously.
 * Activities extending this class get notified about success by calling the abstract function onOpenCvLoaded().
 * 
 * @author Michael
 *
 */
abstract public class OpenCvActivity extends Activity {
	protected static final String TAG = "pupil-mobile";

	protected BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {

		@Override
		public void onManagerConnected(int status) {
			switch (status) {
				case LoaderCallbackInterface.SUCCESS: {
					Log.d(TAG, "OpenCV loaded successfully");
					onOpenCvLoaded();
				} break;
				default: {
					super.onManagerConnected(status);
				} break;
			}
		}
	};

	abstract void onOpenCvLoaded();
}

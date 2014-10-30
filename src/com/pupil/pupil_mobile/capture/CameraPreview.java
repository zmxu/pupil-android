package com.pupil.pupil_mobile.capture;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * 
 * @author Michael & Mayank
 * 
 * CameraPreview is a UI control capable of showing Frame-objects provided by a CaptureDevice.
 * 
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback, IFrameProcessor {

	private static final boolean DEBUG=true;
	private static final String TAG="DoubleWebCam";
	protected Context context;
	private SurfaceHolder holder;
	private Bitmap bmp = null;
	
	public CameraPreview(Context context) {
		super(context);

		this.context = context;
		setFocusable(true);
		holder = getHolder();
		holder.addCallback((Callback) this);
		if(DEBUG) Log.d(TAG,"CameraPreview constructed");
	}
	
	public CameraPreview(Context context, AttributeSet attrs) {
		super(context);

		this.context = context;
		setFocusable(true);
		holder = getHolder();
		holder.addCallback((Callback) this);
		if(DEBUG) Log.d(TAG,"CameraPreview constructed");
	}

	@Override
	public void processFrame(Frame frame) {
		// TODO write new frame to canvas
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		if(bmp == null){
			int IMG_WIDTH=1280;
			int IMG_HEIGHT=720;
			bmp = Bitmap.createBitmap(IMG_WIDTH, IMG_HEIGHT, Bitmap.Config.ARGB_8888);
		}
		if(DEBUG) Log.d(TAG, "surfaceCreated");
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		if(DEBUG) Log.d(TAG, "surfaceChanged");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		if(DEBUG) Log.d(TAG, "surfaceDestroyed");
	}
}

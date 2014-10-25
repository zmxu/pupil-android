package com.pupil.pupil_mobile.capture;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback,IFrameProcessor {

	private static final boolean DEBUG=true;
	private static final String TAG="DoubleWebCam";
	protected Context context;
	private SurfaceHolder holder;
	private Bitmap[] bmp=new Bitmap[1];
	public CameraPreview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
		if(DEBUG) Log.d(TAG,"CameraPreview constructed");
		setFocusable(true);
		bmp[0] = null;
		holder = getHolder();
		holder.addCallback((Callback) this);
	}
	
	public CameraPreview(Context context, AttributeSet attrs) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
		if(DEBUG) Log.d(TAG,"CameraPreview constructed");
		setFocusable(true);
		bmp[0] = null;
		holder = getHolder();
		holder.addCallback((Callback) this);
	}

	@Override
	public void processFrame(Frame frame) {
		// TODO Auto-generated method stub addn canvas here

	}
	public void surfaceCreated(SurfaceHolder holder) {
		if(DEBUG) Log.d(TAG, "surfaceCreated");
			if(bmp[0]==null){
				int IMG_WIDTH=1280;
				int IMG_HEIGHT=720;
				bmp[0] = Bitmap.createBitmap(IMG_WIDTH, IMG_HEIGHT, Bitmap.Config.ARGB_8888);
			}
		}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		if(DEBUG) Log.d(TAG, "surfaceChanged");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		if(DEBUG) Log.d(TAG, "surfaceDestroyed");
	}

}

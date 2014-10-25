package com.pupil.pupil_mobile.capture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements IFrameProcessor {

	public CameraPreview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public CameraPreview(Context context, AttributeSet attrs) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processFrame(Frame frame) {
		// TODO Auto-generated method stub

	}

}

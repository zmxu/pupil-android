package com.pupil.pupil_mobile.capture;

import java.io.Closeable;
import java.io.IOException;

import android.util.Log;

public class CaptureDevice implements IFrameCapture, Runnable, Closeable {
	
	private final int id;
	private CaptureProperties properties;
	private boolean[] cameraExists=new boolean[2];
	private Thread captureThread;
	// prepareCamera selects the device automatically. please set videoid=0
    public native int prepareCamera(int videoid);
    static {
        System.loadLibrary("ImageProc");
    }
	public CaptureDevice(int id, CaptureProperties properties){
		this.id = id;
		this.properties = properties;
		
		// TODO: init camera here
		int ret = prepareCamera(0);
		// ret: -3(/dev/video[01] do not exist)
		//      -2(/dev/video1 does not exist)
		//      -1(/dev/video0 does not exist)
		ret = -ret;
		Log.e("Mayank","return is"+ret);
		//if((ret & 0x2)>>1==1){
			//cameraExists[1] = false;
		//}else{
			//cameraExists[1] = true;
		//}
		if((ret & 0x01)==1){
			cameraExists[0] = false;
		}else{
			cameraExists[0] = true;
		}
		
		//captureThread = new Thread(this);
		//captureThread.start();
	}
	
	@Override
	public void run() {
		while (true){
			// TODO grab frame
			// TODO call notify() every time when there's a new frame
			
			// check if the program wants to stop capturing
			if (Thread.currentThread().isInterrupted()){
				break;
			}
		}
	}

	@Override
	public synchronized void addFrameProcessor(IFrameProcessor processor) {
		if (processor == null)
			throw new IllegalArgumentException("The processor you wanted to add was null!");
		if (frameProcessors.contains(processor)){
			return;
		}
		frameProcessors.add(processor);
	}

	@Override
	public synchronized void removeFrameProcessor(IFrameProcessor processor) {
		frameProcessors.remove(processor);
	}

	@Override
	public synchronized void notify(Frame frame) {
		for (IFrameProcessor processor : frameProcessors) {
			processor.processFrame(frame);
		}
	}

	@Override
	public void close() throws IOException {
		if (this.captureThread.isAlive()){
			this.captureThread.interrupt();
		}
		
		// TODO close camera
	}
	

	public CaptureProperties getProperties() {
		return properties;
	}

	public void setProperties(CaptureProperties properties) {
		this.properties = properties;
	}

	public int getId() {
		return id;
	}
}

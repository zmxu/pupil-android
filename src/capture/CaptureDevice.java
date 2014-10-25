package capture;

import java.io.Closeable;
import java.io.IOException;

public class CaptureDevice implements IFrameCapture, Runnable, Closeable {
	
	private final int id;
	private CaptureProperties properties;

	private Thread captureThread;
	
	public CaptureDevice(int id, CaptureProperties properties){
		this.id = id;
		this.properties = properties;
		
		// TODO: init camera here
		
		captureThread = new Thread(this);
		captureThread.start();
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

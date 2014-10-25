package com.pupil.pupil_mobile.capture;

import java.util.Vector;

public interface IFrameCapture {
	public Vector<IFrameProcessor> frameProcessors = new Vector<IFrameProcessor>();
	
	public void addFrameProcessor(IFrameProcessor processor);
	public void removeFrameProcessor(IFrameProcessor processor);
	public void notify(Frame frame);
}

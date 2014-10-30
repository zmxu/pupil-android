package com.pupil.pupil_mobile.capture;

import java.util.EventListener;

public interface IFrameProcessor extends EventListener {
	/**
	 * Processes a new incoming Frame
	 * 
	 * @param frame
	 */
	public void processFrame(Frame frame);
}

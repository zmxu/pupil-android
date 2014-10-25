package com.pupil.pupil_mobile.capture;

public class CaptureProperties {
	private int fps = 30;
	private Resolution resolution = new Resolution(1280, 720);
	private int absoluteFocus = 0;
	private boolean autoFocus = false;
	
	public int getFps() {
		return fps;
	}
	public void setFps(int fps) {
		this.fps = fps;
	}
	public Resolution getResolution() {
		return resolution;
	}
	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}
	public int getAbsoluteFocus() {
		return absoluteFocus;
	}
	public void setAbsoluteFocus(int absoluteFocus) {
		this.absoluteFocus = absoluteFocus;
	}
	public boolean isAutoFocus() {
		return autoFocus;
	}
	public void setAutoFocus(boolean autoFocus) {
		this.autoFocus = autoFocus;
	}
}

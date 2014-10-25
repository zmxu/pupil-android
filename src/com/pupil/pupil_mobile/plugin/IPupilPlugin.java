package com.pupil.pupil_mobile.plugin;

import com.pupil.pupil_mobile.capture.Frame;

public interface IPupilPlugin {

	public void onStart();
	public void onUpdate(Frame frame);
	public void onClose();
	
}

package com.pupil.pupil_mobile;

import java.util.HashMap;
import java.util.Map;

import com.pupil.pupil_mobile.capture.CameraPosition;
import com.pupil.pupil_mobile.capture.CaptureDevice;
import com.pupil.pupil_mobile.plugin.PluginController;

/**
 * 
 * @author Michael
 * 
 * Central class of the pupil mobile app.
 * It is responsible to load, run and manage all components and plug-ins.
 * 
 */
public class PupilController {
	
	protected Map<CameraPosition, CaptureDevice> cameras = new HashMap<CameraPosition, CaptureDevice>();
	protected PluginController plugins;
	
}

package plugin;

import capture.Frame;

public interface IPupilPlugin {

	public void onStart();
	public void onUpdate(Frame frame);
	public void onClose();
	
}

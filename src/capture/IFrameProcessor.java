package capture;

import java.util.EventListener;

public interface IFrameProcessor extends EventListener {
	public void processFrame(Frame frame);
}

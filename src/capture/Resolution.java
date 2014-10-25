package capture;

public class Resolution {
	private int width = 0;
	private int height = 0;
	
	public Resolution(){
		
	}
	
	public Resolution(int width, int height){
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}

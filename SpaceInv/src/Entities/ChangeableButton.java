package Entities;

public class ChangeableButton extends Buttons {
	int state;
	public ChangeableButton(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		// TODO Auto-generated constructor stub
	}
	
	public void changeText(String text){
		this.text= text;
	}
	
	public void setState(int state){
		this.state=state;
	}
	
	public int getState(){
		return state;
	}

}

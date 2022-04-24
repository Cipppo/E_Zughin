package menu.gui;

public class MenuControl {
	
	private int navStatus;
	private int enterStatus;
	private MenuModel model;
	
	public MenuControl(MenuModel menuModel) {
		this.navStatus = 0;
		this.enterStatus = 0;
		this.model = menuModel;
	}
	
	public void setEnterStatus(int i) {
		this.enterStatus = i;
	}
	
	public int getEnterStatus() {
		return this.enterStatus;
	}
	
	public void setNavStatus(int i) {
		this.navStatus = i;
	}
	
	public int getNavStatus() {
		return this.navStatus;
	}
	
	public void UpAct() {
		if (enterStatus > 0) {
			model.restartMenu();
		}else {
			//model.decNavStatus();
			navStatus--;
			model.changeBlink();
		}
	}
	
	public void DownAct() {
		if (enterStatus > 0) {
			model.restartMenu();
		}else {
			//model.decNavStatus();
			if (navStatus < 2) {
				navStatus++;
				model.changeBlink();
			}
			
		}
	}
	
	public void EnterAct() {
		enterStatus++;
		model.exEntAct();
	}
	
	public void keyAct(int i, char c) {
		if (enterStatus > 0){
			model.exActList(i, c);
		}
	}
	
	
}

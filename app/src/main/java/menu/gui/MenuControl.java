package menu.gui;

/**
 * Class to control the gui
 *
 */
public class MenuControl {
	
	private int navStatus; 				// check for the navigation
	private int enterStatus;			// check for the entering
	private MenuModel model;
	
	/**
	 * Constructor with parameters (model)
	 * @param menuModel 
	 */
	public MenuControl(MenuModel menuModel) {
		this.navStatus = 0;
		this.enterStatus = 0;
		this.model = menuModel;
	}
	
	/**
	 * set method
	 * @param i
	 */
	public void setEnterStatus(int i) {
		this.enterStatus = i;
	}
	
	/**
	 * get method
	 * @return enterStatus
	 */
	public int getEnterStatus() {
		return this.enterStatus;
	}
	
	/**
	 * set method
	 * @param i
	 */
	public void setNavStatus(int i) {
		this.navStatus = i;
	}
	
	/**
	 * get method
	 * @return navStatus
	 */
	public int getNavStatus() {
		return this.navStatus;
	}
	
	/**
	 * UP Action it sees how many times the enter button was push and from this says to the model what to do
	 */
	public void UpAct() {
		if (enterStatus > 0) {
			model.restartMenu();
		}else {
			//model.decNavStatus();
			navStatus--;
			model.changeBlink();
		}
	}
	
	/**
	 * DOWN Action it sees how many times the enter button was push and from this says to the model what to do
	 */
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
	
	/**
	 *  EnterAction it says to the model
	 */
	public void EnterAct() {
		enterStatus++;
		model.exEntAct();
	}
	
	/**
	 * generic action it says to the model
	 * @param i button code
	 * @param c button char
	 */
	public void keyAct(int i, char c) {
		if (enterStatus > 0){
			model.exActList(i, c);
		}
	}
	
	
}
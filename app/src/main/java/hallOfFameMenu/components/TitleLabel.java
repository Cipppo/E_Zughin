package hallOfFameMenu.components;

import menu.utils.PrimaryLabel;

public class TitleLabel extends PrimaryLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3667606843812512575L;
	
	public TitleLabel(String text) {
		this.setText(text);
		this.setPSize(7);
		this.setFont(this.getGameFont());
		
	}
	
}

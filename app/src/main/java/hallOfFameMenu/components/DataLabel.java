package hallOfFameMenu.components;

import menu.utils.GenericLabel;

public class DataLabel extends GenericLabel{
	

	private static final long serialVersionUID = -6018524334211006731L;
	
	public DataLabel(String text) {
		this.setText(text);
		this.setFont(this.getGameFont());
	}
}

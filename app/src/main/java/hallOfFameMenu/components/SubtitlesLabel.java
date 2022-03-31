package hallOfFameMenu.components;

import menu.utils.SecondaryLabel;

public class SubtitlesLabel extends SecondaryLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1953141241408051372L;
	
	public SubtitlesLabel(String text) {
		this.setText(text);
		this.setSSize(3);
		this.setFont(this.getGameFont());
	}
}

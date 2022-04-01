package menu.components;

import menu.utils.PrimaryLabel;

public class SubtitleLabel extends PrimaryLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5425263161796580824L;
	    
    public SubtitleLabel() {
        this.setText("ARCADE RETRO-GAME");
        this.setPSize(7);
		this.setFont(this.getGameFont());
    }
	
}

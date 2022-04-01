package menu.components;

import menu.utils.GenericLabel;

public class StartLabel extends GenericLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8430588428621513653L;
    
    public StartLabel() {
        this.setText("START");
        this.setGSize(4);
		this.setFont(this.getGameFont());
    }
}

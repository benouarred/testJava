package com.sfeir.baseball;

public enum Position {
	PITCHER("Pitcher"),
	CATCHER("Catcher"),
	INFIELD("Infield"),
	OUTFIELD("Outfield"),
	DESIGNATEDHITTER("DesignatedHitter");
	
	private String label;
	
	Position(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}

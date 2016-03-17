package jrl.constants;

public enum Suites {
	CLUBS("Clubs"), SPADES("Spades"), HEARTS("Hearts"), DIAMONDS("Diamonds");
	
	private String suiteAsString;
	
	private Suites(String suiteAsString) {
		this.suiteAsString = suiteAsString;
	}
	
	@Override
	public String toString() {
		return this.suiteAsString;
	}
}

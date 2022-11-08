package moblima.Model;

public enum MovieType {
	IN_2D("2D"),
	IN_3D("3D"),
	BLOCKBUSTER("Blockbuster");
	
	private final String type;
	private MovieType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}

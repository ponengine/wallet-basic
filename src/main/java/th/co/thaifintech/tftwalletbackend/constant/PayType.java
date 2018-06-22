package th.co.thaifintech.tftwalletbackend.constant;

public enum PayType {
	
	ADD("A"),
	SPEND("S"),
	EXCHANGE("E"),
	REFUND("R");
	
	private String type;

	public String getType() {
		return type;
	}

	private PayType(String type) {
		this.type = type;
	}
	
	
}

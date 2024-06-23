package enums;

public enum TipoCampoEnum {
	TEXT("text"), COMBO_BOX("select");

	public String tipoCampo;

	TipoCampoEnum(String tipo) {
		tipoCampo = tipo;
	}
}

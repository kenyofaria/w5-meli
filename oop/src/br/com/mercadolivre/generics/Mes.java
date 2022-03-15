package br.com.mercadolivre.generics;

public enum Mes {

	JANEIRO(1),
	FEVEREIRO(2),
	MARCO(3),
	ABRIL(4),
	MAIO(5);

	private int numero;

	Mes(int numero) {
		this.numero = numero;
	}
	public int getNumero() {
		return numero;
	}
}

/**
 * 
 * 	DOCUMENTO_REGULAR("00"),
	ESCRITURACAO_EXTEMPORANEA_REGULAR("01"),
	DOCUMENTO_CANCELADO("02"),
	ESCRITURACAO_EXTEMPORANEA_CANCELADO("03"),
	DOCUMENTO_DENEGADO("04"),
	NUMERACAO_INUTILIZADA("05"),
	DOCUMENTO_COMPLEMENTAR("06"),
	ESCRITURACAO_EXTEMPORANEA_COMPLEMENTAR("07"),
	DOCUMENTO_REGIME_ESPECIAL("08");
	
    private String codigo;

    CodigoDocumentoFiscal(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() { 
        return codigo;
    }
 * 
 */

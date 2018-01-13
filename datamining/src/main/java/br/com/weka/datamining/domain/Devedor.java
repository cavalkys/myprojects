package br.com.weka.datamining.domain;

/**
 * 
 * @author cavalkys
 *
 */
public class Devedor {

	private String credor;
	
	private String faixaAtraso;
	
	private String faixaIdade;
	
	private String faixaValorDivida;
	
	private String sexo;
	
	private boolean fazAcordo;

	public String getCredor() {
		return credor;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}

	public String getFaixaAtraso() {
		return faixaAtraso;
	}

	public void setFaixaAtraso(String faixaAtraso) {
		this.faixaAtraso = faixaAtraso;
	}

	public String getFaixaIdade() {
		return faixaIdade;
	}

	public void setFaixaIdade(String faixaIdade) {
		this.faixaIdade = faixaIdade;
	}

	public String getFaixaValorDivida() {
		return faixaValorDivida;
	}

	public void setFaixaValorDivida(String faixaValorDivida) {
		this.faixaValorDivida = faixaValorDivida;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isFazAcordo() {
		return fazAcordo;
	}

	public void setFazAcordo(boolean fazAcordo) {
		this.fazAcordo = fazAcordo;
	}

	@Override
	public String toString() {
		return "Devedor [credor=" + credor + ", faixaAtraso=" + faixaAtraso + ", faixaIdade=" + faixaIdade
				+ ", faixaValorDivida=" + faixaValorDivida + ", sexo=" + sexo + ", fazAcordo=" + fazAcordo + "]";
	}
	
}

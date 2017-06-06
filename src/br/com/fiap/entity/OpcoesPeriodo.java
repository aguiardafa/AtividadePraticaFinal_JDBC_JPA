package br.com.fiap.entity;

public enum OpcoesPeriodo {
	MATUTINO(1, "MATUTINO"), VESPERTINO(2, "VESPERTINO"), NOTURNO(3, "NOTURNO");

	private final int valor;
	private final String turno;
	
	OpcoesPeriodo(int valorOpcao, String turnoOpcao){
		valor = valorOpcao;
		turno = turnoOpcao;
		
	}
	public int getValor(){
		return valor;
	}
	public String getTurno() {
		return turno;
	}
	
}

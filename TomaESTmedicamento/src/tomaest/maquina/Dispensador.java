package tomaest.maquina;

import java.util.List;

/** 
 * Classe que representa um dos dispensadores da m�quina.
 * Cada dispensador tem um medicamento e v�rios comprimidos (ou c�psulas)
 * desse medicamento
 */

	


public class Dispensador {

	
	private String nomeMedicamento;
	private int posi�aoDisp;
	private int quantidadeAtual;
	
	
	
	/** adiciona numa certa quantidade de comprimidos ao dispensador
	 */
	
	
	
	
	
	
	public Dispensador(String nomeMedicamento, int quantidadeAtual, int posi�aoDisp) {
	
		setQuantidadeAtual(quantidadeAtual);
		setNomeMedicamento(nomeMedicamento);
		setPosi�aoDisp (posi�aoDisp);
	}

	

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}


	

	public int getPosi�aoDisp() {
		return posi�aoDisp;
	}

	public void setPosi�aoDisp(int posi�aoDisp) {
		this.posi�aoDisp = posi�aoDisp;
	}
	



	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}
	
	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}





	public int addQuantidade(int quant) {
		
		return quantidadeAtual=quantidadeAtual+quant;
		
		
		
	}

	/** despeja, na gaveta de sa�da, a quantidade solicitada de comprimidos.
	 * @param quant quantidade de comprimidos a despejar
	 * @return a quantidade realmente despejada, pois pode n�o haver quantidade
	 *  suficiente para satisfazer o pedido
	 */
	public int despeja( int quant ) {
		if(quant<=quantidadeAtual) {
			quantidadeAtual=quantidadeAtual-quant;
		return quantidadeAtual;
		}
		else
		
		return 0;  //Devia avisar que n�o tem stock que chegue mas nao sei como...
		
	}
	
	/** indica se este dispensador est� a ser usado ou se est� livre
	 * @return true, se est� a ser usado, false caso esteja livre
	 */
	public boolean estaUsado( ) {
		if(quantidadeAtual>0) {
			return true;			//Vai haver confus�o entre estar a ser usado ou ter esgotado o stock!
			
		}else
		return false;
	}
	
	/** Indica se o dispensador tem comprimidos suficientes para
	 * satisfazer todas as tomas da lista
	 * @param tomas lista de tomas que � necess�rio satisfazer
	 * @return true, se tem comprimidos suficientes, false caso contr�rio
	 */
	public boolean consegueResponder( List<Toma> tomas ) {
		return true;
	}
}

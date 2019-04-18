package tomaest.maquina;

import java.util.List;

/** 
 * Classe que representa um dos dispensadores da máquina.
 * Cada dispensador tem um medicamento e vários comprimidos (ou cápsulas)
 * desse medicamento
 */

	


public class Dispensador {

	
	private String nomeMedicamento;
	private int posiçaoDisp;
	private int quantidadeAtual;
	
	
	
	/** adiciona numa certa quantidade de comprimidos ao dispensador
	 */
	
	
	
	
	
	
	public Dispensador(String nomeMedicamento, int quantidadeAtual, int posiçaoDisp) {
	
		setQuantidadeAtual(quantidadeAtual);
		setNomeMedicamento(nomeMedicamento);
		setPosiçaoDisp (posiçaoDisp);
	}

	

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}


	

	public int getPosiçaoDisp() {
		return posiçaoDisp;
	}

	public void setPosiçaoDisp(int posiçaoDisp) {
		this.posiçaoDisp = posiçaoDisp;
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

	/** despeja, na gaveta de saída, a quantidade solicitada de comprimidos.
	 * @param quant quantidade de comprimidos a despejar
	 * @return a quantidade realmente despejada, pois pode não haver quantidade
	 *  suficiente para satisfazer o pedido
	 */
	public int despeja( int quant ) {
		if(quant<=quantidadeAtual) {
			quantidadeAtual=quantidadeAtual-quant;
		return quantidadeAtual;
		}
		else
		
		return 0;  //Devia avisar que não tem stock que chegue mas nao sei como...
		
	}
	
	/** indica se este dispensador está a ser usado ou se está livre
	 * @return true, se está a ser usado, false caso esteja livre
	 */
	public boolean estaUsado( ) {
		if(quantidadeAtual>0) {
			return true;			//Vai haver confusão entre estar a ser usado ou ter esgotado o stock!
			
		}else
		return false;
	}
	
	/** Indica se o dispensador tem comprimidos suficientes para
	 * satisfazer todas as tomas da lista
	 * @param tomas lista de tomas que é necessário satisfazer
	 * @return true, se tem comprimidos suficientes, false caso contrário
	 */
	public boolean consegueResponder( List<Toma> tomas ) {
		return true;
	}
}

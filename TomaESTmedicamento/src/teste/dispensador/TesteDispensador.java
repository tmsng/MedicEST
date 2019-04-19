package teste.dispensador;

import tomaest.maquina.Dispensador;

public class TesteDispensador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dispensador d1 =new Dispensador ("InstaPoo", 0,1);
	//	d1.setQuantidadeAtual(0);
	//	d1.addQuantidade(15);
	//	d1.despeja(5);
		
		System.out.println(d1.getNomeMedicamento());
		

	}

}

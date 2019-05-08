package tomaest.maquina;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import tomaest.hardware.Hardware;
import tomaest.maquina.Dispensador;
import tomaest.app.PhoneApp;

/** Classe que representa o software de controlo da m�quina dispensadora.
 * Esta classe deve fornecer m�todos para a comunica��o com a PhoneApp e
 * deve ela pr�pria comunicar com o hardware.
 */
public class Maquina {
	
	private Hardware hardware; // hardware da m�quina que vai controlar
	private Dispensador disp;
	
	//DAVID_START
	private int controlo = 0;
	private boolean x = false;
	//DAVID_END

	// deve ter uma lista de dispensadores e outra de tomas -------------------------------------------------------------------------------------------------
	private ArrayList<Dispensador> dispensador = new ArrayList<Dispensador>();
	private ArrayList<Toma> toma = new ArrayList<Toma>();

	/** cria uma m�quina com o respetivo hardware 
	 * @param hardware hardware da m�quina que vai controlar
	 */
	public Maquina(Hardware hardware) {
		this.hardware = hardware;
		
		// configurar os restantes elementos da m�quina
		
		
		hardware.setMaquina( this );
	}
	
	
	public void dispensadoresIniciais() {
		addDispensador( new Dispensador("ProgJa", 5) );		
		addDispensador( new Dispensador("JavaPill", 20) );
		addDispensador( new Dispensador("InstantPOO", 5) );
		addDispensador( new Dispensador("CodeNight", 25) );		
		
		//System.out.println(getDispensador(0));
		
		//System.out.println("dispensador: " + dispensador + "\n\n");
	}
	
	
	public void tomasIniciais(LocalDateTime inicio) {
		Toma t1 = new Toma(inicio.plusMinutes(1));
		t1.addPartes( new TomaParcial(getDispensador(0) , 2) );
		t1.addPartes( new TomaParcial(getDispensador(1) , 1) );
		addToma(t1);
		
		//System.out.println("Toma 1:\n" + t1);

		Toma t2 = new Toma(inicio.plusMinutes(10));
		t2.addPartes( new TomaParcial(getDispensador(2), 1) );		
		t2.addPartes( new TomaParcial(getDispensador(3), 1) );
		addToma(t2);
		
		//System.out.println("Toma 2:\n" + t2);		
		
		//System.out.println("toma:\n" + toma);
		
	}
	
	
	//DAVID_END
	
	/** m�todo que � chamado pelo temporizador do hardware
	 * sempre que se passam 20 segundos
	 */
	public void processar() { //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//DAVID_START
		if(x){
			if(controlo < 15){
				switch(controlo){
					case 0: // 0min
						this.hardware.tocaAlarme();
						break;
					case 3: // 1min
						this.hardware.tocaAlarme();
						break;
					case 6: // 2min
						this.hardware.tocaAlarme();
						break;
					case 9: // 3min
						this.hardware.tocaAlarme();
						break;
					case 12: // 4min
						this.hardware.tocaAlarme();
						break;
				}
				controlo++;
			}
			this.hardware.tocaAlarme(); // 5min
		}
		//DAVID_END
	}
	
	
	/** m�todo que � chamado pelo hardware quando o utente
	 *  removeu os comprimidos da gaveta
	 */
	public void gavetaVazia() { //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		// deve fechar a gaveta
		
		//DAVID_START
		x = false;
		controlo = 0;
		this.hardware.fecharGaveta();
		//DAVID_END
	}


	/** m�todo que vai verificar se h� tomas que t�m
	 * de ser ministradas neste momento
	 */
	private void checkTomas() {
			
	}	

	
	/** Indica quantos dispensadores horizontais existem
	 * @return n�mero de dispensadores horizontais
	 */
	public int getDispensadoresHorizontais() { //------------------------------------------------------------------------------------------------------------
		return hardware.getHorizontais();
	}
	
	
	/** Indica quantos dispensadores verticais existem
	 * @return n�mero de dispensadores verticais
	 */
	public int getDispensadoresVerticais() { //-------------------------------------------------------------------------------------------------------------
		return hardware.getVerticais();
	}
	
	
	/** Abre o dispensador indicado
	 * @param disp n�mero do dispensador a abrir
	 */
	public void abrirDispensador( int disp ) { //-----------------------------------------------------------------------------------------------------------
		hardware.abrirTampa(disp);
	}
	
	
	/** indica se o diepensador est� livre ou em uso
	 * @param dispNum n�mero do dispensador
	 * @return true, se o dispensador est� livre, false caso esteja em uso
	 */
	public boolean estaLivre( int dispNum ) {
		if(dispNum < dispensador.size()){
			//System.out.println(getDispensador(dispNum).estaUsado());
			if(getDispensador(dispNum).estaUsado())
				return false;
		}
		return true;
	}

	
	/** indica qual o medicamento que est� associado ao dispensador
	 * @param dispNum  n�mero do dispensador
	 * @return nome do medicamento associado ao dispensador,
	 * null, caso n�o haja medicamento associado
	 */
	public String getMedicamento( int dispNum ){
		if(dispNum < dispensador.size()) {
			return getDispensador(dispNum).getNomeMedicamento();
		}
		return "";
	}

	
	/** indica quantos comprimidos ainda tem no dispensador
	 * @param dispNum n�mero do dispensador
	 * @return quantos comprimidos ainda tem no dispensador
	 */
	public int getQuantidade( int dispNum ) {
		if(dispNum < dispensador.size()) {
			return getDispensador(dispNum).getquantidadeTotal();
		}
		return 0;
	}
	
	
	/** Configura um dispensador, indicando qual o medicamento a ele associado
	 * e respetiva quantidade de comprimidos
	 * 
	 * @param dispNum n�mero do dispensador
	 * @param medicamento nome do medicamento
	 * @param quant quantidade de comprimidos
	 */
	public void configurarDispensador( int dispNum, String medicamento, int quant ) {
		
	}

	
	/** carrega o dispensador com a quantidade de medicamentos indicada
	 * @param dispNum n�mero do dispensador
	 * @param quant quantidade de comprimidos a adicionar
	 */
	public void carregarDispensador(int dispNum, int quant) {

	}

	
	/** Adiciona uma toma � lista de tomas. Se a toma a adicionar tiver a mesma data
	 * que uma toma j� existente, a nova deve ser associada � j� existente.
	 * As tomas devem estar ordenadas por ordem crescente da data de toma.
	 * 
	 * @param quando data a que a toma deve ser efetuada
	 * @param dispNum qual o dispensador a usar
	 * @param quant quantos comprimidos a usar
	 */
	public void addToma(LocalDateTime quando, int dispNum, int quant ) {
		
	}
	
	
	/** devolve uma lista com as tomas que devem ser realizadas at� � data indicada
	 * @param fim data de fim da pesquisa
	 * @return uma lista com as tomas que devem ser realizadas at� � data indicada
	 */
	public List<Toma> tomasAte( LocalDateTime fim ){
		return null;
	}

	
	public void addDispensador(Dispensador d){
		dispensador.add(d);
	}
	
	
	public Dispensador getDispensador(int idx){
		return dispensador.get(idx);
	}
	
	
	public void addToma(Toma t) {
		toma.add(t);
	}
}

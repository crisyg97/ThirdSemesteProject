package prog2TPC1_2018;

import java.util.ArrayList;
import java.util.Iterator;

public class Plano implements Iterable<Caja>{
	
	private int[][] plano;
	private int largoP,anchoP;
	private ArrayList<Tupla> ubicacion; //lista de las ubicaciones de las cajas en el plano
	private ArrayList<Caja> cajas; //lista de las cajas que tiene el plano
	
	public Plano(int larg, int anch){
		this.largoP = larg;
		this.anchoP = anch;
		this.plano = new int[larg][anch];
		for(int i=0; i< plano.length;i++){ //inicializa toda la matriz en 0
			for(int j=0; j<plano[i].length;j++){
				plano[i][j] = 0;
			}
		}
		this.ubicacion = new ArrayList();
		this.cajas = new ArrayList();
	}
	
	public int espacioTotalPlano(){
		return largoP * anchoP;
	}
	
	public boolean estaOcupadCoord(int x, int y){
		if(this.plano[x][y] != 0)
			return true;
		return false;
	}
	
	public void agregarCajAlPlano(int largo, int ancho, int entero){
		Caja caj = new Caja(largo,ancho,entero);  //crea la caja
		boolean entrada = true, primeraVez = true;
		int x =0, larg = largo;
		while(entrada){
			if(largo <= espacioDispFilaX(x)) //busca la fila en donde tenga espacio para agregar una caja
				entrada = false;
			x++;
		}
		for(int j=0; j<ancho ;j++){
			for(int i=0;i<plano[x].length;i++){ //estoy en la fila en donde hay espacio para poner la caja
				if(!(estaOcupadCoord(x,i)) && primeraVez){
					plano[x][i] = entero;
					larg--;
					this.agregarUbicacionLista(x, i);
					primeraVez = false;
				}
				if(!(estaOcupadCoord(x,i)) && larg != 0){
					plano[x][i] = entero;
					larg--;
					}
			}
			x++; //avanza a la siguiente fila
		}
	this.agregarCajaLista(caj);
		
	}
	private int espacioDispFilaX(int x){
		int espacioDisp=0;
		for(int i=0; i<plano[x].length;i++){
			if(!(estaOcupadCoord(x,i)))
				espacioDisp++;
			else
				i = plano[x].length;
		}
		return espacioDisp;
	}
	
	private void agregarCajaLista(Caja caj){
		this.cajas.add(caj);
	}
	
	private void agregarUbicacionLista(int x, int y){
		Tupla tup = new Tupla(x,y);
		this.ubicacion.add(tup);
	}
	
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(!(o instanceof Plano))
			return false;
		Plano plan = (Plano) o;
		if(!(plan.getAncho() == this.anchoP && plan.getLargo() == this.largoP))
			return false;
		if(!(plan.getCajas().size() == cajas.size()))
			return false;
		int i = 0;
		boolean ret = true;
		Iterator<Caja> it = cajas.iterator(); // uso del iterator en la lista de cajas de esta clase
		while(it.hasNext()){
			ret = ret && (it.next().equals(plan.getCajas().get(i)));
			i++;
		}
		for(int j=0; i<this.ubicacion.size();i++){
			ret = ret && this.ubicacion.get(j).equals(plan.getUbicacion().get(j));
		}
		return ret;
	}
	
	public void imprimirMatriz(){
		for(int i=0; i<plano.length;i++){
			System.out.println(this.imprimirFila(plano[i]));
		}
	}
	private String imprimirFila(int[] x){
		StringBuilder fila = new StringBuilder();
		for(int i=0;i<x.length;i++){
			fila.append(x[i] + " ");
		}
		return fila.toString();
	}
	
	public int espacioDisponible(){
		int espacioOcupado = 0;
		for(int i=0; i<cajas.size();i++){
			espacioOcupado += cajas.get(i).espacioOcupa();
		}
		return espacioOcupado - this.espacioTotalPlano();
	}
	
	public int TamañoOcupadoCajas(){
		return this.espacioTotalPlano() + this.espacioDisponible();
	}
	
	public int cajasEntranEspacioDIsp(){
		int cantCajas = 0; // cantidad de cajas que pueden entrar en el espacio disponible
		int espacioDisp = (-1)*(this.espacioDisponible());  
		for(int i=0;i<this.cajas.size();i++){
			if(this.cajas.get(i).espacioOcupa() < espacioDisp ){
				cantCajas++;
				espacioDisp = espacioDisp - this.cajas.get(i).espacioOcupa();
			}
		}
		return cantCajas;
	}
	
	public ArrayList<Tupla> getUbicacion() {
		return ubicacion;}
	public ArrayList<Caja> getCajas() {
		return cajas;}
	public int getLargo() {
		return largoP;}
	public int getAncho() {
		return anchoP;}
	
	@Override
	public Iterator<Caja> iterator() {
		Iterator<Caja> it = this.cajas.iterator();
		return it;
	}
}

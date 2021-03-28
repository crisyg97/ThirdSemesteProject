package prog2TPC1_2018;

public class Caja {
	private int entero;
	private Tupla tamanio;

	public Caja(int largo, int ancho, int entero){
		this.entero = entero;
		if(largo > 0 && ancho > 0){
			tamanio = new Tupla(largo, ancho);
		}else{
			throw new RuntimeException("no es posible crear la caja");
		}
	}
	
	public int espacioOcupa(){
		return this.tamanio.getElem1() * this.tamanio.getElem2();
	}
	
	public boolean equals(Object o){ //si una caja es igual a otra tiene que cumplirse que
		if(o == null)
			return false;
		if(!(o instanceof Caja)) //lo que se pasa como parametro tiene que ser una caja
			return false;
		Caja caj = (Caja) o;
		if(!(caj.getEntero() == this.entero)) //el entero sean iguales
			return false;
		if(!(caj.getTamanio().equals(this.tamanio))) //el tamanio sean iguales
			return false;
		return true;
	}

	public int getEntero() {
		return entero;}
//	public void setEntero(int entero) {
//		this.entero = entero;}
	public int getLargo(){
		return this.tamanio.getElem1();}
	public int getAncho(){
		return this.tamanio.getElem2();}
	public Tupla getTamanio() {
		return tamanio;}
}

package prog2TPC1_2018;

import java.util.Iterator;

public class Habitacion implements Iterable<Caja>{
	private Plano plano;
	
	public Habitacion(int largo, int ancho){
		if(largo > 0 && ancho > 0)
			plano = new Plano(largo,ancho);
		else
			throw new RuntimeException("no se puede crear el plano");
	}
	
	public void agregarCaja(int largo, int ancho, int entero){
		if(puedoAgregarCaja(largo,ancho)){
			plano.agregarCajAlPlano(largo,ancho,entero);
		}else{
			throw new RuntimeException("no se puede agregar la caja");
		}
	}
	
	public boolean puedoAgregarCaja(int largo, int ancho){
		if((largo * ancho) < plano.espacioDisponible()){
			return false;
		}
		if(largo > plano.getLargo())
			return false;
		if(ancho > plano.getAncho())
			return false;
		return true;
	}
	
	public int reacomodarCajas(){
		if(plano.TamañoOcupadoCajas() < plano.espacioDisponible()) 
			return 0; //si hay demasiado espacio disponible no es necesario reacomodar las cajas
		return this.getPlano().cajasEntranEspacioDIsp();
	}

	public boolean equals(Object o){
		if(o == null)
			return false;
		if(!(o instanceof Habitacion))
			return false;
		Habitacion hab = (Habitacion) o;
		if(!(hab.getPlano().equals(this.plano)))
			return false;
		return true;
	}

	public String toString(){
		StringBuilder txt = new StringBuilder();
		txt.append("tamaño total: " + plano.espacioTotalPlano());
		txt.append("tamaño ocupado:" + (plano.espacioTotalPlano() - plano.espacioDisponible()));
		return txt.toString();
	}
	
	public void imprimirHabitacion(){
		this.plano.imprimirMatriz();
	}
	
	boolean puedoPasarCajas(Habitacion hab1){
		if((-1)*(this.plano.espacioDisponible()) > hab1.getPlano().TamañoOcupadoCajas())
			return true;
		return false;
	}
	
	public void validarIrep(){
		Caja negat = new Caja(-2,-7,6);
		Habitacion habNegat = new Habitacion(-10,-20);
	}
	
	public Plano getPlano() {
		return plano;}
	public int cantCajas(){
		return plano.getCajas().size();}
	
	/////////////////////////////////////////////////////
	protected class HabIterator implements Iterator<Caja> {
		protected int posicion;
		
		public HabIterator() {this.posicion = 0;}
		
		public boolean hasNext(){
			boolean siguiente;
			if(posicion < plano.getCajas().size()){
				siguiente = true;
			}else{
				siguiente = false;
			}
			return siguiente;
		}
		
		public Caja next(){
			posicion++;
			return plano.getCajas().get(posicion-1);
		}
		
		public void remove(){
			 throw new RuntimeException("no es posible");
		}
	}
//////////////////////////////////////////////////////////////
	@Override
	public Iterator<Caja> iterator() {
		Iterator<Caja> it = new HabIterator();
		return it;
	}
}

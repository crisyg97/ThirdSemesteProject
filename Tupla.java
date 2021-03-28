package prog2TPC1_2018;

public class Tupla{
	private int elem1;
	private int elem2;

	public Tupla(){
		this.elem1 = 0;
		this.elem2 = 0;
	}
	public Tupla(int e1, int e2){
		this.elem1 = e1;
		this.elem2 = e2;
	}
	
	public int getElem1() {return elem1;}
	public void setElem1(int elem1) {this.elem1 = elem1;}
	public int getElem2() {return elem2;}
	public void setElem2(int elem2) {this.elem2 = elem2;}

	public boolean equals(Object o){
		if(!(o instanceof Tupla))
			return false;
		Tupla tup = (Tupla) o;
		if(!(this.elem1 == tup.getElem1() && this.elem2 == tup.getElem2()))
				return false;
		return true;
	}
}	

package Ej01;

public class Programa {
		public static void main(String[] args) {
	
			Almacen almacen=new Almacen();
			Montador montador1= new Montador("Pedrito", almacen);
			Montador montador2= new Montador("Juanjo", almacen);
			Operario operario1=new Operario("Julian", almacen);
			Operario operario2=new Operario("Jesucristo", almacen);
			
			
			montador1.start();
			montador2.start();
			operario1.start();
			operario2.start();
			
			
			
			
}
}

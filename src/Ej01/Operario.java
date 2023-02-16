package Ej01;

public class Operario extends Thread {
	
	private Almacen almacen;
	private String nombre;
	
	public Operario(String nombre,Almacen almacen) {
		this.nombre=nombre;
		this.almacen=almacen;
	}
	
	
	
	
	public String getNombre() {
		return nombre;
	}




	public void run() {
		
	for (int i = 0; i < 4; i++) {
		almacen.fabricar_marco(nombre);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int j = 0; j < 2; j++) {
			almacen.fabricar_rueda(nombre);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
		
	}
	
	
	

}

package Ej01;

import java.util.ArrayList;

public class Almacen {

	private ArrayList<Integer> almacen_rueda;
	private Integer id_rueda;

	private ArrayList<Integer> almacen_marco;
	private Integer id_marco;

	public Almacen() {
		almacen_rueda=new ArrayList<Integer>();
		almacen_marco=new ArrayList<Integer>();
	}


	public synchronized void fabricar_marco(String nombre) {

		id_marco=(int) (Math.random()*100);

		while(almacen_marco.size()>=4) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("El operario "+nombre+" fábrica un marco con id: "+id_marco);
		almacen_marco.add(id_marco);
		notifyAll();
	}

	public synchronized void fabricar_rueda(String nombre) {	

		id_rueda=(int) (Math.random()*100);

		while(almacen_rueda.size()>=10) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("El operario "+nombre+" fábica una rueda con id "+id_rueda);
		almacen_rueda.add(id_rueda);
		notifyAll();
	}




	public synchronized int[] coger_piezas(String nombre) {
		while(almacen_marco.size()<1  || almacen_rueda.size()<2) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int registro[]=new int[3];
		registro[0]=almacen_marco.get(almacen_marco.size()-1);
		almacen_marco.remove(almacen_marco.size()-1);
		registro[1]=almacen_rueda.get(almacen_rueda.size()-1);
		almacen_rueda.remove(almacen_rueda.size()-1);
		registro[2]=almacen_rueda.get(almacen_rueda.size()-1);
		almacen_rueda.remove(almacen_rueda.size()-1);
		
		System.out.println("El montador "+nombre+" registra 1º rueda "+registro[1]+" y regsitra la 2º rueda "+registro[2]+" y registra el marco "+registro[0]);
		return registro;
	}






}

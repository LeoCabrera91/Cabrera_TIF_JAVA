package com.ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ejercicios.main.Buscadores;


public class MainApplication {

    public static void main( String[] args ){
	
		//Defino los maps los relaciono con una key númerica que será una ID del turno. 
		//No uso el npumero de carnet como key ya que si un mismo Cliente tiene dos turnos no funcionaría.
		Map<Integer, String> nombres = new HashMap<Integer, String>();
		nombres.put(1,"Juan Perez");
		nombres.put(2,"Ana Lisa Sosa");
		nombres.put(3,"Debora Lopez");
		nombres.put(4,"Carlos Marquez");
		nombres.put(5,"Marcelo Diaz");
		nombres.put(6,"Carmen Salcedo");
		nombres.put(7,"Juan Carrillo");
		nombres.put(8,"Elvio Garcia");
		nombres.put(9, "Rocio Gomez");
		nombres.put(10,"Gonzalo Paez");

		Map<Integer, String> especialidades = new HashMap<Integer, String>();
		
		especialidades.put(1,"Oftalmologia");
		especialidades.put(2,"Cardiologia");
		especialidades.put(3,"Clinica Medica");
		especialidades.put(4,"Cardiologia");
		especialidades.put(5,"Neurologia");
		especialidades.put(6,"Oftalmologia");
		especialidades.put(7,"Neurologia");
		especialidades.put(8,"Cardiologia");
		especialidades.put(9,"Clinica Medica");
		especialidades.put(10,"Neurologia");

		Map<Integer, String> horarios = new HashMap<Integer, String>();
		horarios.put(1,"1200");
		horarios.put(2,"1200");
		horarios.put(3,"1230");
		horarios.put(4,"1130");
		horarios.put(5,"1000");
		horarios.put(6,"1100");
		horarios.put(7,"1200");
		horarios.put(8,"1300");
		horarios.put(9,"1200");
		horarios.put(10,"1100");

		//Defino una Lista de Strings con todas las especialidades existentes:

		String lista_especialidades[] ={"Oftalmologia","Cardiologia","Clinica Medica","Neurologia"};

		//Para agrupar por especialidad uso la funcion agrupar_ especialidad de la clase Buscadores. Primero instancio la clase:

		Buscadores buscadores = new Buscadores();

		//Defino ArrayList donde se van a guardar los nombres y los horarios de cada especialidades

		ArrayList<String> nombres_especialidad = new ArrayList<String>();
		ArrayList<String> horarios_especialidad = new ArrayList<String>();
		ArrayList<String> grupo_ordenado = new ArrayList<String>();
		
		//Defino un nuevo map donde voy a agrupar las especialidades con la lista con los nombres y horarios de los pacientes.
		Map<String, ArrayList<String>> pacientes_agrupados = new HashMap<String, ArrayList<String>>();
		//Recorro la lista de especialidades y llamo a la funcion agrupar especialidad para que me traiga los nombres y horarios de los turnos de cada especialidad.
		
		for (int i=0; i< lista_especialidades.length; i++){

			nombres_especialidad = buscadores.agrupar_especialidad(lista_especialidades[i], especialidades, nombres);
			horarios_especialidad = buscadores.agrupar_especialidad(lista_especialidades[i], especialidades, horarios);

			//ingreso los datos en el map pcientes_agrupados, usando como key la especialidad y como value la lista de pacientes ordenados por horarios
			// que se genera llamando a la funcion ordenar por horarios de la clase buscadores
			pacientes_agrupados.put(lista_especialidades[i],buscadores.ordenar_por_horarios(nombres_especialidad,horarios_especialidad));
		}

		//defino dos nuevos maps, donde utilizando como key la especialidad, defino como value en uno el nombre del especialista y en el otro el consultorio
		
		Map<String, String> especialistas = new HashMap<String, String>();

		especialistas.put("Neurologia","Dra. Sabrina Lopez");
		especialistas.put("Cardiologia","Dra. Juliana Garcia");
		especialistas.put("Oftalmologia","Dr. Roberto Perez");
		especialistas.put("Clinica Medica", "Dra. Monica Guzman");


		Map<String, String> consultorios = new HashMap<String, String>();
		consultorios.put("Neurologia","Consultorio 5");
		consultorios.put("Cardiologia","Consultorio 7");
		consultorios.put("Oftalmologia","Consultorio 1");
		consultorios.put("Clinica Medica", "Consultorio 4");

		//utilizo un foreach para recorrer los 3 maps e informar en pantalla lo solicitado:
		pacientes_agrupados.forEach((k,v)->{

			System.out.println(k + " - "+consultorios.get(k)+ " - "+ especialistas.get(k)+":");
			for(int i=0;i<v.size();i++){
				System.out.println(v.get(i));
			}
		System.out.println("");
		});

		//Recorro el Map pacientes agrupados nuevamente para mostrar en pantalla la cantidad de pacientes que hay por especialidad:
		System.out.println("Número de pacientes por especialidad:");
		pacientes_agrupados.forEach((k,v)->{

			System.out.println(k+": "+v.size()+" pacientes");
		});
	}
}

package com.ejercicios.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Buscadores {

    public ArrayList<String> agrupar_especialidad (String especialidad,Map<Integer,String> especialidades,Map<Integer,String> map_valor_buscado){
        ArrayList<String> grupo_especialidad = new ArrayList<String>();

        especialidades.forEach((k,v)-> {
            if (v.equalsIgnoreCase(especialidad)) {

                grupo_especialidad.add(map_valor_buscado.get(k));
                
            }


        });

        return grupo_especialidad;

    }

    public ArrayList<String> ordenar_por_horarios (ArrayList<String> nombres,ArrayList<String> horarios) {
    
    //Defino una nueva ArrayList que va a ser el Return de la función, que se va a contituir de los elementos de
    // nombre y horarios, concatendados y ordenados por horarios. 
    
    ArrayList<String> grupo_ordenado = new ArrayList<String>();


        // creo una lista donde van a quedar ordenadas las posiciones de ambos ArrayList

    ArrayList<Integer> orden = new ArrayList<Integer>();
        for(int i=0;i<horarios.size();i++){

            orden.add(i);
        }
        // ordeno la lista de posiciones con un Collection.sort, definiendo un comparador con funcion lamda, donde cada elemento
        // lo ordene comparando los elementos del ArrayList horarios, utilizo la funcion Integer.parseInt para comparar dado que el map de horarios esta definido como STRING.

        Collections.sort(orden,(a,b)-> Integer.compare(Integer.parseInt(horarios.get(a)),(Integer.parseInt(horarios.get(b)))));
   
        // completo el ArrayList grupo_ordenado con los nombres y horarios, concatenados y ordenados por horarios:
        
        for(int i=0;i<orden.size();i++){

            grupo_ordenado.add(nombres.get(orden.get(i))+" - "+horarios.get(orden.get(i))+" hs");


        }



        return grupo_ordenado;

    }
    
    



}

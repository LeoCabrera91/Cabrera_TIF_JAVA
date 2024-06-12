package com.ejercicios.main;

import java.util.ArrayList;
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
    ArrayList<String> grupo_ordenado = new ArrayList<String>();





        return grupo_ordenado;

    }

}

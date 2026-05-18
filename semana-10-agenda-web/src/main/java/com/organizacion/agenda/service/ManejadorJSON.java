package com.organizacion.agenda.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ManejadorJSON<T> {
    private final String ruta;
    private final Gson gson = new Gson();
    private final Class<T> clase;

    public ManejadorJSON(Class<T> clase, String ruta) {
        this.clase = clase;
        this.ruta = ruta;
    }

    public void guardar(List<T> lista) {
        try (Writer w = new FileWriter(ruta)) {
            gson.toJson(lista, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> cargar() {
        File f = new File(ruta);
        if (!f.exists() || f.length() == 0) return new ArrayList<>();
        try (Reader r = new FileReader(ruta)) {
            Type tipo = TypeToken.getParameterized(List.class, clase).getType();
            List<T> lista = gson.fromJson(r, tipo);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
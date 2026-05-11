package com.organizacion.agenda.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.organizacion.agenda.modelo.Contacto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorJSON {
    private String rutaArchivo;
    private Gson gson;

    public ManejadorJSON(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.gson = new Gson();
    }

    public void guardar(List<Contacto> contactos) {
        try (Writer writer = new FileWriter(rutaArchivo)) {
            gson.toJson(contactos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Contacto> cargar() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists() || archivo.length() == 0) return new ArrayList<>();
        try (Reader reader = new FileReader(rutaArchivo)) {
            List<Contacto> lista = gson.fromJson(reader, new TypeToken<List<Contacto>>(){}.getType());
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
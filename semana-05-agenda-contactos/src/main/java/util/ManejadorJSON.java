package util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelo.Contacto;
import java.io.*;
import java.util.*;

public class ManejadorJSON {
    private static final String RUTA = "data/contactos.json";
    private static final String BACKUP = "data/contactos.backup.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardar(List<Contacto> lista) {
        File actual = new File(RUTA);
        if (actual.exists()) actual.renameTo(new File(BACKUP));

        try (Writer writer = new FileWriter(RUTA)) {
            gson.toJson(lista, writer);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<Contacto> cargar() {
        File f = new File(RUTA);
        if (!f.exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(RUTA)) {
            return gson.fromJson(reader, new TypeToken<List<Contacto>>(){}.getType());
        } catch (IOException e) { return new ArrayList<>(); }
    }
}
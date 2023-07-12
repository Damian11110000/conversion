import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Cambio {
    private static String url ="http://data.fixer.io/api/latest?access_key=3b910373936a299e850e9fb691b01b61";

    public static String[] obtenerCambio() {
        String respuesta = "";
        try {
            respuesta = peticionHttpGet(url);
            JSONObject objetoJson = new JSONObject(respuesta);
            JSONObject cambios = new JSONObject(objetoJson.get("rates").toString());
            return new String[] {cambios.get("MXN").toString(),cambios.get("USD").toString()};
        } catch (Exception e) {
            // Manejar excepción
            return  new String[] {"1.112839","1.112839"};
        }
    }

    private static String peticionHttpGet(String urlParaVisitar) throws Exception {
        // Esto es lo que vamos a devolver
        StringBuilder resultado = new StringBuilder();
        // Crear un objeto de tipo URL
        URL url = new URL(urlParaVisitar);
        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        return resultado.toString();
    }
}
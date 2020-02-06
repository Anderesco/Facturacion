package com.ejemplo.spring.facturacion.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ObtenerJSONURL 
{
	public static void main(String[] args) throws JSONException 
	{
        
		JSONParser parser = new JSONParser();

        try 
        {        
            URL url = new URL("http://localhost:8080/prueba-json-envio");
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
           
            String inputLine;
            
            //Leer cada linea del JSON
            while ((inputLine = in.readLine()) != null) 
            {              
                JSONArray arrayJson = (JSONArray) parser.parse(inputLine);
               
                System.out.println("Se ha conectado");
                System.out.println(inputLine);
                
                // Iteración de los datos enviados del JSON
                for (Object objeto : arrayJson) 
                {
                	System.out.println("objeto:" + objeto);
                    JSONObject objectorecibido =  (JSONObject) objeto;
                    
                    Long id = (Long) objectorecibido.get("id");
                    String nombre = (String) objectorecibido.get("nombreCliente");
                    String apellidoPaterno = (String) objectorecibido.get("apellidoPaterno");
                    String apellidoMaterno = (String) objectorecibido.get("apellidoMaterno");
                    String DNI = (String) objectorecibido.get("dni");
                    String RUC = (String) objectorecibido.get("ruc");
                    Double monto = (Double) objectorecibido.get("montototal");
                    String estado = (String) objectorecibido.get("estado");
                    String sede = (String) objectorecibido.get("sede");
                    
                    System.out.println("ID : " + id);
                    System.out.println("Cliente : " + nombre);
                    System.out.println("Apellido Paterno : " + apellidoPaterno);
                    System.out.println("Apellido Materno : " + apellidoMaterno);
                    System.out.println("DNI : " + DNI);
                    System.out.println("RUC : " + RUC);
                    System.out.println("Monto : " + monto);
                    System.out.println("Estado : " + estado);
                    System.out.println("Sede : " + sede);
                }
            }
            
            in.close();
        } 
        catch (FileNotFoundException e) { e.printStackTrace();} 
        catch (IOException e) { e.printStackTrace();} 
        catch (ParseException e) {e.printStackTrace();}  
    } 
}

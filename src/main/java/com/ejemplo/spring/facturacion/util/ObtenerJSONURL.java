package com.ejemplo.spring.facturacion.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ejemplo.spring.facturacion.bean.JSONRecibidoBean;
import com.ejemplo.spring.facturacion.bean.JSONRecibidoDetalleBean;

public class ObtenerJSONURL 
{
	JSONParser parser = new JSONParser();
	JSONRecibidoBean jsonRecibido = new JSONRecibidoBean();
	JSONRecibidoDetalleBean[] jsonDetalleArray;
	JSONRecibidoDetalleBean jsonDetalle;
	//List<JSONRecibidoDetalleBean> listaDetalle = new ArrayList<JSONRecibidoDetalleBean>();
	JSONObject objectorecibido;
	JSONObject objectorecibido2;
	
	public JSONRecibidoBean ObtenerJSON () {
		List<JSONRecibidoDetalleBean> listaDetalle = new ArrayList<JSONRecibidoDetalleBean>();
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
                    objectorecibido =  (JSONObject) objeto;
                    
                    jsonRecibido.setNombre((String) objectorecibido.get("nombreCliente"));
                    jsonRecibido.setApellidoPaterno((String) objectorecibido.get("apellidoPaterno"));
                    jsonRecibido.setApellidoMaterno((String) objectorecibido.get("apellidoMaterno"));
                    jsonRecibido.setDNI((String) objectorecibido.get("dni"));
                    jsonRecibido.setRUC((String) objectorecibido.get("ruc"));
                    jsonRecibido.setMonto((Double) objectorecibido.get("montototal"));
                    jsonRecibido.setEstado((String) objectorecibido.get("estado"));
                    jsonRecibido.setSede((String) objectorecibido.get("sede"));
                    jsonRecibido.setNumeroComprobante((Long) objectorecibido.get("numeroComprobante"));
                    
                    JSONArray detalleJson = (JSONArray) objectorecibido.get("detalle");

                    jsonDetalleArray = new JSONRecibidoDetalleBean[detalleJson.size()];
                    
                    System.out.println("Length: " + jsonDetalleArray.length);
                    Object[] objeto2 = new Object[jsonDetalleArray.length];
                    
                    for(int i = 0; i < jsonDetalleArray.length; i++)
                    {
                    	objeto2[i] = (Object) detalleJson.get(i);
                    	
                    	System.out.println("Objeto2: " + objeto2[i]);
                    	
                    	objectorecibido2 = (JSONObject) detalleJson.get(i);
                    	
                    	jsonDetalleArray[i] = new JSONRecibidoDetalleBean((String) objectorecibido2.get("nombreLibro"), 
                    													  (Long) objectorecibido2.get("cantidadLibro"), 
                    													  (Double) objectorecibido2.get("precioUnitario"));
                    	
                    	listaDetalle.add(jsonDetalleArray[i]);
                    } 
                    
                    jsonRecibido.setDetalle(listaDetalle);
                }
            }
            
            in.close();
        } 
        catch (FileNotFoundException e) { e.printStackTrace();} 
        catch (IOException e) { e.printStackTrace();} 
        catch (ParseException e) {e.printStackTrace();}
        
        //System.out.println("Dealle canidad: "+listaDetalle.size());
        //listaDetalle.clear();
        
        return jsonRecibido;
    }
	

}

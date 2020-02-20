package com.ejemplo.spring.facturacion.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.entity.Comprobante;
import com.ejemplo.spring.facturacion.util.HibernateUtil;

@Component
@Transactional
public class ComprobanteDao 
{
	public Integer guardarComprobante(Comprobante comprobante) 
	{
        Transaction transaction = null;
        Integer codigo = 0;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction(); 
            
            // Guarda el objeto Usuario
            codigo = (Integer) session.save(comprobante);
            
            // Realizar transaccion
            transaction.commit();    
            
        } 
        catch (Exception e) 
        {
        	/*
            if (transaction != null) 
                transaction.rollback();
            */
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        return codigo;
    }
    public List<Comprobante> mostrarComprobante() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) 
        {
            return session.createQuery("Select comprobante from Comprobante comprobante " +
            						   "inner join comprobante.cliente cliente" +
            						   "inner join comprobante.sede sede" 
            						   , Comprobante.class).list();
        }
    }
    
	public Integer actualizarComprobante(Integer IDActualizando)
    {    	
    	Transaction transaction = null;
    	Integer actualizandoEstado = 0;
    	Session session = HibernateUtil.getSessionFactoria().openSession();
    	System.out.println("Sesion:  " + session);
    			
        try {
        	
        	Object objeto = session.load(Comprobante.class, IDActualizando);
        	
        	Comprobante comprobante = (Comprobante) objeto;
			
        	transaction = session.beginTransaction();
        	comprobante.setEstadoComprobante("Terminado");
        	transaction.commit();
            
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
                transaction.rollback();
            
            e.printStackTrace();
        }
        
    	return actualizandoEstado;
    }
    
    public void eliminarComprobante(int id, Comprobante comprobante)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Elimina el objeto Usuario
            session.delete(convertir, comprobante);
            
            // Realizar transaccion
            transaction.commit();
            
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
                transaction.rollback();
            
            e.printStackTrace();
        }
    }
}

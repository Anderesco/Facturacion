package com.ejemplo.spring.facturacion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.entity.Comprobante;
import com.ejemplo.spring.facturacion.util.HibernateUtil;

@Component
public class ComprobanteDao 
{
	public void guardarComprobante(Comprobante comprobante) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Guarda el objeto Usuario
            session.save(comprobante);
            
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
    }
    public List<Comprobante> mostrarComprobante() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) 
        {
            return session.createQuery("from Comprobante", Comprobante.class).list();
        }
    }
    
    public void actualizarComprobante(int id, Comprobante comprobante)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Modifica el objeto Usuario
            session.update(convertir, comprobante);
            
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
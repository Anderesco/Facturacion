package com.ejemplo.spring.facturacion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.spring.facturacion.entity.Libro;
import com.ejemplo.spring.facturacion.util.HibernateUtil;

public class LibroDao 
{
	public void guardarLibro(Libro libro) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Guarda el objeto Usuario
            session.save(libro);
            
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
    public List<Libro> mostrarLibro() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) 
        {
            return session.createQuery("from libro", Libro.class).list();
        }
    }
    
    public void actualizarLibro(int id, Libro libro)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Modifica el objeto Usuario
            session.update(convertir, libro);
            
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
    
    public void eliminarLibro(int id, Libro libro)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Elimina el objeto Usuario
            session.delete(convertir, libro);
            
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
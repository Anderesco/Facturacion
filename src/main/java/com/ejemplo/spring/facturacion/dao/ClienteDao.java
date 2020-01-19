package com.ejemplo.spring.facturacion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.spring.facturacion.entity.Cliente;
import com.ejemplo.spring.facturacion.util.HibernateUtil;


public class ClienteDao 
{
	public void guardarCliente(Cliente cliente) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Guarda el objeto Usuario
            session.save(cliente);
            
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
    public List<Cliente> mostrarCliente() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) 
        {
            return session.createQuery("from cliente", Cliente.class).list();
        }
    }
    
    public void actualizarCliente(int id, Cliente cliente)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Modifica el objeto Usuario
            session.update(convertir, cliente);
            
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
    
    public void eliminarCLiente(int id, Cliente cliente)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Elimina el objeto Usuario
            session.delete(convertir, cliente);
            
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

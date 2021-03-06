package com.ejemplo.spring.facturacion.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.entity.Sede;
import com.ejemplo.spring.facturacion.util.HibernateUtil;

@Component
@Transactional
public class SedeDao 
{
	public Integer guardarSede(Sede sede) 
	{
        Transaction transaction = null;
        Integer codigo = 0;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Guarda el objeto Usuario
            codigo = (Integer) session.save(sede);
            
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
    public List<Sede> mostrarSede() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) 
        {
            return session.createQuery("from Sede", Sede.class).list();
        }
    }
    
    public void actualizarSede(Sede sede)
    {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Modifica el objeto Usuario
            session.update(sede);
            
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
    
    public void eliminarSede(int id, Sede sede)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Elimina el objeto Usuario
            session.delete(convertir, sede);
            
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

package com.ejemplo.spring.facturacion.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.entity.DetalleComprobante;
import com.ejemplo.spring.facturacion.util.HibernateUtil;

@Component
@Transactional
public class DetalleComprobanteDao 
{
	public void guardarDetalleComprobante(DetalleComprobante detalle) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Guarda el objeto Usuario
            session.save(detalle);
            
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
    public List<DetalleComprobante> mostrarDetalleComprobante() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) 
        {
            return session.createQuery("select det from DetalleComprobante det inner join det.libro libro ", DetalleComprobante.class).list();
        }
    }
    
    public void actualizarDetalleComprobante(int id, DetalleComprobante detalle)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Modifica el objeto Usuario
            session.update(convertir, detalle);
            
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
    
    public void eliminarDetalleComprobante(int id, DetalleComprobante detalle)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Elimina el objeto Usuario
            session.delete(convertir, detalle);
            
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

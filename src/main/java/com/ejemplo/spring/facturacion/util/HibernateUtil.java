package com.ejemplo.spring.facturacion.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ejemplo.spring.facturacion.entity.Cliente;
import com.ejemplo.spring.facturacion.entity.Comprobante;
import com.ejemplo.spring.facturacion.entity.DetalleComprobante;
import com.ejemplo.spring.facturacion.entity.Libro;
import com.ejemplo.spring.facturacion.entity.Sede;


public class HibernateUtil 
{
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactoria()
	{
		if(sessionFactory == null)
		{
			try
			{
				Configuration configuration = new Configuration();
				
				Properties ajustes = new Properties();
				
				ajustes.put(Environment.SHOW_SQL, "true");
				ajustes.put(Environment.URL, "jdbc:mysql://34.223.247.148:3306/facturacion?useSSL=false");
				ajustes.put(Environment.USER, "root");
				ajustes.put(Environment.PASS, "P@ssW0rd2017");
				ajustes.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				
				ajustes.put(Environment.SHOW_SQL, "true");
                ajustes.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //ajustes.put(Environment.HBM2DDL_AUTO, "create");
                
                configuration.setProperties(ajustes);
                configuration.addAnnotatedClass(Cliente.class);
                configuration.addAnnotatedClass(Comprobante.class);
                configuration.addAnnotatedClass(Sede.class);
                configuration.addAnnotatedClass(Libro.class);
                configuration.addAnnotatedClass(DetalleComprobante.class);
                
                ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
	}
}

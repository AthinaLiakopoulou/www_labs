package com.athina.Hib;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
//import javax.servlet.http.HttpSession;

/**
 * Hello world!
 *
 */
@WebServlet("/login")
public class tyr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
    
    
    	//System.out.println( "Hello World!" );
    	//One user = new One();
    	One user1 = new One();
    	//user1.setUsername(username);
    	//user.setPassword("1234");
    	//user.setUsername("Athina");
    	Configuration con = new Configuration().configure().addAnnotatedClass(One.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sf = con.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	
    	user1 = (One)session.get(One.class,username);
    	//System.out.println(user1.getUsername());
    	//System.out.println(user1.getPassword());
		if(user1!=null) {
			String password1=user1.getPassword();
			if(password1.equals(password)){
				//System.out.println(user1.getPassword());
		    //HttpSession session = request.getSession();
		    // session.setAttribute("username",username);
				response.sendRedirect("loginsuccess.jsp");
			}
		 else {
		 //   HttpSession session = request.getSession();
		    response.sendRedirect("failure.jsp");
		    //session.setAttribute("user", username);
		    //response.sendRedirect("login.jsp");
		}
		}
		 else {
			 //   HttpSession session = request.getSession();
			    response.sendRedirect("failure.jsp");
			    //session.setAttribute("user", username);
			    //response.sendRedirect("login.jsp");
			}
    	tx.commit();
    	
    	
    	//session.save (user);
    	
    	
    		
	}
}


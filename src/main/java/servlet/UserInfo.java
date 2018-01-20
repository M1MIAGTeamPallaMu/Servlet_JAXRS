package servlet;

import domain.Person;
import jpa.GenTestDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "userInfo" , urlPatterns={ "/UserInfo" })
public class UserInfo extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
        GenTestDAO genTestDAO = new GenTestDAO();
        Person user = new Person();
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("firstname"));
        user.setMail(request.getParameter("email"));
        genTestDAO.getTransaction().begin();
        genTestDAO.create(user);
        genTestDAO.getTransaction().commit();
        response .setContentType( "text/html" );
        PrintWriter out = response .getWriter();
        out.println( "<html>\n<body>\n" +
                "<h1>Recapitulatif des informations</h1>\n" +
                "<ul>\n" +
                " <li>Nom: "
                + request . getParameter ( "name" ) + "\n" +
                " <li>Prenom: "
                + request . getParameter ( "firstname" ) + "\n" +
                " <li>Email: "
                + request . getParameter ( "email" ) + "\n" +
                "</ul>\n" +
                "</body></html>" );
    }
}
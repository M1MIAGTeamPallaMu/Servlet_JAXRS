package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "userinfo" , urlPatterns={ "/userinfo" })
public class UserInfo extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
        response .setContentType( "text/html" );
        PrintWriter out = response .getWriter();
        out.println( "<html>\n<body>\n" +
                "<h1>Recapitulatif des informations</h1>\n" +
                "<ul>\n" +
                " <li>Nom: "
                + request . getParameter ( "name" ) + "\n" +
                " <li>Prenom: "
                + request . getParameter ( "firstname" ) + "\n" +
                " <li>Age: "
                + request . getParameter ( "age" ) + "\n" +
                "</ul>\n" +
                "</body></html>" );
    }
}

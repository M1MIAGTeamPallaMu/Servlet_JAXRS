package servlet;

import domain.Person;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.PersonDao;

@WebServlet(name = "userInfo", urlPatterns = {"/UserInfo"})
public class UserInfo extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    Person user = new Person();
    user.setName(request.getParameter("name"));
    user.setSurname(request.getParameter("firstname"));
    user.setMail(request.getParameter("email"));
    PersonDao personDao = new PersonDao();
    personDao.create(user);
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>\n<body>\n"
        + "<h1>Recapitulatif des informations</h1>\n"
        + "<ul>\n"
        + " <li>Nom: "
        + request.getParameter("name") + "\n"
        + " <li>Prenom: "
        + request.getParameter("firstname") + "\n"
        + " <li>Email: "
        + request.getParameter("email") + "\n"
        + "</ul>\n" + "</body></html>");
  }
}
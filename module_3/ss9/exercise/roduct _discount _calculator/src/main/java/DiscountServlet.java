import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double price = Double.parseDouble(request.getParameter("price"));
        double percent = Double.parseDouble(request.getParameter("percent"));
        String product = request.getParameter("product");

        double discountAmount = price * percent * 0.01;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description: "+ product+"</h1><br>");
        writer.println("<h1>Price Product: "+ (int)price+"</h1><br>");
        writer.println("<h1> Discount Percent: "+ (int)percent+"%</h1><br>");
        writer.println("<h1> DiscountAmount: "+ discountAmount+"</h1><br>");
        writer.println("</html>");
    }
}

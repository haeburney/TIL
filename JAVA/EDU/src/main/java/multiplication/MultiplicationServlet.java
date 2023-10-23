package multiplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultiplicationServlet
 */
@WebServlet("/MultiplicationServlet")
public class MultiplicationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiplicationServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("number") == null) {
            request.setCharacterEncoding("euc-kr");
            response.setCharacterEncoding("euc-kr");
            response.setContentType("text/html; charset=EUC-KR");

            PrintWriter out = response.getWriter();
            out.print("<html><head><title>title</title>");
            out.print("<style>table, tr, td{ border : 1px solid black; } ");
            out.print("table { width : 80%;  border-collapse: collapse; } ");
            out.print(".title{background-color: lightgray;}</style>");
            out.print("</head>");
            out.print("<body>");
            out.print("<table>");
            out.print("<tr><td style=\"background-color: grey;\"></td><td class=\"title\">1 &nbsp;</td><td class=\"title\">2 &nbsp;</td><td class=\"title\">3 &nbsp;</td class=\"title\"><td class=\"title\">4 &nbsp;</td><td class=\"title\">5 &nbsp;</td class=\"title\"><td class=\"title\">6 &nbsp;</td><td class=\"title\">7 &nbsp;</td><td class=\"title\">8 &nbsp;</td><td class=\"title\">9 &nbsp;</td></tr>");
            // TODO for 문 2개로 tr, td 를 자동 생성할수 있을까???

            for (int i = 1; i <= 9; i++) {
                // tr 생성
                out.print("<tr><td class=\"title\">" + i + "</td>");
                for (int j = 1; j <= 9; j++) {
                    // td 생성
                    out.print("<td>" + (i * j) + "</td>");
                }
                out.print("</tr>");
            }

            out.print("</table>");
            out.print("<br/><form action=\"/lecture/MultiplicationServlet\" name=\"googoodan\"><input type=\"text\" name=\"number\"/><input type=\"submit\" value=\"전송\" onclick=\"viewMultiplication()\"/></form>");
            out.print("<script> console.log(\"하이?\");");
            out.print(" function viewMultiplication(){");
            out.print("let num = document.getElementsByName(\"number\")[0].value; console.log(num);");
            out.print("if(isNaN(num)){ alert(\"숫자를 입력하십시오\");}");
            out.print("}");
            out.print("");
            out.print("</script>");
            out.print("</body>");
            out.print("</html>");

        } else {

            int number = Integer.parseInt(request.getParameter("number"));
            System.out.println(number);

            PrintWriter out = response.getWriter();
            out.print("<html><head><title>title</title>");
            out.print("<style>table, tr, td{ border : 1px solid black; } ");
            out.print("table { width : 80%;  border-collapse: collapse; } ");
            out.print(".title{background-color: lightgray;}</style>");
            out.print("</head>");
            out.print("<body>");
            out.print("<table>");
            out.print("<tr><td style=\"background-color: grey;\"></td><td class=\"title\">1 &nbsp;</td><td class=\"title\">2 &nbsp;</td><td class=\"title\">3 &nbsp;</td class=\"title\"><td class=\"title\">4 &nbsp;</td><td class=\"title\">5 &nbsp;</td class=\"title\"><td class=\"title\">6 &nbsp;</td><td class=\"title\">7 &nbsp;</td><td class=\"title\">8 &nbsp;</td><td class=\"title\">9 &nbsp;</td></tr>");

            out.print("<tr><td class=\"title\">" + number + "</td>");
            for (int i = 1; i < 10; i++) {
                out.print("<td>" + (number * i) + "</td>");
            }
            out.print("</tr>");


            out.print("</table>");
            out.print("<br/><form action=\"/lecture/MultiplicationServlet\" name=\"googoodan\"><input type=\"text\" name=\"number\"/><input type=\"submit\" value=\"전송\" onclick=\"viewMultiplication()\"/></form>");
            out.print("<script> console.log(\"하이?\");");
            out.print(" function viewMultiplication(){");
            out.print("let num = document.getElementsByName(\"number\")[0].value; console.log(num);");
            out.print("if(isNaN(num)){ alert(\"숫자를 입력하십시오\");}");
            out.print("}");
            out.print("");
            out.print("</script>");
            out.print("</body>");
            out.print("</html>");


        }

    }

}

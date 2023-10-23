package board;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.beans.User;

/**
 * 게시판 서블릿
 */
@WebServlet("/board/BoardServlet/*")
public class BoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /** 게시판 컨트롤러 */
    private BoardController boardController = new BoardController();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
    }


    /**
     * 서비스
     * 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 설정
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");

        String pathInfo = request.getPathInfo();
        String methodName = "";

        if (pathInfo != null) {
            methodName = pathInfo.substring(1);
        } else {
            methodName = "viewHeader";
        }



        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        String boardId = request.getParameter("boardId");
        String boardName = request.getParameter("boardName");
        if (boardId != null) {
            // Board board = boardController.
            System.out.println(boardId);
        }
        if (boardName != null) {
            System.out.println(boardName);
        }

        try {
            Method method = boardController.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String result = (String) method.invoke(boardController, request, response);
            System.out.println("[BoardServlet 74] boardController.getClass() :" + boardController.getClass());
            System.out.println("[BoardServlet 75] result :" + result);



            if (result != null && !result.equals("")) {
                System.out.println("하이");
                if ((!result.equals("/login") || !result.equals("/WEB-INF/jsp/board/viewLogin.jsp")) && user == null) {
                    System.out.println("하이2");
                    request.getRequestDispatcher("/WEB-INF/jsp/board/viewLogin.jsp").forward(request, response);
                } else if (result.equals("/WEB-INF/jsp/board/header.jsp")) {
                    System.out.println("일치");
                    request.getRequestDispatcher(result).include(request, response);
                } else {
                    System.out.println("하이4");
                    request.getRequestDispatcher(result).forward(request, response);
                }
            } else {
                response.sendRedirect("viewBoardPosts");
            }

            response.getWriter().close();

        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

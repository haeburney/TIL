package board;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.beans.Board;
import board.beans.BoardPost;
import board.beans.User;

/**
 * 게시판 컨트롤러
 */
public class BoardController {

    /** 게시판 서비스 */
    private BoardService boardService = new MariaBoardService();
    /** 회원 서비스 */
    private UserService userService = new MariaUserService();
    /** 게시판 정보 서비스 */
    private BoardInfoService boardInfoService = new MariaBoardInfoService();

    /**
     * 인스턴스 생성
     */
    public BoardController() {
        Properties properties = new Properties();
        InputStream is = this.getClass().getResourceAsStream("/resources/board.properties");

        try {
            properties.load(is);

            String userServiceClassName = properties.getProperty("service.userService");
            String boardServiceClassName = properties.getProperty("service.boardService");

            boardService = (BoardService) Class.forName(boardServiceClassName).newInstance();
            userService = (UserService) Class.forName(userServiceClassName).newInstance();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 글 상세 보기
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String viewBoardDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String boardId = request.getParameter("boardId");
        String userId = request.getParameter("userId");
        System.out.println("id :" + id + ", boardId:" + boardId);

        if (id != null && boardId != null && userId != null) {
            if (!id.equals("") && !boardId.equals("") && !userId.equals("")) {
                try {

                    long longId = Long.valueOf(request.getParameter("id"));
                    long longBoardId = Long.valueOf(request.getParameter("boardId"));
                    long longUserId = Long.valueOf(userId);
                    System.out.println(longId + ", " + longBoardId);
                    Board board = boardInfoService.getBoard(longBoardId);

                    // 관리자 권한
                    User user = userService.getUserInfo(longUserId);
                    System.out.println(user);
                    boolean isAdmin = boardService.isAdmin(board, user);
                    System.out.println(isAdmin);


                    BoardPost resultboardpost = boardService.getBoardPost(board, longId);
                    request.setAttribute("boardpost", resultboardpost);
                    request.setAttribute("board", board);
                    request.setAttribute("isAdmin", isAdmin);
                    System.out.println(board);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }



        return "/WEB-INF/jsp/board/viewBoardDetail.jsp";
    }

    /**
     * 글 전체 목록
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String viewBoardPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> conditionMap = new HashMap<String, Object>();
        String subject = request.getParameter("subject");

        conditionMap.put("subject", subject);
        // System.out.println(conditionMap.get("subject"));
        String boardId = request.getParameter("boardId");
        // System.out.println("boardId :" + boardId);

        if (boardId != null && !boardId.equals("")) {
            try {
                Long longBoardId = Long.valueOf(boardId);
                Board board = boardInfoService.getBoard(longBoardId);
                List<BoardPost> boardPostList = boardService.getAllBoardPosts(board, conditionMap);
                request.setAttribute("boardPosts", boardPostList);
                request.setAttribute("board", board);
                // System.out.println(boardPostList);

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        } else {
            Board board = new Board();
            List<BoardPost> boardPostList = boardService.getAllBoardPosts(board, conditionMap);
            request.setAttribute("boardPosts", boardPostList);
            System.out.println(boardPostList);
            // request.setAttribute("board", board);
        }

        return "/WEB-INF/jsp/board/viewBoardPosts.jsp";
    }

    /**
     * 새 게시물 작성
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String viewCreateBoardPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        return "/WEB-INF/jsp/board/viewCreateBoardPost.jsp";
    }

    /**
     * 로그인 화면
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String viewLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/WEB-INF/jsp/board/viewLogin.jsp";
    }

    /**
     * 글 생성 처리
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String createBoardPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String id = request.getParameter("creatorId");
        String boardId = request.getParameter("boardId");

        System.out.println(id);
        BoardPost boardPost = boardService.newBoardPost(title, content, id);

        if (boardId != null) {
            try {
                Long longBoardId = Long.valueOf(boardId);
                Board board = boardInfoService.getBoard(longBoardId);
                BoardPost postResult = boardService.createBoardPost(board, boardPost); // db insert
                System.out.println(postResult);

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 로그인
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        User loginUser = userService.getUser(userName, userPassword);
        if (loginUser != null) {
            HttpSession session = request.getSession();
            session = request.getSession();
            session.setAttribute("user", loginUser);
            // System.out.println("login User :" + loginUser);
        } else {
            System.out.println("로그인 안 됨");
        }
        return null;
    }


    /**
     * 헤더 보기
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String viewHeader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Board> boardList = boardInfoService.getAllBoard();
        if (boardList != null) {
            request.setAttribute("boardList", boardList);
            // System.out.println("[BoardControll 228] " + boardList);
        }

        return "/WEB-INF/jsp/board/header.jsp";
    }

    /**
     * 삭제하기
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String deleteBoardPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String boardId = request.getParameter("board");
        String boardPostId = request.getParameter("id");
        String userId = request.getParameter("userId");
        // Board board = new Board();
        System.out.println(boardId + " " + boardPostId + " " + userId);

        if (boardId != null && boardPostId != null && userId != null) {
            if (!boardId.equals("") && !boardPostId.equals("") && !userId.equals("")) {
                Long longBoardId = Long.valueOf(boardId);
                Long longBoardPostId = Long.valueOf(boardPostId);
                Long longUserId = Long.valueOf(userId);

                Board board = new Board(longBoardId, null, null, true, null);
                User user = new User(longUserId, null, null, null, null, 0, null);
                BoardPost boardPost = boardService.deleteBoardPost(board, longBoardPostId, user);

            }
        }

        return null;
    }
}

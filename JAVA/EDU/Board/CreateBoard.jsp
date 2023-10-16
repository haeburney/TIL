<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.Connection, java.sql.DriverManager, java.sql.SQLException, java.sql.Statement, java.sql.ResultSet"
    import="java.util.List, java.util.ArrayList,net.innofactory.lecture.hkim.board.beans.BoardPost"
    import="java.sql.Timestamp, java.text.ParseException, java.text.SimpleDateFormat, java.util.Date" 
    import="java.sql.PreparedStatement"
   %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       
    <%! 
    private Connection getConnection() {	// 마리아DB 연결
        Connection connection = null;
        String jdbcUrl = "jdbc:mariadb://127.0.0.1:3306/mysql"; // 마리아DB 연결 URL
        String username = "root";
        String password = "1234";
        
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 마리아DB JDBC 드라이버 클래스
            connection = DriverManager.getConnection(jdbcUrl, username, password);
         	if(connection!=null){
         	    System.out.println("연결 성공");
         	}    
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    private BoardPost newBoardPost(HttpServletRequest request){		// boardpost 객체 생성
        try{	// 한글 깨지지 않게 설정
      	  request.setCharacterEncoding("UTF-8");      
        } catch(Exception e){
            e.printStackTrace();
        }
        
        BoardPost boardPost = new BoardPost();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        boardPost.setSubject(title);
        boardPost.setContent(content);
        boardPost.setCreatorFullName(writer);
        boardPost.setCreateDate(timestamp);
        return boardPost;
    }

    private BoardPost createBoardPost(BoardPost boardPost){		// DB에 boardpost data 삽입
        Connection connection = getConnection();
        
        if(connection == null){
            return null;
        }
        
        String insertQuery="INSERT INTO boardpost (subject, content, creatorFullName, createDate) VALUES(?, ?, ?, ?)";
        String selectQuery="select * from boardpost where id = LAST_INSERT_ID()";
        PreparedStatement pstmt = null;
        PreparedStatement selectedStatement = null;
        ResultSet rs = null;
        
        try{
       		pstmt = connection.prepareStatement(insertQuery);
        	pstmt.setString(1, boardPost.getSubject());
        	pstmt.setString(2, boardPost.getContent());
        	pstmt.setString(3, boardPost.getCreatorFullName());
        	pstmt.setTimestamp(4, boardPost.getCreateDate());
        	
        	int num = pstmt.executeUpdate();
        	
        	if(num>0){
        	    selectedStatement = connection.prepareStatement(selectQuery);
            	rs = selectedStatement.executeQuery();
            	if(rs.next()){
            	    boardPost.setId(rs.getInt(1));
            	    boardPost.setSubject(rs.getString(2));
            	    boardPost.setContent(rs.getString(3));
            	    boardPost.setCreatorFullName(rs.getString(4));
            	    boardPost.setCreateDate(rs.getTimestamp(5));
            	} else {
            	    System.out.println("검색항목 없음");
            	}
        	}
      
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
           		if(connection != null) connection.close();   
            } catch(SQLException e){
                e.printStackTrace();
            }
            try{
           		if(pstmt != null) pstmt.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
            try{
           		if(selectedStatement != null) selectedStatement.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
            try{
           		if(rs != null) rs.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
         	
        }
        
        return boardPost;
    }

%> 

<%
	BoardPost boardPost = newBoardPost(request);		// 전달 받은 값 boardpost 생성
	BoardPost postResult = createBoardPost(boardPost);	// db insert
	response.sendRedirect("viewBoardPosts.jsp");		// redirect 이동
%>
   
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.Connection, java.sql.DriverManager, java.sql.SQLException, java.sql.Statement, java.sql.ResultSet"
    import="java.util.List, java.util.ArrayList,net.innofactory.lecture.hkim.board.beans.BoardPost"
    import="java.sql.Timestamp, java.text.ParseException, java.text.SimpleDateFormat, java.util.Date" 
    %>
    
    <%
    List<BoardPost> boardPosts = new ArrayList<BoardPost>(); 
    
   // String subject = request.getParameter("subject");
   String subject = "제목1";
    
    if(subject == null){
        out.println("subject 값이 비어있음");
    }
    
    String query = "SELECT * from boardpost where subject like '%" + subject + "%'";
    
    out.println("하이");
    
    Connection connection = null;
    Statement statement = null;
    
    try{
    	connection = getConnection();
    	statement = connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(query);
    	while(resultSet.next()){
    		long id = resultSet.getInt("id");
    		String postSubject = resultSet.getString("subject");
    		String content = resultSet.getString("content");
    		String creator = resultSet.getString("creatorFullName");
    		String dateString = resultSet.getString("createDate");
    		out.println(postSubject);
    		
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    		Timestamp createDate = null;
            
            try {
                Date parsedDate = dateFormat.parse(dateString); // 문자열을 Date로 파싱
                createDate = new Timestamp(parsedDate.getTime()); // Date를 Timestamp로 변환
                System.out.println("Timestamp: " + createDate);
	    		boardPosts.add(new BoardPost(id, postSubject,content, creator, createDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
    		
    		
    	}
    	resultSet.close();
    	statement.close();
    	connection.close();
    } catch (SQLException e){
    	e.printStackTrace();
    } finally{
    	if(statement != null) statement.close();
    	if (connection != null) connection.close();
    }
    
    %>
    
    <%! 
    private Connection getConnection() {
        String jdbcUrl = "jdbc:mariadb://127.0.0.1:3306/mysql"; // 마리아DB 연결 URL
        String username = "root";
        String password = "1234";
        Connection connection = null;
		System.out.println(username + " / "+password);
        
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
        } finally{
            
        }

        return connection;
    }
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, tr, td{
		border : 1px solid black;
	}
	
	table {
		width : 80%;
		border-collapse: collapse;
	}
</style>
</head>
<body>



	<form name="searchForm">
		<input type="text" name="subject"/>
		<input type="button" value="검색" onclick="searchBoardPosts()"/>
	</form>
	<br/>
	
	<table>
		<tr>
			<th>ID</th><th>제목</th><th>작성자</th><th>작성일</th>
		</tr>
	</table>
	<br/>
	
	<a href="/board/viewCreateBoardPost.jsp">게시물 작성</a>
	
	<script>
		function searchBoardPosts() {
			console.log("클릭");
			let subject = document.getElementsByName("subject")[0].value;
			console.log(subject);
			
			
		}
		
	</script>
</body>
</html>

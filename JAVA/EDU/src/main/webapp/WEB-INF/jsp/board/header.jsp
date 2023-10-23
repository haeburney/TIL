<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,board.beans.Board, board.MariaBoardInfoService, board.BoardInfoService"%>


<%!/** 게시판 정보 인터페이스 */
    private BoardInfoService boardInfoService = new MariaBoardInfoService();%>

<%
/** 게시판 모든 메뉴 가져오기 */
List<Board> boardList = boardInfoService.getAllBoard();
if (boardList != null) {
    for (Board item : boardList) {
        out.print("<span class=\"boardTitle\" id=\"" + item.getId() + "\">" + item.getTitle() + "</span> | ");
    }
}
%>
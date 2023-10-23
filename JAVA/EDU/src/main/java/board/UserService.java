package board;

import board.beans.User;

/**
 * 사용자 서비스 인터페이스
 */
public interface UserService {

    /**
     * 로그인 하기
     * 
     * @param request
     * @return
     */
    User getUser(String userName, String userPassword);


    /**
     * 회원 정보 가져오기
     * 
     * @param userName
     * @return
     */
    User getUserInfo(long userId);
}

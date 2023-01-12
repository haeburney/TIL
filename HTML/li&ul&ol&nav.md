
## li 태그

list : 목록
<br><br><br><br><br>

## ul 태그

unordered list : 순서가 정해지지 않은 목록
<br><br><br><br><br>

## ol 태그

ordered list : 순서가 정해진 목록

```
<ol>
  <li>20230112</li>
  <li>카트라이드 : 드리프트</li>
  <li>출시</li>
</ol>

<ul>
  <li>20230112</li>
  <li>카트라이드 : 드리프트</li>
  <li>출시</li>
</ul> 
```
<br><br><br><br><br>  
  
## nav 태그

: 다른 페이지 또는 현재 페이지의 다른 부분과 연결되는 네비게이션 링크 (navigation links)들의 집합을 정의할 때 사용한다.


예) 메뉴, 목차, 인덱스 등이 있다.

```
 <nav className={`${style.navbar}`}>
                <Link to='/' className={`${style.navbar-logo}`}>
                    Home
                </Link>

                <ul>
                    <li className={`${style.nav-item}`}>
                        <Link to='/'>
                            액션
                        </Link>
                    </li>
                    <li className={`${style.nav-item}`}>
                        <Link to='/'>
                            로맨스
                        </Link>
                    </li>
                    <li className={`${style.nav-item}`}>
                        <Link to='/'>
                            sf
                        </Link>
                    </li>
                    <li className={`${style.nav-item}`}>
                        <Link to='/'>
                            애니메이션
                        </Link>
                    </li>
                </ul>
            </nav>  
```  
<br><br><br><br><br>  
  
position : fixed → 최상위 브라우저 창을 기준으로 절대 위치를 지정

position : sticky → 부모 태그의 크기를 기준으로 절대 위치를 지정
  

# 깃허브에 프로젝트 올리기 (처음)

<br>
1. Git 설치
<br><br><br>
2. GitHub에 새 저장소 생성
<br><br><br>
3. 생성된 저장소의 주소 기억해두기
<br><br><br>
4. 업로드 하고 싶은 프로젝트의 폴더를 마우스 우클릭 > Git Bash Here
<br><br>

![image](https://user-images.githubusercontent.com/76997276/211202859-100b14e7-6617-4075-bd86-b432ef7567ab.png)
<br><br><br><br><br>
5. 초기 설정해주기

```
git config --global user.name "유저 이름"

git config --global user.email "유저 이메일"
```
<br><br><br>
6. 파일 준비

```
git init // .git 파일 생성

git add . // 선택한 프로젝트 폴더 내의 모든 파일 관리 
// 특정 파일만 하고 싶다면 ex) git add a.txt 으로 구체적으로 써주기

git status // 상태 확인

git commit -m "주석" // 커밋
```
<br><br><br>
7. 업로드하기

```
git remote add origin {위 3번에서 저장한 깃허브 저장소 주소}

git push -u origin master
```
<br><br><br>
8. 프로젝트 업로드 완료
<br><br><br><br><br><br><br><br><br>

# 깃 수정 파일 업데이트 방법 ( 너무 간.단.)

```
git add . 

git status

git commit -m "파일 업데이트 메세지"

git push origin master
```
<br><br><br>

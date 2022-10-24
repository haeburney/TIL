## String.prototype.repeat()
repeat() 메서드는 문자열을 주어진 횟수만큼 반복해 붙인 새로운 문자열을 반환합니다.

```
const array = ['1', '2', '3', '4', '5'];

for(var i = 0; i < array.length; i++){
    console.log(`${array[i].repeat(i+1)}\n`);
}


//  1
//  22
//  333
//  4444
//  55555
```
<br><br><br><br>

### 응용 문제
**수박수박수박수박수박수?** <br>
https://school.programmers.co.kr/learn/courses/30/lessons/12922?language=javascript
```
function solution(n) {
    
    return '수박'.repeat(n/2) + (n % 2 ===1? '수':'');
}
```

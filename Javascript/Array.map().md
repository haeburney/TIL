## map()
map() 메서드는 배열 내의 모든 요소 각각에 대하여 주어진 함수를 호출한 결과를 모아 새로운 배열을 반환합니다.

**Array.prototype.map ( callbackfn [ , thisArg ] )**


```
const array = [1, 3, 5, 7];
const map = array.map(x => x * 3);

console.log(map);   //  [3, 9, 15, 21]
```

<br><br><br>

## 어디서 나와서 공부한거야? 
### 자연수 뒤집어 배열로 만들기 
https://school.programmers.co.kr/learn/courses/30/lessons/12932

```
function solution(n) {
    var answer = (n + '').split('').reverse().map(o => parseInt (o));
    
    return answer;
}
```


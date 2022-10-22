## join() 메서드는 배열의 모든 요소를 연결해 하나의 문자열로 만듭니다.

### 기본 설명
```
const array = ['Black','Pink','In','Your','Area'];

console.log(array.join());    //  Black,Pink,In,Your,Area
console.log(array.join(''));  //  BlackPinkInYourArea
console.log(array.join('-')); //  Black-Pink-In-Your-Area
```

<br><br><br>

### join()*1 -> 숫자로 변경 가능 
```
const array = [1, 2, 3, 4, 5];
const num = array.join('')*1;

console.log(num)          //  12345
console.log(isNaN(num))   //  false
```

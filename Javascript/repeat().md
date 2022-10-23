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

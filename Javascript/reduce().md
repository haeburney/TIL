## reduce() 합계 구하기 

```
const array = [1, 2, 3, 4, 5];

const result = array.reduce(function add(sum, currValue){
    return sum += currValue;
})

console.log(result)   //  15
```
<br><br><br>
## reduceRight()로 합하기
reduceRight()는 오른쪽부터 순서대로 더하는 것이다. 
<br>
```
const array = ['w', 'm', 'h'];

const result1 = array.reduce(function add(sum, currValue){
    return sum += currValue;
})

console.log(result1)  //  'wmh'

const result2 = array.reduceRight(function add(sum, currValue){
    return sum+=currValue;
})

console.log(result2)  //  'hmw'
```

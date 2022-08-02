## 생성 

```
import java.io.IOException;
import java.math.BigInteger;

public class test {
	public static void main(String args[]) throws IOException {
		BigInteger bigInteger1 = new BigInteger("1213");
		BigInteger bigInteger2 = BigInteger.valueOf(809);
		
		System.out.println(bigInteger1 + " " + bigInteger2);
	}
}
```
<br>

## 연산
```
import java.io.IOException;
import java.math.BigInteger;

public class test {
	public static void main(String args[]) throws IOException {
		BigInteger bigInteger1 = new BigInteger("10");
		BigInteger bigInteger2 = BigInteger.valueOf(2);
		
		System.out.println(bigInteger1.add(bigInteger2));
		System.out.println(bigInteger1.subtract(bigInteger2));
		System.out.println(bigInteger1.multiply(bigInteger2));
		System.out.println(bigInteger1.divide(bigInteger2));
		System.out.println(bigInteger1.mod(bigInteger2));
	}
}
```
<br>

## 비교 

```
import java.io.IOException;
import java.math.BigInteger;

public class test {
	public static void main(String args[]) throws IOException {
		BigInteger bigInteger1 = new BigInteger("10");
		BigInteger bigInteger2 = BigInteger.valueOf(2);
		
		int compare = bigInteger1.compareTo(bigInteger2);
		System.out.println("10 과 2 비교 : "+ compare + " (파라미터로 전달되는 값보다 크기 때문에 1 출력)");
		
		
		compare = bigInteger1.compareTo(BigInteger.TEN);
		System.out.println("10 과 2 비교 : "+ compare + " (같으면 0 출력)");
		
		compare =bigInteger2.compareTo(bigInteger1);
		System.out.println("10 과 2 비교 : "+ compare + " (파라미터로 전달되는 값보다 작기 때문에 -1 출력)");
	}
}
```

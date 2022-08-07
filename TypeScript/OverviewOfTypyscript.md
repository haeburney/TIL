런타임 에러는 곧 실제 유저들이 만나게 되는 에러이다. <br>
그니까 최대한 피해야하는 에러인데 이게 자바스크립트의 문제점이라고 볼 수 있는거지<br><br><br>

## 타입스크립이란?
타입스크립은 프로그래밍 언어야
strongly typed(강타입) 프로그래밍 언어야
타입스크립트의 경우에는 작성한 코드가 자바스크립트로 변환돼
Node.js는 타입스크립트 자바스크립트 양쪽 다 이해할 수 있어
그리고~~
타입스크립트는 개발자가 멍청한 짓을 하지 않게 보호해주는 역할을 해
#### 그런데 여기서 질문은!! 타입스크립트가 어떻게 우릴 보호해주냐는거지
타입스크립트가 그저 코드를 자바스크립트로 변환해줄 뿐이라면 우릴 어떻게 보호해준다는 걸까?
(컴파일은 그저 작성한 타입스크립트 코드를 일반적인 자바스크립트로 바꿔주는거야)
타입스크립트가 제공하는 보호장치는 타입스크립트 코드가 자바스크립트로 변환되기 전에 발생해
즉 타입스크립트가 먼저 우리의 코드를 확인한 다음에 
변환된 자바스크립트 안에서 바보같은 실수가 일어나지 않게 확인을 해줘
그래서!! 타입스크립트 코드에 에러가 있으면 그 코드는 자바스크립트로 컴파일되지 않아
(오 신기해!!)
타입스크립트가 에러가 발생할 것 같은 코드를 감지하면 자바스크립트로 아예 컴파일되지 않아
(타입스크립트는 자바스크립트랑 문법이 얼마나 다를까? 얼마나 비슷할까 궁금!)
만약 타입스크립트가 성공적으로 컴파일돼서 자바스크립트 코드를 주면 
타입스크립트 코드도 제대로 작성된거고 데이터 타입에도 문제가 없었다는 뜻이야
자바스크립트 코드에 버그가 전혀 없다는 뜻이지

![image](https://user-images.githubusercontent.com/76997276/175075242-081ae328-5c96-4636-8007-8f28ae82baa6.png)
이게 타입스크립트 언어야! 
(궁금한게 생겼다 그럼 자바스크립트에서 타입스크립트로 변환할 때 컴퓨터는 피로도를 전혀 안느끼나?) 

![image](https://user-images.githubusercontent.com/76997276/175075766-71fabcaa-545b-4745-959d-12c55a10921b.png)
![image](https://user-images.githubusercontent.com/76997276/175075925-970ea146-c28f-42d6-b32f-65a727bea791.png)
에러 표시를 나타내어줬어!
타입스크립트는 이런 실수로부터 나를 보호해주는거야

![image](https://user-images.githubusercontent.com/76997276/175077043-4bf50a80-f15d-44c6-84e0-c563b4125632.png)
<img src="https://user-images.githubusercontent.com/76997276/175077277-f504a4cf-d312-42ba-9291-9d762cc0a603.png" width=500>

여기엔 두 가지 보호 장치가 있어
① 타입스크립트한테 a와 b가 숫자여야만 한다는 걸 알려줄 수 있어 -> *데이터의 타입*
② 입력 값이 2개기 때문에 -> *입력값의 개수*

이런 보호장치가 생기는 이유는 타입 추론 때문이야
(앞으로 자세히 알게 될거야!!)


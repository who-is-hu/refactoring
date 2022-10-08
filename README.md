# Refactoring

인프런 리팩토링 강의(백기선) 정리하기

### 냄새2 - 중복코드
의도 : 어떤것을 하겠다고 술술 읽히는 코드
구현 : 의도를 수행하기 위한 절차들이 나열된 코드 (읽기힘듬)

구현을 숨기고 의도를 보여주게 => 구현을 함수로 추출하여 이름을 잘 붙히면 됨  
서비스 로직의 코드는 의도를 보여주고 구현은 도메인 객체로 숨겨야 한다고 나는 생각한다.

### 냄새3 - 긴 함수
<details>
<summary>매개변수 객체 만들기</summary>

- 같은 매개변수가 여러 메서드에 걸쳐 나타나면 묶은 자료구조만들기
- 객체에서 파생되는 필드들이 따로따로 돌아다닐때 객체 전체를 넘겨주기
  - 이때 각 함수가 객체전체에 의존하는게 맞는가, 필드에만 의존하는게 맞는가 고민을 해봐야함
</details>

<details>
<summary>함수를 명령으로 바꾸기</summary>

- 함수분리를 먼저해보고 그래도 위치가 이상한것같으면 함수를 객체로 싸서 분리하는 방법
- 그러면 클래스가 발전하면서 추후에 확장하기 좋은 구조가 될 수 있음
- 자연스럽게 SRP에도 근접하게 됨
</details>

<details>
<summary>조건문 분해하기</summary>

- 조건문의 조건 자체가 복잡해지는 경우
- 분기를 타게 되면서 코드르 이해하기 힘들어지는 경우
- => 함수 추출로 뽑아내면서 의도만 비추게  
- 이렇게 리팩터링하다보니까 다른 냄새들이 보여서 엄청좋은 듯
</details>

<details>
<summary>반복문 쪼개기</summary>

- 하나의 반복문에서 여러개 작업을 하는 경우 (성능적으로는 이게 좋긴함)
- 정말 성능적 병목이 아니라면 반복문을 작업마다 쪼개는게 좋고 (성능 문제가되면 다시 합치는게 나음)
- 루프를 쪼개고 함수추출해서 구현을 숨기기
</details>

<details>
<summary>조건문을 다형성으로 바꾸기</summary>

- 타입별로 공통부분이 있고 달라지는 부분이 복잡한 분기문에 적용할 수 있음
- 회사 플젝에 적용할 곳이 굉장히 많음
</details>

### 냄새4 - 긴 매개변수 목록
매개변수가 많을 수록 함수의 역할을 이해하기 어려워짐  
의존성이 많다는것은 많은일을 하고있따는 것이기 때문

<details>
<summary>매개변수를 질의 함수로 바꾸기</summary>

- 어떤 매개변수를 다른 매개변수로 알아낼수 있으면 "중복"으로 생각하고 중복제거하기
- 매개변수를 줄이면서 함수 내부에서 새로운 의존성이 생긴다면 고것은 고민해보아야함
</details>

<details>
<summary>flag 매개변수 없애기</summary>

- 보통 함수 내부에 분기를 타게 만듦으로 지양하는게 좋음
- 
</details>

### 냄새6 - 가변 데이터
사이드 이펙트 발생하기 쉬움으로 줄이는 것이 좋음

<details>
<summary>매개변수를 질의 함수로 바꾸기</summary>

- 원본에서 파생되는 값이 따로 변수로 있을때 원본이 가변데이터라면 어딘가에서 파생변수만 바꿔버리거나/안바꿔버려서 기대에 안맞는 결과를 가져올 수 있음
- 원본이 불변값이라면 무방함
</details>

<details>
<summary>여러함수를 변환 함수로 묶기</summary>

- 파생된 값을 만드는 함수가 여러곳에서 반복된다면 새로운 데이터타입을 만들고 그 데이터타입이 파생된 값을 가지고 있게 모을 수 있음
</details>

<details>
<summary>레퍼런스를 값 객체로 바꾸기</summary>

- 객체 내부의 변경을 전파하고 싶은것이 아니라면 vo를 만들어서 불변객체로 바꾸기
- side effect 줄이는방법
</details>

### 냄새7 - 뒤엉킨 변경
응집도 낮음: 
각자 다른 이유로 변경되는 코드들이 모여있음

- 절차에서 다른 일을하는것이 보이면 나누고 함수로 분리하기
- 문맥(클래스) 의 변수보다 외부의 것을 많이 쓰는 함수라면 옮기는 것을 고려해보기
- 새로운 문맥이 필요해진다면 함수를 모아 새로운 문맥 만들기
- 어디있을지 너무 심히 고민된다면 그대로 두어도 괜찮을 수도 있음

### 냄새8 - 산탄총 수술
결합도 높음:
하나를 수정하려면 여러곳을 수정해야함

<details>
<summary>인라인으로 함수 없애기</summary>

- 함수 이름보다 본문이 의도를 더 잘나타낼때(혹은 뽑아도 의도가 보이는 수준이 비ㄷㅁ할때)
- 합쳐놓고 다시 분리하기 위해서 코드를 모으기
- 근데 살짝 반대의견인게 해석하기 비슷해도 변경의 여지가 있거나 여러곳에서 쓰이면 함수가 맞다고 생각함 
</details>

<details>
<summary>인라인으로 클래스 없애기</summary>

- 클래스를 나누다가 존재 이유가 빈약해지는 클래스가 생길때 다른곳에 합칠수 있다.

</details>

### 냄새9 - 기능 편애

함수가 여러가지 기능에 욕심을 내서 하는일이 많아질때

### 냄새10 - 데이터 뭉치

같이 다니는 매개변수는 묶어버리기

### 냄새11 - 기본형 집착
변경이나 기능 추가에 딷라 기본형으로만 커버가 안되는 단위같은게 나오면 타입을 하나 만드는게 좋음


<details>
<summary>기본형을 객체로 감싸기</summary>

- 단위 변환
- 여러 포맷으로 표현
과 같은 변경에 대응하기 유리하게

</details>

<details>
<summary>타입 변수를 서브클래스로 나누기</summary>

- 다형성을 사용해서 분기문을 줄일 수 있음
- if 문 switch 문 남발 방지

</details>

<details>
<summary>조건부 로직을 서브클래스로 바꾸기</summary>

- 타입변수는 따로 없는데 내부의 특정 조건에만 분기 타는것이 반복된다면
- 팩토리 클래스만들어서 해당조건의 서브클래스를 만들어서 처리하게 분리할수있음
- 아주 좋은듯 

</details>

## 냄새12 - switch 

요즘은 많이 이뻐져서 적당히 잘 쓰면됨

## 냄새13 - 반복문
고차함수 사용해서 읽기좋게 만들기

## 냄새14 - 성의없는 요소
재사용, 나중에생길 변화를 대비해서 변수, 클래스, 함수등을 만들어놨다가 안쓰는것 
이런애들을 제거해야 코드 혼란을 줄일 수 있음 

그런데 모바일앱이랑 협업하면 그쪽은 배포주기가 길어서 또 어느정도 예상을 해야하는 경우도 있어서
클라에도 영향을 바로 끼치는것인지 파악을 잘해야할듯하다.

<details>
<summary>계층 합치기</summary>

- 상속관계에서 기능을 옮기고 분리하다보면 상/하위 클래의 차이가 없어지는 경우가 있는데 이럴땐 합치는것이 좋다
- 이름이 적절한쪽으로 합치고 (애매하면 아무거나!)

</details>

## 냄새15 - 추측성 일반화

지금 없는 스펙인데 나중에 생길것을 예상해서 코드를 쓰지말자 (YAGNI!)  
다른 사람이 읽으면 지금 스펙을 기준으로 해석할텐데 없는 스펙에 대한 코드가 있으면 읽기 힘들어지기만 한다.  
일반화의 정도는 지금 있는 스펙에서 나올수있는 여러가지 케이스에 대응할수 있는 정도가 적절할 것 같다.  

- 주석도 안돼 그냥 지워라 ( 근데 요즘은 안쓰는것은 ide 에서 표시를 해줘서 이정도는 괜찮을것도 같다.)(매개변수 이런것만 아니면)
- 지웠따가 나중에 진짜 필요해지면 git 으로 돌려서 가져와라

- 인텔리에서 inlay > code vision > usage 옵션 켜서 사용하는 곳 횟수보기

## 냄새 16 - 임시 필드

어떤 객체가 특정한 경우에만 값을 가지는경우  
어떤 객체가 특정한 경우에만 특정한 값을 가지는경우  

같은 것들을 코드로 분기문을 통해서 나타내면 코드가 읽기 힘들어짐  
"특정 경우에만 값을 가진다" 자체가 일반적이지 않아서 예상하기가 힘듦

- 그 케이스가 생기는 함수로 옮기기

<details>
<summary>특이 케이스 추가하기 </summary>

- 특정 값을 가지고있는 인스턴스임을 검사하는 조건이 계속 반복된다면 아에 클래스로 분리하는 방법
- null 같은 의미의 값을 가지는것이 아니라면 `조건부 로직을 서브클래스로 바꾸기` 가 더 합당한것 같고
- null 같은 의미면 NullObject 패턴처럼 따로 만드는 것도 방법일듯
- 
- 근데 남용하면 엄청 햇갈릴것 같고 이런 케이스 자체가 많아지는거 자체가 db 설계가 망해가고 있다는 징조가 될수있을것 같다.

</details>

## 냄새 17 - 중재자

냄새 16 의  반대되는 리팩터링 계쇡 위임을 숨기다보면 무조건 특정 객체를 거쳐가는 현상이 나오는데 균형을 맞춰줘야함

<details>
<summary>중간자 없애기  </summary>

- 특정 값을 가지고있는 인스턴스임을 검사하는 조건이 계속 반복된다면 아에 클래스로 분리하는 방법
- null 같은 의미의 값을 가지는것이 아니라면 `조건부 로직을 서브클래스로 바꾸기` 가 더 합당한것 같고
- null 같은 의미면 NullObject 패턴처럼 따로 만드는 것도 방법일듯
-
- 근데 남용하면 엄청 햇갈릴것 같고 이런 케이스 자체가 많아지는거 자체가 db 설계가 망해가고 있다는 징조가 될수있을것 같다.

</details>

<details>
<summary>슈퍼클래스를 위임으로 바꾸기</summary>

- 하위 클래스에서 상위클래스 상속을 버리고 생성자로 주입받아 인스턴스 변수로 쓰면됨
</details>

<details>
<summary>하위클래스를 위임으로 바꾸기</summary>

- 서브클래스에서 상속구조가 걸리적 거릴때 사용할 수 있다.(강한결합 등..)
- 서브클래스에 대한 위임클래스를 만들고 상위클래스의 인스턴스 변수로 넣는다
- 그리고 기능을 점진적으로 위임클래스 쪽으로 옮기고 하위클래스는 껍대기 역할만 하게 한다.
- 모든 기능이 옮겨졌을때 하위클래스를 제거할 수 있다.
- 근데 예제의 경우 is-a 관계가 맞아서 리팩토링 전이 더 적합한것같은 느낌...
  
- `조건부 로직을 서브클래스로 바꾸기` 와 반대되는 리팩토링같다.
</details>

## 냄새18 - 서로다른 인터페이스의 대안 클래들
비슷한 기능인데 다른 인터페이스로 여러개의 클래스에서 구현되어 있고 서로 호환이 안될때(같은 스펙의 구현에 쓰는데 뭐는되고 뭐는 안되고 이런 경우인듯)
- 기존 코드 파악이 잘 안된 상태에서 개발할때
  - 커뮤니케이션 잘 안될때 (서로 뭐했는지 모르는 거지..)
- 버저닝했는데 이전 코드를 자꾸 사용할때도 발생하는듯 하다.

-> 새 인터페이스로 각 인터페이스 추상화해서 통합시킨후 다형성을 이용하여 유연하게 사용하기

## 냄새23 - 상속 포기
서브클래스가 슈퍼클래스에서 제공하는 메소드나 데이터를 잘 활용하지 않을때
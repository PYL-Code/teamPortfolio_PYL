# 게시판

## 프로젝트 소개
Spring Boot 기반의 CRUD 게시판 웹 애플리케이션   
사용자 회원가입, 로그인, 게시글 및 댓글 작성/수정/삭제 기능 포함   
MyBatis + MySQL 통해 DB 연동


## 🔧 사용 기술

| 구분 | 기술 스택 |
|------|----------|
| Language | Java 17 |
| Framework | Spring Boot 3.4.3, MyBatis |
| DB | MySQL |
| View | Thymeleaf |
| ORM/Mapper | MyBatis |
| Dependency Management | Gradle |
| Tool | Lombok, Spring DevTools |


## 📁 프로젝트 구조

```
src
├── main
│   ├── java
│   │   └── edu.du.teamportpoilo_pyl
│   │       ├── controller      # BoardController, UserController, API Controller
│   │       ├── dto             # BoardDto, UserDto, CommentDto
│   │       ├── mapper          # MyBatis Mapper Interfaces
│   │       ├── service         # 비즈니스 로직 처리
│   │       ├── config          # 웹 설정 및 인터셉터 등록
│   │       └── interceptor     # 로그인 검증 인터셉터
│   └── resources
│       ├── templates           # Thymeleaf 템플릿
│       └── static              # 정적 리소스 (js, css)
└── test
    └── java
        └── TeamPortpoiloPylApplicationTests.java
```


## 기능 소개

### 로그인 및 회원가입
- 회원가입 / 로그인 / 로그아웃
- 로그인한 사용자만 게시글/댓글 작성 가능

![스크린샷 2025-06-16 121924](https://github.com/user-attachments/assets/d40d6d03-aef6-4244-949d-e05a859849bf)
![스크린샷 2025-06-16 122009](https://github.com/user-attachments/assets/1913e3b1-beaa-4ecc-9a2c-4a25e2d497f2)


### 게시판
- 게시글 목록, 상세보기
- 로그인 사용자 전용
  - 게시글 작성 / 수정 / 삭제
  - 댓글 작성 / 삭제 
    - 본인이 작성한 게시글/댓글만 삭제 가능

![스크린샷 2025-06-16 122212](https://github.com/user-attachments/assets/73493910-2c2a-4c92-a11b-b8f1e89a213a)
![스크린샷 2025-06-16 122430](https://github.com/user-attachments/assets/b65afa4a-5e3b-410f-8691-73bb0ad55e12)


## 개선점
- 문제: 사용자 ID를 문자열로 비교하여 검증 오류 발생
- 원인: 한글 ID를 Thymeleaf에서 제대로 전송하지 못해 발생
- 해결 방안: 문자열 ID 대신 정수형 PK 도입 고려, 데이터 검증 방식 개선

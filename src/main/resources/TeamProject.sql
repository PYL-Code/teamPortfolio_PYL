create database if not exists teamproject;

use teamproject;

CREATE TABLE board (
    id INT AUTO_INCREMENT PRIMARY KEY,      -- 게시글 고유 ID
    title VARCHAR(255) NOT NULL,            -- 게시글 제목
    content TEXT NOT NULL,                  -- 게시글 내용
    author VARCHAR(100) NOT NULL,            -- 작성자
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 작성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 수정일
    views INT DEFAULT 0,                     -- 조회수
    likes INT DEFAULT 0                       -- 좋아요 수
);

INSERT INTO board (title, content, author, views, likes) VALUES
('오늘 하루 날씨가 너무 좋네요!', '오늘 날씨가 정말 좋아서 밖에 나가 산책을 했습니다.여러분도 날씨 좋은 날엔 밖에 나가 보세요!', '홍길동', 105, 30),
('이벤트 당첨됐어요!', '어제 참여한 이벤트에서 당첨되었다는 문자를 받았어요! 당첨된 상품이 기대돼요.', '이영희', 82, 15),
('오늘의 저녁은 치킨!', '오늘 저녁은 치킨을 시켰어요. 역시 치킨은 언제 먹어도 최고인 것 같아요.', '김철수', 65, 18),
('가장 최근에 본 영화 리뷰', '최근에 “인터스텔라”를 다시 봤어요. 정말 시간이 지나도 변하지 않는 명작이죠.', '홍길동', 200, 50),
('주말에 다녀온 카페 추천', '주말에 친구와 함께 갔던 카페가 정말 좋았어요. 분위기도 아늑하고 커피도 정말 맛있었어요.', '이영희', 45, 12),
('독서의 즐거움', '요즘 책을 많이 읽고 있어요. 여러분도 좋은 책 추천해주세요!', '김철수', 57, 20),
('운동 시작했어요', '최근에 운동을 시작했어요. 다들 어떤 운동을 하고 계신가요?', '박민수', 120, 35),
('여행지 추천', '최근에 다녀온 제주도가 너무 좋았어요. 제주도는 정말 힐링이 되는 곳인 것 같아요.', '최지우', 200, 40),
('새로운 취미를 시작하다', '최근에 새로운 취미로 그림을 그리기 시작했어요. 여러분도 새로운 취미를 찾으면 좋겠어요!', '홍길동', 85, 25),
('커피와 책의 완벽한 조합', '오늘은 커피 한 잔과 함께 책을 읽었어요. 커피와 책의 조합은 언제나 최고의 휴식이죠.', '이영희', 72, 18),
('최근에 한 친구와의 대화', '친구와 정말 오랜만에 깊은 대화를 나눴어요. 그동안 각자 바쁘게 살다가 다시 만나니 시간 가는 줄 몰랐어요.', '최지우', 38, 10),
('좋은 음악 발견', '어제 우연히 좋은 음악을 발견했어요. 여러분도 추천할 만한 노래가 있으면 알려주세요!', '김철수', 95, 28),
('집에서 간단한 요리 해봤어요', '오늘은 집에서 간단한 요리를 해봤어요. 재료도 간단하고 쉽게 만들 수 있어서 정말 좋았어요.', '홍길동', 60, 17),
('새로 구매한 운동화 후기', '최근에 새로 운동화를 샀어요. 디자인도 예쁘고 착용감도 정말 좋았어요. 여러분은 어떤 운동화 좋아하시나요?', '김철수', 50, 12),
('주말에 가볼만한 전시회', '이번 주말에 전시회를 다녀왔어요. 문화생활을 즐기는 것도 참 좋은 것 같아요.', '박민수', 78, 22);

CREATE TABLE comments (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    post_id INT NOT NULL,  -- 게시글 ID (board 테이블과 연결)
    author VARCHAR(100) NOT NULL,  
    comment TEXT NOT NULL,  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    FOREIGN KEY (post_id) REFERENCES board(id) ON DELETE CASCADE
);

INSERT INTO comments (post_id, author, comment) VALUES
(1, '댓글작성자1', '첫 번째 게시글의 첫 번째 댓글입니다.'),
(1, '댓글작성자2', '첫 번째 게시글의 두 번째 댓글입니다.'),
(2, '댓글작성자3', '두 번째 게시글에 대한 댓글입니다.');

CREATE TABLE users (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 사용자 고유 ID
    username    VARCHAR(50) NOT NULL UNIQUE,       -- 아이디 (중복 불가)
    password    VARCHAR(255) NOT NULL,             -- 비밀번호 (암호화 저장)
    name        VARCHAR(100) NOT NULL,             -- 사용자 이름
    email       VARCHAR(100) NOT NULL UNIQUE,      -- 이메일 (중복 불가)
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 가입 날짜
);

INSERT INTO users (username, password, name, email) 
VALUES 
('admin', '1234', '관리자', 'admin@example.com'),
('user1', '1234', '홍길동', 'user1@example.com'),
('user2', '1234', '김철수', 'user2@example.com'),
('user3', '1234', '이영희', 'user3@example.com'),
('user4', '1234', '박민수', 'user4@example.com'),
('user5', '1234', '최지우', 'user5@example.com');


-- drop table board;
-- drop table comments;
-- drop table users;
create database if not exists teamproject;

CREATE TABLE board (
    id INT AUTO_INCREMENT PRIMARY KEY,      -- 게시글 고유 ID
    title VARCHAR(255) NOT NULL,            -- 게시글 제목
    content TEXT NOT NULL,                  -- 게시글 내용
    author VARCHAR(100) NOT NULL,            -- 작성자
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 작성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- 수정일
    views INT DEFAULT 0,                     -- 조회수
    likes INT DEFAULT 0                       -- 좋아요 수
);

INSERT INTO board (title, content, author, views, likes) VALUES
('첫 번째 게시글', '이것은 첫 번째 게시글의 내용입니다.', '작성자1', 10, 2),
('두 번째 게시글', '이것은 두 번째 게시글의 내용입니다.', '작성자2', 25, 5),
('세 번째 게시글', '이것은 세 번째 게시글의 내용입니다.', '작성자3', 8, 1);

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


-- table comments;
-- drop table board;
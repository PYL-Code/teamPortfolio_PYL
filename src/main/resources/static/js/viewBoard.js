
    function deleteComment() {
        const boardId = window.location.pathname.split('/')[2];
        let commentId = this.dataset.commentId;
        let commentAuthor = this.dataset.commentAuthor;

        // console.log("작동한다");
        console.log("commentId: " + commentId);
        console.log("commentAuthor: " + commentAuthor);
        console.log("boardId: " + boardId);

        if (!confirm("댓글을 삭제하시겠습니까?")) return;
        //return: 실행 중단. 함수를 멈추고 빠져나옴

        $.ajax({
            url: `/api/board/${boardId}/comment/delete`,
            type: "POST",
            data: {commentId: JSON.stringify(commentId), commentAuthor: JSON.stringify(commentAuthor)},
            success: function (response) {
                if (response.success) { //success값은 true/false
                    alert("댓글이 삭제되었습니다.")
                } else {
                    alert("삭제 실패: " + response.message); //경고 메시지
                }
            },
            error: function (xhr) {
                alert("에러 발생: " + xhr.responseJSON.message); //에러 메시지 표시
            }
        });
    }; //end deleteComment


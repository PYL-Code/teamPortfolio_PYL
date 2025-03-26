$(document).ready(function() {
    // ✅ 게시글 삭제 버튼 이벤트
    $(".post-del-btn").click(function(event) {
        event.preventDefault(); // 기본 폼 제출 동작 막기

        let postId = "[[${board.id}]]"; // Thymeleaf에서 게시글 ID 가져오기

        if (!confirm("정말 삭제하시겠습니까?")) return;

        $.ajax({
            url: "/board/" + postId + "/delete",
            type: "POST",
            success: function(response) {
                if (response.success) {
                    alert("게시글이 삭제되었습니다.");
                    window.location.href = "/list"; // 목록으로 이동
                } else {
                    alert("게시글 삭제 실패: " + response.message);
                }
            },
            error: function() {
                alert("게시글 삭제 중 오류가 발생했습니다.");
            }
        });
    });

    // ✅ 댓글 삭제 버튼 이벤트
    $(".delete-btn").click(function(event) {
        event.preventDefault(); // 기본 폼 제출 동작 막기

        let commentId = $(this).siblings("input[name='id']").val(); // 해당 댓글 ID 가져오기
        let commentCard = $(this).closest(".comment"); // 삭제할 댓글 요소

        if (!confirm("댓글을 삭제하시겠습니까?")) return;

        $.ajax({
            url: "/board/comment/" + commentId + "/delete",
            type: "POST",
            success: function(response) {
                if (response.success) {
                    alert("댓글이 삭제되었습니다.");
                    commentCard.remove(); // 삭제된 댓글을 화면에서 제거
                } else {
                    alert("댓글 삭제 실패: " + response.message);
                }
            },
            error: function() {
                alert("댓글 삭제 중 오류가 발생했습니다.");
            }
        });
    });
});
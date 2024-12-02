document.addEventListener("DOMContentLoaded", ()=> {
   const commentForm = document.getElementById("commentForm");
   const commentList = document.querySelector("#CommentList");
   const categoryIdbox = document.querySelector("#categoryId");
   const pathname = window.location.pathname;
   const num = pathname.split('/').pop(); // 게시글 번호

    const checkCommentBtn = document.getElementById("check_comment");
    const commentModal = document.getElementById("commentModal");
    const closeModal = document.getElementById("closeModal");
    const modalCommentList = document.getElementById("modalCommentList");
    const modalCommentForm = document.getElementById("modalCommentForm");

    // 모달 열기
    checkCommentBtn.addEventListener("click", () => {
        commentModal.style.display = "block";
        loadComments(); // 댓글 로드
    });

    // 모달 닫기
    closeModal.addEventListener("click", () => {
        commentModal.style.display = "none";
    });

    // 댓글 등록
    modalCommentForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const formData = new FormData(modalCommentForm);
        formData.append("category", categoryIdbox.value);
        formData.append("board_num", num);

        fetch(`/board/addComment/${num}`, {
            method: "POST",
            body: formData,
        })
            .then((response) => response.json())
            .then((data) => {
                if (data.success) {
                    alert("댓글이 등록되었습니다.");
                    loadComments(); // 댓글 목록 새로고침
                    modalCommentForm.reset();
                } else {
                    alert("댓글 등록에 실패했습니다.");
                }
            })
            .catch((error) => console.error("Error:", error));
    });

    // 댓글 로드
    function loadComments() {
        const category = categoryIdbox.value;
        fetch(`/board/getComment/${category}/${num}`)
            .then((response) => response.json())
            .then((data) => {
                if (data.success) {
                    //임시아이디 설정. 나중에 확인할것 // 서버에서 받음
                    const currentUserId = data.current_user_id;
                    modalCommentList.innerHTML = ""; // 기존 댓글 초기화
                    data.comments.forEach((comment) => {
                        const commentItem = document.createElement("div");
                        commentItem.className = "comment_item";
                        commentItem.innerHTML = `
                            <p><strong>${comment.emp_id}</strong>: ${comment.comment_content}</p>
                            <p>${comment.create_at}</p>
                            ${
                            comment.emp_id === currentUserId
                                ? `<button class="delete-btn" data-comment-id="${comment.comment_num}">삭제</button>`
                                : ""
                        }
                        `;
                        modalCommentList.appendChild(commentItem);
                    });

                    // 삭제 버튼 이벤트 추가
                    document.querySelectorAll(".delete-btn").forEach((button) => {
                        button.addEventListener("click", (e) => {
                            const commentId = e.target.dataset.commentId;
                            deleteComment(commentId);
                        });
                    });
                } else {
                    alert("댓글 데이터를 가져오지 못했습니다.");
                }
            })
            .catch((error) => console.error("Error:", error));
    }

    // 댓글 삭제
    function deleteComment(commentId) {
        const category = categoryIdbox.value; // 현재 카테고리 값
        fetch(`/board/deleteComment/${category}/${commentId}`, { method: "DELETE" })
            .then((response) => response.json())
            .then((data) => {
                if (data.success) {
                    alert("댓글이 삭제되었습니다.");
                    loadComments(); // 삭제 후 목록 새로고침
                } else {
                    alert("댓글 삭제 실패!");
                }
            })
            .catch((error) => console.error("Error:", error));
    }
});
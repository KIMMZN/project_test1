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
                        //
                        // commentItem.innerHTML = `
                        //       <table>
                        //         <tr>
                        //                 <td> </td>
                        //         </tr>
                        //         </table>
                        //      <p><strong>${comment.emp_id}</strong>: ${comment.comment_content}</p>
                        //      <p>${comment.create_at}</p>
                        //     ${
                        //     comment.emp_id === currentUserId
                        //         ? `<button class="delete-btn" data-comment-id="${comment.comment_num}">삭제</button>`
                        //         : ""
                        // }
                        // `;
                        //<button class="edit-btn" data-comment-id="${comment.comment_num}">수정</button>`
                        //<p class="${comment.comment_num}"><strong>${comment.comment_content}</strong></p>
                        commentItem.innerHTML = `
                             <p><strong>${comment.emp_id}</strong>: </p>
                             <p data-comment-id="${comment.comment_num}"><strong>${comment.comment_content}</strong></p>
                             <p>${comment.create_at}</p>
                            ${
                            comment.emp_id === currentUserId
                                ? `<button class="delete-btn" data-comment-id="${comment.comment_num}">삭제</button>
                                    <button class="edit-btn" data-comment-id="${comment.comment_num}">수정</button>`
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
                    //수정 버튼 이벤트 추가
                    document.querySelectorAll(".edit-btn").forEach((button)=> {
                        button.addEventListener("click", (e) => {
                            const commentId = e.target.dataset.commentId;
                            const commentItem = e.target.closest(".comment_item")
                            //[data-cmment-id]가 있는 p태그
                            const commentContentEl = commentItem.querySelector(`p[data-comment-id="${commentId}"]`);
                            if(!commentContentEl) {
                                console.log(commentContentEl.textContent);
                                console.error("엘레먼트 없음")
                                return;
                            }else {
                                console.log(commentContentEl.textContent);
                            }
                            const commentContent = commentContentEl.textContent.trim()//댓글내용
                            alert(commentContent);
                            //버튼 클릭시 data-comment-id, .commet_item(div), (p태그의 댓글내용)
                            editComment(commentId,commentItem,commentContent,commentContentEl);
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

    //대글 수정
    function editComment(commentId,commentItem,commentContent,commentContentEl) {
        alert("수정function")
        commentContentEl.innerHTML="";
        const category = categoryIdbox.value;


        const inputbtnDiv = document.createElement("div");


        const input = document.createElement("input");
        input.setAttribute("type", "text");
        input.value = commentContent; // 기존 댓글 내용을 기본값으로 설정
        inputbtnDiv.append(input);

        alert("저장텍스트생성")
        const submit = document.createElement("input");
        submit.setAttribute("type", "button");
        submit.setAttribute("value", "저장");
        inputbtnDiv.append(submit);
        alert("수정버튼생성")

        const cancel = document.createElement("input");
        cancel.setAttribute("type", "button");
        cancel.setAttribute("value", "취소");
        inputbtnDiv.append(cancel);
        alert("취소버튼생성")

        document.querySelector(`button[data]`)






        commentContentEl.append(inputbtnDiv);




        //
        // comment.emp_id === currentUserId
        //     ? `<button class="delete-btn" data-comment-id="${comment.comment_num}">삭제</button>
        //                             <button class="edit-btn" data-comment-id="${comment.comment_num}">수정</button>`
        //     : ""


        // const input = document.createElement("input");
        // input.setAttribute("type", "text");
        // commentContentEl.append(input);
        //
        //
        // const submit = document.createElement("button");
        // submit.setAttribute("value", "저장");
        // commentContentEl.append(submit);
        // alert("확인")






       //  alert(commentID)
       //  alert(commentItem)
       //  alert(commentContent)
        //fetch(`/board/editComment/${category}/${commentId}`, {method: "update"})

    }




});
const selectcategoryAll = document.querySelector("#selectCategoryO");
const submitButtonOne = document.querySelector("#submitButton");

function selectCategory() {

    if (selectcategoryAll.value != null) {
        // alert(selectcategoryAll.value);
        //console.log(selectcategoryAll.value);
        submitButtonOne.click();
    }


}

function deletePost(button) {
    alert("sd")
    const categoryv = button.getAttribute('data-category');
    const boardNumv = button.getAttribute('data-board-num');

    // 디버깅: 콘솔에 데이터 출력
    console.log('카테고리:', category);
    console.log('게시글 번호:', boardNum);


    console.log('삭제 요청 - 카테고리:', category, '게시글 번호:', boardNum);

    if (confirm('정말 삭제하시겠습니까?')) {
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = '/board/manager/delOne/';

        const categoryInput = document.createElement('input');
        categoryInput.type = 'hidden';
        categoryInput.name = 'category';
        categoryInput.value = categoryv;

        const boardNumInput = document.createElement('input');
        boardNumInput.type = 'hidden';
        boardNumInput.name = 'board_num';
        boardNumInput.value = boardNumv;

        form.appendChild(categoryInput);
        form.appendChild(boardNumInput);

        document.body.appendChild(form);
        form.submit();
    }
}
//페이지네이션을 위함
window.onload = () => {
    setQueryStringParams();

}

//쿼리 스트링 파라미터 세팅
function setQueryStringParams() {
    // 현재 URL의 쿼리 스트링 파라미터 추출
    const params = new URLSearchParams(location.search);

    // 검색 폼 가져오기
    const form = document.getElementById('searchForm');

    // 쿼리 스트링이 없으면 종료
    //  if (!location.search || !form) {
    //      return;
    //  }

    // 쿼리 스트링 값을 폼 요소에 매핑
    params.forEach((value, key) => {
        if (form[key]) {
            form[key].value = value; // 해당 키와 일치하는 폼 요소에 값 설정
        }
    });
}

document.addEventListener('DOMContentLoaded', function () {
    const mailButtons = document.querySelectorAll('.mail_btn input');

    mailButtons.forEach(button => {
        button.addEventListener('click', function () {
            // 기존 활성 상태 제거
            mailButtons.forEach(btn => btn.classList.remove('active'));
            // 클릭된 버튼에만 'active' 추가
            this.classList.add('active');
        });
    });
});
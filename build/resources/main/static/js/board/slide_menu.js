
// JavaScript 코드
const noticeMenu = document.getElementById('notice_menu');
const subMenu = noticeMenu.querySelector('.sub_menu');

noticeMenu.addEventListener('click', function (event) {
    event.preventDefault(); // a 태그의 기본 동작(페이지 이동) 방지
    subMenu.style.display = (subMenu.style.display === 'block') ? 'none' : 'block';
});

// 다른 곳 클릭 시 메뉴 닫힘
document.addEventListener('click', function (event) {
    if (!noticeMenu.contains(event.target)) {
        subMenu.style.display = 'none';
    }
});
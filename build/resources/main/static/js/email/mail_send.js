function select_file(this_element) {
    let file = this_element.files[0];
    let file_name = this_element.closest(".mail_file").firstElementChild;

    // 파일 선택 창에서 열기가 아닌 취소를 누른 경우
    if (!(file)) {
        file_name.value = null;
        return;
    }

    // 파일 확장자 제한
    // file_extension : input에 등록한 파일의 확장자
    // extension_check_list : 제한할 확장자명을 적어둔 배열
    // extension_check : 확장자 검증 여부
    let file_extension = file.name.substring(file.name.length - 4);
    let extension_check_list = [".txt", ".gif", ".jpg", ".png", ".mp3", ".avi", ".mkv", ".zip"];
    let extension_check = false;
    // extension_check_list 배열을 순회하며 input에 등록한 파일의 확장자가 같을 경우 true 반환
    for (let i=0; i<extension_check_list.length; i++) {
        if (extension_check_list.includes(file_extension)) {
            extension_check = true;
            break;
        }
    }
    // 확장자 검증 여부가 false일 경우
    if (!(extension_check)) {
        alert("등록할 수 있는 확장자명이 아닙니다.\n.zip 파일로 압축하거나 확장자명을 확인해주세요.");
        file_name.value = null;
        this_element.value = null;
        return;
    }

    // 파일 크기 제한
    // file.size : 선택한 파일의 크기(Byte)
    // 1Byte → 1024Byte = 1KB, 1024KB → 1MB, 메가바이트 계산
    // 소수점 수는 필요없으므로 Math클래스의 floor함수 사용
    let file_size = Math.floor(file.size / 1024 / 1024);
    // 선택한 파일의 크기가 10MB를 넘을 경우
    if (file_size > 10) {
        alert("올릴 수 있는 파일의 크기는 10MB까지 입니다.");
        file_name.value = null;
        this_element.value = null;
        return;
    }

    // 파일명 설정
    // let change_name = file.name;
}

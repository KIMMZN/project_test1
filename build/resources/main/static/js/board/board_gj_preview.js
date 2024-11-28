//title
const titlebox = document.querySelector("#titlebox");
//text
const contextbox = document.querySelector("#contextbox");
//category
const categoryIdbox = document.querySelector("#categoryId");
//id(name)
const nameBox = document.querySelector("#namebox");

const pathname = window.location.pathname; //pathname가져옴. /gj_preview/4
//  alert(pathname+"패스네임"); //게시판글넘버
const num = pathname.split('/').pop();
//const num = parseInt(pathname.split('/').pop(), 10);



/*목록 버튼 클릭시*/
function btnlist() {
    location.href = "/board_gj";
};


/*삭제 버튼 클릭시 */

    let del = document.querySelector("#delbtn").addEventListener("click", ()=> {
        // const url = window.location.href; // url 가져오기
        //  let query = window.location.search; // url query 가져오기
        // let param = new URLSearchParams(query);
        // alert(num);
        // alert(typeof num +"   //num의 타입 확인")
        alert("무슨일")
        if(confirm("삭제?")){
            let form = document.createElement("form");
            form.setAttribute("method", 'post');
            form.setAttribute("action", `/gj_preview/delOne/${num}`);

            let categoryField = document.createElement("input");
            categoryField.setAttribute("type", 'hidden');
            categoryField.setAttribute("name",'category');
            categoryField.setAttribute("value", categoryIdbox.value);
            form.appendChild(categoryField);

            document.body.appendChild(form);
            form.submit();

            /* 템플릿 리터럴을 사용 하려면 문자열을 ``(백틱)으로 감싸야함 */

            alert("삭제함");
        }else {
            alert("취소함");
        }
    });

    //수정
//DOMContentloaded:
//dom트리가 완전히 구축되었을 때 실행.
//이미지 , css, 외부 리소스 로드는 완료되지 않아도 실행. // 빠르게 실행됨
document.addEventListener("DOMContentLoaded", () => {
    let modify= document.querySelector("#modifybtn").addEventListener("click", ()=>{
        alert("asdf");
        document.querySelector("#titlebox").removeAttribute("readonly", false);
        document.querySelector("#contextbox").removeAttribute("readonly", false);

        let pdiv = document.querySelector(".update_delete_div");
        pdiv.innerHTML = '';

        let submitbtnInput = document.createElement('input');
        submitbtnInput.setAttribute("type", "button");
        submitbtnInput.setAttribute("id", "submitBtn");
        submitbtnInput.setAttribute("value", "수정")
        pdiv.appendChild(submitbtnInput);

        let cancelbtnInput = document.createElement('input');
        cancelbtnInput.setAttribute("type", "button");
        cancelbtnInput.setAttribute("id", "cancelBtn");
        cancelbtnInput.setAttribute("value", "취소")
        pdiv.appendChild(cancelbtnInput);
    });
});

    document.querySelector(".update_delete_div").addEventListener('click', (e)=> {
            let titleTemp = titlebox.value;
            let contexTemp = contextbox.value;
            let categoryTemp = categoryIdbox.value;


             alert(titleTemp);

            if(e.target.id === "submitBtn") {
                e.preventDefault() // 기본동작방지
                alert("수정버튼")
                let form = document.createElement('form');
                form.setAttribute('method', 'post');
                form.setAttribute('action', `/gj_preview/modifyOne/${num}`);


                let titleField = document.createElement("input");
                titleField.setAttribute("type", "hidden");
                titleField.setAttribute("name", "board_title");
                titleField.setAttribute("value", titleTemp);
                form.appendChild(titleField);

                let textField = document.createElement("input");
                textField.setAttribute("type", "hidden");
                textField.setAttribute("name", "board_content");
                textField.setAttribute("value", contexTemp);
                form.appendChild(textField);

                let categoryField = document.createElement("input");
                categoryField.setAttribute("type", "hidden");
                categoryField.setAttribute("name", "category");
                categoryField.setAttribute("value", categoryTemp);
                form.appendChild(categoryField);

                let numberField = document.createElement("input");
                numberField.setAttribute("type", "hidden");
                numberField.setAttribute("name", "board_num");
                numberField.setAttribute("value", num);
                form.appendChild(numberField);

                document.body.appendChild(form);
                form.submit();

            }else if(e.target.id === "cancelBtn") {
                location.reload(true);
            }

    });




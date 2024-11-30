let attendance_row = document.getElementById("attendance_list");
let attendance_empty = document.getElementById("attendance_empty");

let today = new Date();
let year = today.getFullYear();
let month = String(today.getMonth() + 1).padStart(2,'0');
let day = String(today.getDate()).padStart(2,'0');
let now_date = (year + "-" + month + "-" + day);

let work_start = document.getElementsByClassName("work_start")[0];
let work_end = document.getElementsByClassName("work_end")[0];

window.onload = () => {
    if (attendance_row.rows.length <= 0) {
        attendance_empty.style.display = "";
    } else {
        attendance_empty.style.display = "none";
    }

    if (attendance_row.rows[0].cells[0].innerText === now_date) {
        work_start.style.display = "none"
    } else {
        work_end.style.display = "none"
    }
}



work_start.addEventListener("click", () => {
    work_start.style.display = "none"
    work_end.style.display = ""

    const form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "work_start");

    // const input = document.createElement("input");
    // input.setAttribute("type", "hidden");
    // input.setAttribute("name", "emp_id");
    // input.setAttribute("value", 유저아이디)
    // form.appendChild(input);

    document.body.appendChild(form);
    form.submit();
});

work_end.addEventListener("click", () => {
    console.log(now_date);

});
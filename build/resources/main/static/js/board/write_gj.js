
document.addEventListener("DOMContentLoaded", () => {
    let count =0;
    let file = document.querySelector("#filebtn").addEventListener("click", ()=> {


        const fileList = document.querySelector(".write_files")
        let newfile = document.createElement("div");
        newfile.classList.add('file_add',);
        newfile.innerHTML = '<input type="file" name="file" id="formFile"><input type="button" value="x" id="file_cancelbtn">';
        fileList.appendChild(newfile);

        count++;
        let filebtnn = document.querySelector("#filebtn");
        if(count == 3) {
            filebtnn.disabled = true;
        }

    });


    let write_files_div = document.querySelector(".write_files").addEventListener("click",(event)=> {

        let filediv = document.querySelector(".file_add");
        let filebtn  = document.querySelector("#filebtn");
        if(event.target.id === 'file_cancelbtn') {
            filediv = filediv.remove();
            count--;
            if(count < 3) {
                filebtn.disabled = false;
            }

        }
    });


});


// board list
let newbdbtn = document.querySelector("#newbdbtn")
newbdbtn?.addEventListener('click', () => {
    location.href = '/board/write';
});


// board write
let wrtbdbtn = document.querySelector("#wrtbdbtn")
wrtbdbtn?.addEventListener('click', () => {
    let frm = document.forms.post_form;
    if(frm.title.value === '') alert('제목을 작성하세요!!');
    else if(frm.contents.value === '') alert('본문을 작성하세요!!');
    else {
        frm.method = 'post';
        frm.submit();
    }
});
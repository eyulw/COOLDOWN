// board list
let newbdbtn = document.querySelector("#newbdbtn")
newbdbtn?.addEventListener('click', () => {
    location.href = '/board/write';
});


// board view
let bdlist = document.querySelector("#bdlist")
bdlist?.addEventListener('click', ()=> {
    location.href = '/board/list/1';
});


// board write
let bdwrtcancelbtn = document.querySelector("#bdwrtcancelbtn")
bdwrtcancelbtn.addEventListener('click', ()=> {
    location.href = '/board/list/1'
})
let wrtbdbtn = document.querySelector("#wrtbdbtn")

wrtbdbtn?.addEventListener('click', () => {
    let frm = document.forms.post_form;
    if(frm.title.value === '') alert('제목을 작성하세요!!');
    else if(frm.contents.value === '') alert('본문을 작성하세요!!');
    else {
        let b_category=document.querySelector("#b_category")
        let categoryValue=document.querySelector("#categoryValue")
        categoryValue.value=b_category.value;

        frm.action='/board/write'
        frm.method = 'post';
        frm.submit();
    }
});
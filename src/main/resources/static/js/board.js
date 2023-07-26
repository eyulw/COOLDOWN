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

let siren = document.querySelector("#siren")
siren?.addEventListener('click', () => {
   alert("죄송합니다. 아직 미지원 기능입니다. 고객센터로 연락주시면 감사하겠습니다.")
});


// board write
let bdwrtcancelbtn = document.querySelector("#bdwrtcancelbtn")
bdwrtcancelbtn?.addEventListener('click', ()=> {
    location.href = '/board/list/1'
})

let wrtbdbtn = document.querySelector("#wrtbdbtn")
wrtbdbtn?.addEventListener('click', () => {
    let frm = document.forms.post_form;
    //if(frm.userid.value === '') alert('로그인 하세요!!');
    if(frm.title.value === '') alert('제목을 작성하세요!!');
    //else if(frm.title.value === '') alert('제목을 작성하세요!!');
    else if(frm.contents.value === '') alert('본문을 작성하세요!!');
    else {
        let b_category=document.querySelector("#b_category")
        let categoryValue=document.querySelector("#categoryValue")
        categoryValue.value=b_category.value;

        //frm.action='/board/write'
        frm.method = 'post';
        frm.enctype  = 'multipart/form-data';
        frm.submit();
    }
});


// board find category
let findallbtn = document.querySelector("#findallbtn")
let findbdbtn = document.querySelector("#findbdbtn")
let findwithbtn = document.querySelector("#findwithbtn")
let findintrobtn = document.querySelector("#findintrobtn")
let findqnabtn = document.querySelector("#findqbtn")
let findtype = document.querySelector("#findtype")
let findkey = document.querySelector("#findkey")
findallbtn?.addEventListener('click', () => {
    location.href = `/board/list/1`;
});
findbdbtn?.addEventListener('click', () => {
    location.href = `/board/list/2`;
});
findwithbtn?.addEventListener('click', () => {
    if(findkey.value === '') alert('검색어를 입력하세요!!')
    else {
        location.href = `/board/find/${findtype.value}/${findkey.value}/1`;
    }
});
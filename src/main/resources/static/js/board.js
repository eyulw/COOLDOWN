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

let siren1 = document.querySelector("#siren1")
siren1?.addEventListener('click', () => {
   alert(`불편을 드려 죄송합니다.
홈페이지 리뉴얼로 인해, 현재 지원할 수 없는 기능입니다.
고객센터로 연락 주시면 신속하게 도와드리겠습니다.`)
});
let siren2 = document.querySelector("#siren2")
siren2?.addEventListener('click', () => {
    alert(`불편을 드려 죄송합니다.
홈페이지 리뉴얼로 인해, 현재 지원할 수 없는 기능입니다.
고객센터로 연락 주시면 신속하게 도와드리겠습니다.`)
});
let siren3 = document.querySelector("#siren3")
siren3?.addEventListener('click', () => {
    alert(`불편을 드려 죄송합니다.
홈페이지 리뉴얼로 인해, 현재 지원할 수 없는 기능입니다.
고객센터로 연락 주시면 신속하게 도와드리겠습니다.`)
});


// board write
let bdwrtcancelbtn = document.querySelector("#bdwrtcancelbtn")
bdwrtcancelbtn?.addEventListener('click', ()=> {
    location.href = '/board/list/1'
})

let wrtbdbtn = document.querySelector("#wrtbdbtn")
wrtbdbtn?.addEventListener('click', () => {
    let frm = document.forms.post_form;
    if(frm.title.value === '') alert('제목을 작성하세요.');
    else if(frm.contents.value === '') alert('본문을 작성하세요.');
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


// board comment
let newboardcommentbtn = document.querySelector("#newboardcommentbtn")
newboardcommentbtn?.addEventListener('click', ()=> {
    let frm = document.forms.comment_form;
    if(frm.u_id.value === '') alert('로그인 하세요.');
    else if(frm.contents.value === '') alert('댓글을 작성하세요.');
    else{
        frm.method = 'post';
        frm.action = '/board/boardcomments/write';
        frm.submit();
    }
});


// board comment reply
let commentbtn = document.querySelector("#commentbtn")
commentbtn?.addEventListener('click', ()=> {
    alert('로그인을 하시면 대댓글을 작성하실 수 있습니다.');
});

$('#replyModal').on('shown.bs.modal', function (event) {
    let button = $(event.relatedTarget);
    let ref = button.data('ref');
    let modal = $(this);
    modal.find('.modal-body .ref').val(ref)
})
/*let modal = null;
const showReply = (ref) => {
    const refno = document.querySelector("#ref");
    refno.value = ref;
    modal = new bootstrap.Modal(replyModal, {});
    modal.show();
};*/
const replybtn = document.querySelector("#replybtn");
replybtn?.addEventListener('click', () => {
    let frm = document.querySelector("#replyfrm")
    if(frm.contents.value === '') alert('대댓글을 작성하세요.');
    else {
        frm.method = 'post';
        frm.action = '/board/boardreply/write';
        frm.submit();
    }
});


// board find category
let findallbtn = document.querySelector("#findallbtn")
findallbtn?.addEventListener('click', () => {
    location.href = `/board/list/1`;
});
$('.category')?.on('click',(e)=>{
    location.href='/board/category/'+e.target.value+'/1';
})


// board modify
$('.bdModifyBtn')?.on('click',(e)=>{
    location.href='/board/modify/'+e.target.value;
})

let bdwrtmdibtn=document.querySelector("#bdwrtmdibtn");
let bdwrtmdicancelbtn=document.querySelector("#bdwrtmdicancelbtn");
bdwrtmdicancelbtn?.addEventListener('click', () => {
    history.back();
})
bdwrtmdibtn?.addEventListener('click',()=>{
    let b_category=document.querySelector("#b_category")
    let categoryValue=document.querySelector("#categoryValue")
    let frmmdi = document.forms.post_form_modify;
    if(frmmdi.title.value === '') alert('제목을 작성하세요.');
    else if(frmmdi.contents.value === '') alert('본문을 작성하세요.');
    else {
        categoryValue.value=b_category.value;
        if(frmmdi.attachs.value==='') {
            frmmdi.action = '/board/modifyb/'+frmmdi.board_id.value;
            frmmdi.method = 'post';
            frmmdi.submit();
        } else {
            frmmdi.action = '/board/modifyba/'+ frmmdi.board_id.value;
            frmmdi.method = 'post';
            frmmdi.enctype  = 'multipart/form-data';
            frmmdi.submit();
        }
    }
})


// board delete
$('.bdDeleteBtn')?.on('click',(e)=>{
    if(confirm("게시글을 삭제하시겠어요?")){
        location.href='/board/delete/'+e.target.value;
        /*location.href='/admin/boardDelete/'+e.target.value;*/
    }
})

// board find
let findbd = document.querySelector("#findbd")
findbd?.addEventListener('click', ()=>{
    alert(`기존 홈페이지에 더 다양한 게시물을 보실 수 있습니다.
기존 홈페이지로 이동합니다.`)
});


// like
/*
let view_like_count = document.querySelector("#view_like_count");
const plusLike = (board_id) => {
    if(session.user = null) {
        alert('로그인해주세요');
    } else {
        // AJAX 요청 시작
        fetch(`/likes/${board_id}`, {
            method: 'GET',
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                view_like_count.textContent = data;
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
};*/

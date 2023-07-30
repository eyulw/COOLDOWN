/*회원 상세보기 모달*/
$('#userDetail').on('show.bs.modal', function (event) {
    let button = $(event.relatedTarget);
    let username = button.data('username');
    let uid = button.data('uid');
    let birth = button.data('birth');
    let regdate = button.data('regdate');
    let nickname = button.data('nickname');
    let email = button.data('email');
    let phone = button.data('phone');
    let zipcode = button.data('zipcode');
    let addr1 = button.data('address1');
    let addr2 = button.data('address2');
    let fulladdr = '['+zipcode+'] '+addr1+' '+addr2;
    let modal = $(this);
    modal.find('.modal-body .username').val(username)
    modal.find('.modal-body .uid').val(uid)
    modal.find('.modal-body .birth').val(birth)
    modal.find('.modal-body .regdate').val(regdate)
    modal.find('.modal-body .nickname').val(nickname)
    modal.find('.modal-body .email').val(email)
    modal.find('.modal-body .phone').val(phone)
    modal.find('.modal-body .fulladdr').val(fulladdr)
})


/*admin - qnaReply*/

let rplok = document.querySelector("#rplok");
rplok?.addEventListener('click',()=>{
   let rplfrm=document.forms.rplfrm;
   console.log(rplfrm.answer.value);
   let qnaid=document.querySelector("#qnaid");
    if(rplfrm.answer.value===''){
        alert("문의에 대한 답변을 작성해 주세요");
    } else{
        rplfrm.action="/admin/qna/"+qnaid.value;
        rplfrm.method='post';
        rplfrm.submit();
    }
});

let rplcc = document.querySelector("#rplcc");
rplcc?.addEventListener('click',()=>{
    location.href='/admin/qna/list/1';
})


/*makeitem*/

let makeItemBtn=document.querySelector("#makeItemBtn");
makeItemBtn?.addEventListener('click',()=>{

    location.href='/admin/item/make';

})


let mkitembtn=document.querySelector("#mkitembtn");
mkitembtn?.addEventListener('click',()=>{
    let icategory=document.querySelector("#icategory");
    let frm=document.forms.mkitemfrm;
    if(frm.attach.value==='') alert("상품 이미지를 등록하세요");
    else if(frm.itemname.value==='') alert("상품명을 입력하세요");
    else if(frm.price.value==='') alert("상품 가격을 입력하세요");
    else if(frm.i_category.value==='-------선택-------') alert("상품 카테고리를 선택하세요");
    else if(frm.info.value==='') alert("상품 상세정보를 입력하세요");
    else if(frm.stock.value==='') alert("상품 재고를 입력하세요");
    else{
        icategory.value=frm.i_category.value;
        frm.method='post';
        frm.enctype='multipart/form-data';
        frm.submit();
    }
})

/*상품페이지 - 상품삭제*/
$('.aitemDeleteBtn')?.on('click',(e)=>{
    if(confirm("상품을 삭제하시겠어요?")){
        location.href='/admin/itemDelete/'+e.target.value;
    }
})

/*게시글페이지 - 게시글삭제*/
$('.bdDelBtn')?.on('click',(e)=>{
    if(confirm("게시글을 삭제하시겠어요?")){
        location.href='/admin/boardDelete/'+e.target.value;
    }
})

/*상품수정페이지*/
$('.aitemModifyBtn')?.on('click',(e)=>{
    if(confirm("상품을 수정하시겠어요?")){
        location.href='/admin/item/modify/'+e.target.value;
    }
})

let mditembtn=document.querySelector("#mditembtn");
let cancelmdiBtn=document.querySelector("#cancelmdiBtn");
cancelmdiBtn?.addEventListener('click',()=>{
    location.href='/admin/item';
})
mditembtn?.addEventListener('click',()=>{
    let icategory=document.querySelector("#icategory");
    let frm=document.forms.mditemfrm;
    if(frm.itemname.value==='') alert("상품명을 입력하세요");
    else if(frm.price.value==='') alert("상품 가격을 입력하세요");
    else if(frm.i_category.value==='-------선택-------') alert("상품 카테고리를 선택하세요");
    else if(frm.info.value==='') alert("상품 상세정보를 입력하세요");
    else if(frm.stock.value==='') alert("상품 재고를 입력하세요");
    else{
        icategory.value=frm.i_category.value;
        if(frm.attach.value===''){
            frm.action='/admin/item/modify/'+frm.oneiid.value;
            frm.method='post';
            frm.submit();
        }else{
            frm.action='/admin/item/modifyI/'+frm.oneiid.value;
            frm.method='post';
            frm.enctype='multipart/form-data';
            frm.submit();
        }
    }
})

let irplok = document.querySelector("#irplok");
irplok?.addEventListener('click',()=>{
    let frm=document.forms.irplfrm;
    let itemqnaid=document.querySelector("#itemqnaid");
    if(frm.answer.value===''){
        alert("문의에 대한 답변을 작성해 주세요");
    } else{
        frm.action="/admin/itemqna/"+itemqnaid.value;
        frm.method='post';
        frm.submit();
    }
});


let irplcc = document.querySelector("#irplcc");
irplcc?.addEventListener('click',()=>{
    location.href='/admin/itemqna/list/1';
})

let amovebtn= document.querySelector('.amovebtn');
amovebtn?.addEventListener('click',()=>{
   location.href='/admin/';
});
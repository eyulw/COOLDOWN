let joinBtn =document.querySelector("#joinBtn");
let modal = null;
joinBtn?.addEventListener('click',()=>{
    try{
        // 새로운 모달 창 생성
        modal=new bootstrap.Modal(joinform_modal,{});
    }catch (e){
        console.log(e);
    }
    modal.show();
});

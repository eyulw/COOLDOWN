let loginJoinBtn = document.querySelector('#loginJoinBtn');

// loginJoinBtn?.addEventListener('click',(e)=>{
//         $('#login_modal').modal('hidden');
//         $('#joinformModal').modal('show');
// })

let userid = document.querySelector('#userid');
let passwd = document.querySelector('#passwd');
let loginbtn = document.querySelector('#loginbtn');

loginbtn?.addEventListener('click',()=>{
    frm=document.forms.lgnfrm;
    if(frm.userid.value==='') alert('아이디를 입력하세요');
    else if(frm.password.value==='') alert('비밀번호를 입력하세요');
    else{
        frm.method='post';
        frm.action='/login'
        frm.submit();
    }
})




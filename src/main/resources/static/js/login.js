let loginbtn = document.querySelector('#loginbtn');

loginbtn?.addEventListener('click',()=>{
    let frm=document.forms.lgnfrm;
    if(frm.userid.value==='') alert('아이디를 입력하세요');
    else if(frm.password.value==='') alert('비밀번호를 입력하세요');
    else{
        frm.method='post';
        frm.action='/login'
        frm.submit();
    }
})




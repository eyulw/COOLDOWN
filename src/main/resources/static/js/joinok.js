
/*joinform_modal*/
let joinokBtn =document.querySelector("#joinokBtn");
joinokBtn?.addEventListener('click',()=>{
    let frm=document.forms.joinfrm;
    if(frm.userid.value==='') alert("아이디를 입력하세요");
    else if(frm.password.value==='') alert("비밀번호를 입력하세요");
    else if(frm.passwd_confirm.value==='') alert("비밀번호를 확인란을 입력하세요");
    else if(frm.password.value!=frm.passwd_confirm.value) alert("비밀번호가 일치하지 않습니다");
    else if(frm.email.value==='') alert("이메일을 입력하세요");
    else if(frm.nickname.value==='') alert("닉네임을 입력하세요");
    else if(frm.phone.value==='') alert("핸드폰번호를 입력하세요");
    else if(frm.birth_y.value==='') alert("태어난 연도를 선택하세요");
    else if(frm.birth_m.value==='') alert("태어난 달을 선택하세요");
    else if(frm.birth_d.value==='') alert("태어난 날짜를 선택하세요");
    else if(frm.name.value==='') alert("이름을 입력하세요");
    else{
        frm.birth.value=frm.birth_y.value+'-'+frm.birth_m.value+'-'+frm.birth_d.value;
        frm.action='/join';
        frm.method='post';
        frm.submit();
    }
})

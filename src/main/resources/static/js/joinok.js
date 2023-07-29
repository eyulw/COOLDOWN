
/*joinform_modal*/

// 비밀번호 확인
let pwd = document.querySelector("#pwd");
let repwd=document.querySelector("#repasswd");
let pwdmsg=document.querySelector("#pwdmsg");
repwd?.addEventListener('blur',()=>{
    let pmsg = "비밀번호가 서로 일치하지 않습니다.";
    pwdmsg.className='ipmsg';
    if(pwd.value === repwd.value){
        pmsg="비밀번호가 서로 일치합니다.";
        pwdmsg.className='pmsg';
    }
    pwdmsg.innerText=pmsg;
})


let uid = document.querySelector("#uid");
let checkuid = document.querySelector("#checkuid");
let uidmsg=document.querySelector("#uidmsg");

const checkUserid = (chkuid) => {
    let umsg = '사용 불가능한 아이디입니다.';
    uidmsg.className='ipmsg';
    checkuid.value='no';
    if(chkuid==='0'){
        umsg='사용가능한 아이디입니다.';
        uidmsg.className='pmsg';
        checkuid.value='yes';
    }
    uidmsg.innerText=umsg;
};
uid?.addEventListener('blur',()=>{
    if(uid.value===''){
        uidmsg.innerText='6~16 자의 영문 소문자, 숫자와 특수기호(_)만 사용할 수 있습니다';
        uidmsg.className='ipmsg';
        checkuid.value='no';
        return;
    }
    const url="/join/checkuid/"+uid.value;
    fetch(url).then(response=>response.text())
        .then(text=>checkUserid(text))
})

/*이메일 형식확인*/
let jemail = document.querySelector("#join_email");
let emsg=document.querySelector("#emsg");
jemail?.addEventListener('blur',()=>{
    let emmsg = "사용가능한 이메일입니다";
    emsg.className='pmsg';
    if(jemail.value.match(regEmail)===null){
        emmsg="이메일 형식에 맞게 입력하세요.";
        emsg.className='ipmsg';
    }
    emsg.innerText=emmsg;
})


let joinokBtn =document.querySelector("#joinokBtn");
const regEmail = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
joinokBtn?.addEventListener('click',()=>{
    let frm=document.forms.joinfrm;
    if(frm.userid.value==='') alert("아이디를 입력하세요");
    else if(frm.password.value==='') alert("비밀번호를 입력하세요");
    else if(frm.passwd_confirm.value==='') alert("비밀번호를 확인란을 입력하세요");
    else if(frm.email.value==='') alert("이메일을 입력하세요");
    else if (frm.email.value.match(regEmail) === null) alert("이메일을 형식에 맞게 입력하세요.");
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


/*joinagree_modal*/

let joinBtn = document.querySelector('#joinBtn');
let policy_agree = document.querySelector('#policy_agree');
let privacy_agree = document.querySelector('#privacy_agree');
let limit_join_agree = document.querySelector('#limit_join_agree');

joinBtn?.addEventListener('click',(e)=>{
    if(!policy_agree.checked){
        e.preventDefault();
        alert('이용약관 및 개인정보 처리방침에 동의하셔야 가입이 가능합니다.');
    }else if( !privacy_agree.checked){
        e.preventDefault();
        alert('이용약관 및 개인정보 처리방침에 동의하셔야 가입이 가능합니다.');
    }
    else if(!limit_join_agree.checked){
        e.preventDefault();
        alert('만 14세 미만은 가입이 불가합니다. 만 14세 이상임을 확인해주세요')
    }else{
        $('#joinagreeModal').modal('hide');
        $('#joinformModal').modal('show');
    }
})


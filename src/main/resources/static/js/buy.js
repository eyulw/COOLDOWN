let minus = document.querySelector("#minus");
let plus = document.querySelector("#plus");
let countInput = document.querySelector('#countInput');
let total_price = document.querySelector(".total_price");
document.addEventListener("DOMContentLoaded", function() { // 페이지 로드 완료 후 스크립트 실행
    let itemPrice = document.querySelector(".area_price").dataset.itemPrice;

    document.getElementById("plus").addEventListener("click", function() {
        let countInput = document.getElementById("countInput");
        let currentValue = parseInt(countInput.value);
        countInput.value = currentValue + 1;

        let priceSpan = document.querySelector(".area_price span");
        total_price.textContent = (itemPrice * (currentValue + 1)).toLocaleString() + "원";
        priceSpan.textContent = (itemPrice * (currentValue + 1)).toLocaleString() + "원";
    });

    document.getElementById("minus").addEventListener("click", function() {
        let countInput = document.getElementById("countInput");
        let currentValue = parseInt(countInput.value);
        if (currentValue > 1) {
            countInput.value = currentValue - 1;
        }

        let priceSpan = document.querySelector(".area_price span");
        total_price.textContent = (itemPrice * (currentValue - 1)).toLocaleString() + "원";
        priceSpan.textContent = (itemPrice * (currentValue - 1)).toLocaleString() + "원";
    });
});





let buybtn = document.querySelector("#buybtn");


buybtn.addEventListener('click', ()=>{

    if(!isUserLoggedIn){
       alert('로그인해주세요')
    }else{
        location.href = '/shop_payment'
    }


});


let likeCountElement = document.querySelector("#likeCount");

const plusLike = (itemid) => {
    if(!isUserLoggedIn) {
        alert('로그인해주세요');
    } else {
        // AJAX 요청 시작
        fetch(`/likes/${itemid}`, {
            method: 'GET',
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                likeCountElement.textContent = data;
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
};







const plusCart = (itemid) => {
    if(!isUserLoggedIn) {
        alert('로그인해주세요');
    } else {
        // AJAX 요청 시작
        let count= countInput.value;
        fetch(`/shop_cart/${itemid}/${count}`, {
            method: 'POST',
            headers: { // 헤더 조작
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ // 자바스크립트 객체를 json화 한다.
                itemid:itemid,

            }),
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                let userConfirmed = confirm("장바구니에 추가되었습니다. 장바구니 페이지로 이동하시겠습니까?");
                if (userConfirmed) {
                    location.href = '/shop_cart';
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
};










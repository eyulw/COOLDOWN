let minus = document.querySelector("#minus");
let plus = document.querySelector("#plus");
let quantityInput = document.querySelector('#quantityInput');

/*minus?.addEventListener('click', ()=>{
    let currentValue = parseInt(quantityInput.value);
    if (currentValue > 1) {
        quantityInput.value = currentValue - 1;
    }
});
plus?.addEventListener('click', ()=>{
    let currentValue = parseInt(quantityInput.value);
    quantityInput.value = currentValue + 1;
    let quantityValue = parseInt(quantityInput.value);
    let price = 199000;
    let totalPrice = price * quantityValue;
});*/

document.addEventListener("DOMContentLoaded", function() { // 페이지 로드 완료 후 스크립트 실행
    let itemPrice = document.querySelector(".area_price").dataset.itemPrice;

    document.getElementById("plus").addEventListener("click", function() {
        let quantityInput = document.getElementById("quantityInput");
        let currentValue = parseInt(quantityInput.value);
        quantityInput.value = currentValue + 1;
        let total_price = document.querySelector(".total_price");
        let priceSpan = document.querySelector(".area_price span");
        total_price.textContent = (itemPrice * (currentValue + 1)).toLocaleString() + "원";
        priceSpan.textContent = (itemPrice * (currentValue + 1)).toLocaleString() + "원";
    });

    document.getElementById("minus").addEventListener("click", function() {
        let quantityInput = document.getElementById("quantityInput");
        let currentValue = parseInt(quantityInput.value);
        if (currentValue > 1) {
            quantityInput.value = currentValue - 1;
        }
        let total_price = document.querySelector(".total_price");
        let priceSpan = document.querySelector(".area_price span");
        total_price.textContent = (itemPrice * (currentValue - 1)).toLocaleString() + "원";
        priceSpan.textContent = (itemPrice * (currentValue - 1)).toLocaleString() + "원";
    });
});



let buybtn = document.querySelector("#buybtn");
let digbtn = document.querySelector("#digbtn");

buybtn.addEventListener('click', ()=>{

    if(!isUserLoggedIn){
       alert('로그인해주세요')
    }else{
        location.href = '/shop_payment'
    }


});
digbtn.addEventListener('click', ()=>{

    if(!isUserLoggedIn){
        alert('로그인해주세요')
    }else{
        location.href = '/shop_cart'
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







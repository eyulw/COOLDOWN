/*item_detail페이지
수량*/
let minus = document.querySelector("#minus");
let plus = document.querySelector("#plus");
let countInput = document.querySelector('#countInput');
let total_price = document.querySelector(".total_price");
document.addEventListener("DOMContentLoaded", function() { // 페이지 로드 완료 후 스크립트 실행
    // let itemPrice = document.querySelector(".area_price").dataset.itemPrice;

    document.getElementById("plus")?.addEventListener("click", function() {
        let countInput = document.getElementById("countInput");
        let currentValue = parseInt(countInput.value);
        countInput.value = currentValue + 1;

        let priceSpan = document.querySelector(".area_price span");
        total_price.textContent = (itemPrice * (currentValue + 1)).toLocaleString() + "원";
        priceSpan.textContent = (itemPrice * (currentValue + 1)).toLocaleString() + "원";
    });

    document.getElementById("minus")?.addEventListener("click", function() {
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





/*구매하기*/
let buybtn = document.querySelector("#buybtn");
buybtn.addEventListener('click',()=>{
   alert("개발중인 기능입니다");
});


/*좋아요*/
let likeCountElement = document.querySelector("#likeCount");
const plusLike = (itemid) => {
    if(!isUserLoggedIn) {
        alert('로그인해주세요');
    } else {
        // AJAX 요청 시작
        fetch(`/likes/${itemid}`, {
            method: 'GET'
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






/*장바구니추가*/
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

/*장바구니페이지*/
function updateCartCountInDb(cartId, newCount) {
    fetch('/updateCartCount', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            cart_id: cartId,
            count: newCount
        })
    })
        /*.then(response => response.json())
        .then(data => {
            // 필요하다면 서버로부터의 응답을 처리
            console.log('서버 응답:', data);
        })*/
        .catch(error => {
            console.error('에러 발생:', error);
        });
}
//주문금액
function updateTotalPrice(cartId) {
    let priceDiv = document.querySelector("#cart_price_" +cartId);
    let countSpan = document.querySelector("#cart_count_" + cartId);

    let price = parseFloat(priceDiv.dataset.price);
    let count = parseInt(countSpan.innerText);

    let totalPrice = price * count;

    let totalPriceDiv = document.querySelector("#totalPrice_" + cartId);
    totalPriceDiv.innerText = totalPrice + "원";
    return totalPrice;
}
function count_plus_btn(cartId) {
    let countSpan = document.querySelector("#cart_count_" + cartId);
    if (countSpan) {
        let newCount = parseInt(countSpan.innerText) + 1;
        countSpan.innerText = newCount;
        updateCartCountInDb(cartId, newCount);
        updateTotalPrice(cartId);
        total_price1();
    }

}
function count_minus_btn(cartId) {
    let countSpan = document.querySelector("#cart_count_" + cartId);
    if (countSpan) {
        let newCount = parseInt(countSpan.innerText) - 1;
        if (newCount >= 0) { // 수량이 0 미만으로 내려가지 않도록 추가한 조건
            countSpan.innerText = newCount;
            updateCartCountInDb(cartId, newCount);
            updateTotalPrice(cartId);
            total_price1();
        }
    }
}

/*카트 총 금액*/
function total_price1() {
    let grandTotal = 0;  // 모든 카트 항목의 총 금액을 저장할 변수
    const checkboxes = document.querySelectorAll("._cartItemCheckbox");
    checkboxes.forEach(checkbox => {
        if (checkbox.checked) { // 체크박스가 체크된 상태인지 확인
            const cartId = checkbox.getAttribute('data-cart-id'); // 체크박스의 data-cart-id 속성을 가져옴
            grandTotal += updateTotalPrice(cartId);
        }
    });

    // grandTotal을 원하는 위치에 표시합니다.
    // 예를 들어, 총 금액을 표시할 요소의 ID가 "grandTotalElement"라면:
    let total_price = document.querySelector("#total_price");
    let cart_total = document.querySelector("#cart_total");
    cart_total.innerText = grandTotal + "원";
    total_price.innerText = grandTotal + "원";
    document.getElementById('cart_total_data').value = grandTotal;
}
document.addEventListener("DOMContentLoaded", function() {
   total_price1();
});

document.addEventListener("DOMContentLoaded", function() {
    const checkboxes = document.querySelectorAll("._cartItemCheckbox");
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', total_price1);
    });
});

const selectAllCheckbox = document.querySelector("#selectAllCheckbox");

// 모든 체크박스를 가져옵니다.
const allCheckboxes = document.querySelectorAll("input[type='checkbox']");







/*제거버튼*/
document.addEventListener("DOMContentLoaded", function() {
    // 모든 cart-item-remove 클래스를 가진 span 요소를 선택합니다.
    const removeSpans = document.querySelectorAll(".cart-item-remove");

    removeSpans.forEach(span => {
        span.addEventListener('click', function() {
            // span의 ID에서 cart_id 부분만 추출합니다.
            const cartId = this.id.split('_').pop();

            // 해당 cartId로 카트 항목을 삭제하는 함수를 호출합니다.
            removeCartItem(cartId);
        });
    });
});
function removeCartItem(cartId) {
    fetch('/removeCart', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            cart_id: cartId,
        })
    })
        .then(response => {
            // 요청이 성공적으로 처리되면
            const cartItemElement = document.getElementById(`remove_cart_${cartId}`);
            if(cartItemElement) {
                cartItemElement.closest('tr').remove();//가장 가까운 tr요소를 제거
            }
        })
        .catch(error => {
            console.error('에러 발생:', error);
        });
}

/*장바구니주문버튼*/

let checkboxes = document.querySelectorAll('input[type="checkbox"]');

checkboxes.forEach(checkbox => {
    checkbox.addEventListener('change', updateValues);


});

function updateValues() {
    let cart_ids = [];
    let prices = [];
    let counts = [];
    let srcs = [];
    let itemnames = [];

    checkboxes.forEach(checkbox => {
        let cartId = checkbox.getAttribute('data-cart-id');
        let price = document.querySelector(`#cart_price_${cartId}`).textContent;
        price = price.replace(/원/g, "");  // 모든 "원" 문자 제거
        let count = document.querySelector(`#cart_count_${cartId}`).textContent;
        let itemname = document.querySelector(`#itemname_${cartId}`).textContent;
        let src = document.querySelector(`#cart_image_${cartId}`).getAttribute('src');


        if (checkbox.checked) {
            cart_ids.push(cartId);
            prices.push(price);
            counts.push(count);
            srcs.push(src);
            itemnames.push(itemname);


        }
    });

    document.getElementById('cartId').value = cart_ids;
    document.getElementById('price').value = prices;
    document.getElementById('count').value = counts;
    document.getElementById('src').value = srcs;
    document.getElementById('itemname').value = itemnames;


}






let buy_e = document.querySelector("#buy_e");
let item_e = document.querySelector("#item_e");

buy_e.addEventListener('click',()=>{
    alert("개발중인 기능입니다");
});
item_e.addEventListener('click',()=>{
    alert("개발중인 기능입니다");
});

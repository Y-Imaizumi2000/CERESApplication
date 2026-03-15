/**
 * CAAF0001 クライアント処理
 */

// ---------------------------------------------
// イベント登録
// ---------------------------------------------
document.getElementById("regInquiryInfo").addEventListener("submit", handleSubmit);


// ---------------------------------------------
// メイン処理
// ---------------------------------------------
function handleSubmit(e) {
    e.preventDefault();

    const inquiryType   = document.querySelector('input[inquiryType="inquiryType"]').value.trim();
    const message = document.querySelector('input[message="message"]').value.trim();
    const errors = [];

    clearErrorArea();

    // --- 問い合わせ情報の登録） ---
    regInquiryInfo(inquiryType, message);
}

// ---------------------------------------------
// サーバー通信
// ---------------------------------------------
function regInquiryInfo(inquiryType, message) {
	ApiClient.post("/regInquiryInfo", {inquiryType, message})
    .then(result => {
        if (!result.success) {
            displayErrors(result.errors);
            return;
        }

        console.log("登録成功");
        alert("登録が完了しました。登録内容は一覧画面から確認できます。");

    })
    .catch(err => {
        console.error("通信エラー:", err);
		alert("登録エラー。システム管理者へ連絡してください。");
    });
}


// ---------------------------------------------
// エラー表示
// ---------------------------------------------
function clearErrorArea() {
    document.getElementById("errorMessage").innerHTML = "";
}

function displayErrors(errors) {
	if (!errors) return;
    const errorArea = document.getElementById("errorMessage");
    const ul = document.createElement("ul");

    ul.style.color = "red";
    ul.style.margin = "0";
    ul.style.padding = "0 0 0 20px";

    errors.forEach(msg => {
        const li = document.createElement("li");
        li.textContent = msg;
        ul.appendChild(li);
    });

    errorArea.appendChild(ul);
}

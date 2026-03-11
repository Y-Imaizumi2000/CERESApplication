/**
 * CAAB0001 クライアント処理
 */

// ---------------------------------------------
// イベント登録
// ---------------------------------------------
document.getElementById("regUser").addEventListener("submit", handleSubmit);


// ---------------------------------------------
// メイン処理
// ---------------------------------------------
function handleSubmit(e) {
    e.preventDefault();

    const name   = document.querySelector('input[name="name"]').value.trim();
    const pass = document.querySelector('input[name="pass"]').value.trim();
	const dob = document.querySelector('input[name="dob"]').value.trim();
	const telNo = document.querySelector('input[name="telNo"]').value.trim();
	const confirmPass = document.querySelector('input[name="confirmPass"]').value.trim();
    const errors = [];

    clearErrorArea();

    // --- クライアント側バリデーション ---
    checkValid(name, pass, confirmPass, errors);

    if (errors.length > 0) {
        displayErrors(errors);
        return;
    }

    // --- ユーザー情報の登録） ---
    regUserInfo(name, dob, telNo, pass);
}


// ---------------------------------------------
// バリデーション
// ---------------------------------------------
function checkValid(name, pass, confirmPass, errors) {
    if (pass !== confirmPass) {
        errors.push("パスワードと確認用パスワードが一致しません。");
    }
}


// ---------------------------------------------
// サーバー通信
// ---------------------------------------------
function regUserInfo(name, dob, telNo, pass) {
	ApiClient.post("/regUserInfo", {
        name,
        dob,
        telNo,
        pass
    })
    .then(result => {

        if (!result.success) {
            displayErrors(result.errors);
            return;
        }

        console.log("登録成功");
        alert("登録が完了しました。お客さまのユーザーIDは「" + result.userId + "」です。");

    })
    .catch(err => {
        console.error("通信エラー:", err);
    });
}


// ---------------------------------------------
// エラー表示
// ---------------------------------------------
function clearErrorArea() {
    document.getElementById("errorMessage").innerHTML = "";
}

function displayErrors(errors) {
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

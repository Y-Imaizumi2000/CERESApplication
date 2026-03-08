/**
 * CAAA0001 クライアント処理
 */

// ---------------------------------------------
// イベント登録
// ---------------------------------------------
document.getElementById("loginForm").addEventListener("submit", handleSubmit);


// ---------------------------------------------
// メイン処理
// ---------------------------------------------
function handleSubmit(e) {
    e.preventDefault();

    const id = document.querySelector('input[name="id"]').value.trim();
    const pass = document.querySelector('input[name="pass"]').value.trim();
    const errors = [];

    clearErrorArea();

    // --- クライアント側バリデーション ---
    validateId(id, errors);
    validatePassword(pass, errors);

    if (errors.length > 0) {
        displayErrors(errors);
        return;
    }

    // --- サーバー側チェック（非同期） ---
    sendLoginRequest(id, pass);
}


// ---------------------------------------------
// バリデーション
// ---------------------------------------------
function validateId(id, errors) {
    if (id.length !== 9) {
        errors.push("IDは9桁で入力してください。");
    }
}

function validatePassword(pass, errors) {
    if (pass.length < 7) {
        errors.push("パスワードは7桁以上で入力してください。");
    }
}


// ---------------------------------------------
// サーバー通信
// ---------------------------------------------
function sendLoginRequest(id, pass) {
    fetch("http://localhost:8081/validLoginUser", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ id, pass })
    })
        .then(res => res.json())
        .then(result => {
            if (!result.success) {
                displayErrors(result.errors);
                return;
            }

            if (!result.validFlg) {
                console.log("ログイン失敗");
                errors.push("ユーザーが存在しませんでした。");
            } else {
                console.log("ログイン成功");
                location.href = "/html/app/CAAD0001.html";
            }

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

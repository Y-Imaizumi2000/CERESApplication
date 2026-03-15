/**
 * CAAC0001 クライアント処理
 */

// ---------------------------------------------
// ログインユーザーの取得
// ---------------------------------------------
document.addEventListener("DOMContentLoaded", () => {
    const loginUserId = sessionStorage.getItem("loginUserId");

    // 未ログインならログイン画面へ戻す
    if (!loginUserId) {
        window.location.href = "/html/app/LAAA0001.html";
        return;
    }

    // ヘッダーに表示
    document.getElementById("login-user-id").textContent = `ID: ${loginUserId}`;
});

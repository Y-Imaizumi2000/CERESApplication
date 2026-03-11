/**
 * API通信共通クラス
 */
class ApiClient {

    static getBaseUrl() {
        // 環境によってURL切替
        if (window.location.hostname === "localhost") {
            return "http://localhost:8080";
        } else {
            return "https://ceresapplication-production.up.railway.app";
        }
    }

    static async post(path, data) {
        const response = await fetch(`${this.getBaseUrl()}${path}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        return response.json();
    }

    static async get(path) {
        const response = await fetch(`${this.getBaseUrl()}${path}`);
        return response.json();
    }
}
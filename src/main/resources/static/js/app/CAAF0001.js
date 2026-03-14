async function sendMessage() {
  const input = document.getElementById("messageInput");
  const chatBox = document.getElementById("chatBox");

  if (input.value.trim() === "") return;

  // 自分のメッセージを表示
  addMessage(input.value, "user");

  // AI に送信
  const response = await fetch("https://your-backend-url/chat", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ message: input.value })
  });

  const data = await response.json();

  // AI の返答を表示
  addMessage(data.reply, "ai");

  input.value = "";
}

function addMessage(text, sender) {
  const chatBox = document.getElementById("chatBox");
  const msg = document.createElement("div");

  msg.className = sender === "user" ? "chat-message user" : "chat-message ai";
  msg.textContent = text;

  chatBox.appendChild(msg);
  chatBox.scrollTop = chatBox.scrollHeight;
}

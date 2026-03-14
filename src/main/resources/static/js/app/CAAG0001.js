const title = document.getElementById("calendar-title");
const daysContainer = document.getElementById("calendar-days");
const prevBtn = document.getElementById("prev-month");
const nextBtn = document.getElementById("next-month");

let current = new Date();

function renderCalendar(date) {
  daysContainer.innerHTML = "";
  const year = date.getFullYear();
  const month = date.getMonth();

  title.textContent = `${year} / ${month + 1}`;

  const firstDay = new Date(year, month, 1).getDay();
  const lastDate = new Date(year, month + 1, 0).getDate();

  // 空白（前月分）
  for (let i = 0; i < firstDay; i++) {
    const empty = document.createElement("div");
    daysContainer.appendChild(empty);
  }

  // 日付
  for (let d = 1; d <= lastDate; d++) {
    const cell = document.createElement("div");
    cell.className = "calendar-day";
    cell.innerHTML = `<span>${d}</span>`;
    daysContainer.appendChild(cell);
  }
}

prevBtn.onclick = () => {
  current.setMonth(current.getMonth() - 1);
  renderCalendar(current);
};

nextBtn.onclick = () => {
  current.setMonth(current.getMonth() + 1);
  renderCalendar(current);
};

renderCalendar(current);
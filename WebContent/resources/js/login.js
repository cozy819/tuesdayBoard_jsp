const adminLoginButton = document.querySelector("#adminLogin");
const clientLoginButton = document.querySelector("#clientLogin");
const form = document.querySelector("form");

function adminLogin() {
  console.log("adminLogin");
  form.action = "/board?cmd=AdminLogin";
}
function clientLogin() {
  console.log("clientLogin");
  form.action = "/board?cmd=ClientLogin";
}
function init() {
  adminLoginButton.addEventListener("click", adminLogin);
  clientLoginButton.addEventListener("click", clientLogin);
}

init();
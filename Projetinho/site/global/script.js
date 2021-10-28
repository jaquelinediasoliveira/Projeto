let toindex = document.querySelector("#logo")
let tologin = document.querySelector("#tologin")

if (toindex !== null) {
    toindex.addEventListener("click", () => {
        window.location.href = "/index"
    })
}

if (tologin !== null) {
    tologin.addEventListener("click", () => {
        window.location.href = "/login"
    })
}
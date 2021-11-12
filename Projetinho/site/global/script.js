var local = localStorage.getItem('id_cliente')
var ulSair = document.querySelector('.menu-login')

let toindex = document.querySelector("#logo")
let tologin = document.querySelector("#tologin")
let tousuario = document.querySelector("#tousuario")
let tocadastrar = document.querySelector("#tocadastrar")

if (local !== null) {
    tologin.innerHTML = localStorage.getItem("id_cliente")

    let iconNome = document.createElement("i")
    iconNome.className = "fa fa-user"
    tologin.id = 'reverse-fix'
    ulSair.appendChild(iconNome)
    tologin.appendChild(iconNome)

    let sair = document.createElement("li")
    sair.innerHTML = "Sair";
    sair.id = 'reverse-fix'
    sair.addEventListener("click", () => {
        localStorage.clear()
        window.location.href = "/index"
    })
    ulSair.appendChild(sair)

    let iconSair = document.createElement("i")
    iconSair.className = "fa fa-sign-out"
    ulSair.appendChild(iconSair)
    sair.appendChild(iconSair)
}

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

if (tocadastrar !== null) {
    tocadastrar.addEventListener("click", () => {
        window.location.href = "/cadastro"
    })
}
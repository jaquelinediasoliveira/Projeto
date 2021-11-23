var cliente = localStorage.getItem('id_cliente')

var toindex = document.querySelector("#logo")
// var tologin = document.querySelector("#tologin")
var toperfil = document.querySelector("#toperfil")
var tousuario = document.querySelector("#tousuario")
var tocadastrar = document.querySelector("#tocadastrar")
var toreservas = document.querySelector('#toreservas')
var menulogin = document.querySelector('.menu-login')

if (cliente != null) {

    let perfil = document.createElement("li")
    perfil.innerHTML = localStorage.getItem("email")
    perfil.id = 'toperfil'
    perfil.addEventListener("click", () => {
        window.location.href = "/perfil"
    })
    menulogin.appendChild(perfil)

    let iconNome = document.createElement("i")
    iconNome.className = "fa fa-user"
    menulogin.appendChild(iconNome)
    perfil.appendChild(iconNome)

    let reservas = document.createElement("li")
    reservas.innerHTML = "Minhas Reservas";
    reservas.id = 'toreservas'
    reservas.addEventListener("click", () => {
        window.location.href = "/reservas"
    })
    menulogin.appendChild(reservas)

    let iconReservas = document.createElement("i")
    iconReservas.className = "fa fa-list"
    menulogin.appendChild(iconReservas)
    reservas.appendChild(iconReservas)

    let sair = document.createElement("li")
    sair.innerHTML = "Sair";
    sair.id = 'reverse-fix'
    sair.addEventListener("click", () => {
        localStorage.clear();
        window.location.href = "/index"
    })
    menulogin.appendChild(sair)

    let iconSair = document.createElement("i")
    iconSair.className = "fa fa-sign-out"
    menulogin.appendChild(iconSair)
    sair.appendChild(iconSair)

} else {

    let entrar = document.createElement("li")
    entrar.innerHTML = "Entrar";
    entrar.id = 'tologin'
    entrar.addEventListener("click", () => {
        window.location.href = "/login"
    })
    menulogin.appendChild(entrar)

    let iconentrar = document.createElement("i")
    iconentrar.className = "fa fa-user"
    entrar.appendChild(iconentrar)

}

if (toindex !== null) {
    toindex.addEventListener("click", () => {
        window.location.href = "/index"
    })
}

if (toperfil !== null) {
    toperfil.addEventListener("click", () => {
        window.location.href = "/perfil"
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

if (toreservas !== null) {
    toreservas.addEventListener("click", () => {
        window.location.href = "/reservas"
    })
}
const listadeveiculos = document.querySelector(".listadeveiculos")
let tipoveiculos = localStorage.getItem("tipo_veiculo")
let imgheader = localStorage.getItem("tipo_veiculo")
// localStorage.setItem("tipo_veiculo", 8)
console.log(tipoveiculos)

let tocarros = document.querySelector("#tocarros")
let tomotos = document.querySelector("#tomotos")
let tocaminhoes = document.querySelector("#tocaminhoes")
let tojatos = document.querySelector("#tojatos")
let tohelicop = document.querySelector("#tohelicop")
let tolanchas = document.querySelector("#tolanchas")
let tojetski = document.querySelector("#tojetski")
let toiate = document.querySelector("#toiate")


if (tipoveiculos == null) {
    let carousel = document.querySelector(".carousel")
    let imgheader = document.createElement('img')
    imgheader.id = "img1"
    imgheader.src = "../img/sg_jeep_compass-1.png"
    carousel.appendChild(imgheader)  
} else {
    let carousel = document.querySelector(".carousel")
    let imgheader = document.createElement('img')
    imgheader.id = "img1"
    imgheader.src = localStorage.getItem("imgheader")
    carousel.appendChild(imgheader)
}

tocarros.addEventListener("click", () => {
    localStorage.setItem("tipo_veiculo", "Carro")
    localStorage.setItem("qnt_veiculo", 8)
    localStorage.setItem("uma", "um")
    localStorage.setItem("imgheader", "../img/sg_jeep_compass-1.png")
    document.location.reload(true)
})
tomotos.addEventListener("click", () => {
    localStorage.setItem("tipo_veiculo", "Moto")
    localStorage.setItem("qnt_veiculo", 3)
    localStorage.setItem("uma", "uma")
    localStorage.setItem("imgheader", "../img/moto.png")
    document.location.reload(true);
})
tocaminhoes.addEventListener("click", () => {
    localStorage.setItem("tipo_veiculo", "Caminhão")
    localStorage.setItem("qnt_veiculo", 5)
    localStorage.setItem("uma", "um")
    localStorage.setItem("imgheader", "../img/caminhao.png")
    document.location.reload(true);
})
tojatos.addEventListener("click", () => {
    localStorage.setItem("tipo_veiculo", "Jato")
    localStorage.setItem("qnt_veiculo", 2)
    localStorage.setItem("uma", "um")
    localStorage.setItem("imgheader", "../img/private-jet-png-2.png")
    document.location.reload(true);
})
tohelicop.addEventListener("click", () => {
    localStorage.setItem("tipo_veiculo", "Helicóptero")
    localStorage.setItem("qnt_veiculo", 3)
    localStorage.setItem("uma", "um")
    localStorage.setItem("imgheader", "../img/helicoptero-2.png")
    document.location.reload(true);
})
tolanchas.addEventListener("click", () => {
    localStorage.setItem("tipo_veiculo", "Lancha")
    localStorage.setItem("qnt_veiculo", 6)
    localStorage.setItem("uma", "uma")
    localStorage.setItem("imgheader", "../img/lancha.png")
    document.location.reload(true);
})
tojetski.addEventListener("click", () => {
    localStorage.setItem("tipo_veiculo", "Jet Ski")
    localStorage.setItem("qnt_veiculo", 2)
    localStorage.setItem("uma", "um")
    localStorage.setItem("imgheader", "../img/blue-jet-ski.png")
    document.location.reload(true);
})
toiate.addEventListener("click", () => {
    localStorage.setItem("tipo_veiculo", "Iate")
    localStorage.setItem("qnt_veiculo", 5)    
    localStorage.setItem("uma", "um")
    localStorage.setItem("imgheader", "../img/Luxury-Iate.png")
    document.location.reload(true);
})


let spanveiculo = document.querySelector("#spanveiculo")
spanveiculo.innerHTML = tipoveiculos

let uma = document.querySelector("#uma")
uma.innerHTML = localStorage.getItem("uma")

// const url = "http://10.87.202.133:8080/locacao/veiculos?busca=" + localStorage.getItem("buscar")
// const modelo = document.querySelector(".modelo")
// const preco = document.querySelector("#preco")

// fetch(url)
//     .then(resp => { return resp.json() })
//     .then(data => {
//         if (data.length > 0) {
//             localStorage.setItem("marca", data[0].marca)
//             localStorage.setItem("cor", data[0].cor)
//             localStorage.setItem("id_tipo", data[0].id_tipo)
//             localStorage.setItem("modelo", data[0].modelo)
//             localStorage.setItem("preco", data[0].preco)
//             localStorage.setItem("placa", data[0].placa)
//         }
//     })
//     .catch(err => { console.log(err) })

function alugar() {
    let local = document.querySelector("#local")
    let retirada = document.querySelector("#retirada")
    let horaretirada = document.querySelector("#horaretirada")
    let devolucao = document.querySelector("#devolucao")
    let horadevolucao = document.querySelector("#horadevolucao")
    localStorage.setItem("local", local.value)
    localStorage.setItem("retirada", retirada.value)
    localStorage.setItem("horaretirada", horaretirada.value)
    localStorage.setItem("devolucao", devolucao.value)
    localStorage.setItem("horadevolucao", horadevolucao.value)
}

let cidade = localStorage.getItem("local")


let vei = localStorage.getItem("qnt_veiculo")

for (let i = 0; i < vei; i++) {
    let card = document.createElement("div")
    card.className = 'card'
    card.addEventListener("click", () => {
        window.location.href = "/reservas"
    })

    let titulocard = document.createElement("h2")
    // titulocard.innerHTML = localStorage.getItem("modelo")
    titulocard.innerHTML = tipoveiculos
    titulocard.className = 'modelo'

    let img = document.createElement('img')
    img.src = localStorage.getItem("imgheader")
    // img.src = "http://10.87.202.133:8080/locacao/img01.png"

    let div = document.createElement("div")

    let apartir = document.createElement("p")
    apartir.innerHTML = "A partir de"

    let precocard = document.createElement("div")
    precocard.className = 'diaria'

    let cifrao = document.createElement("span")
    cifrao.innerHTML = "R$"

    let getPreco = document.createElement("span")
    getPreco.innerHTML = localStorage.getItem("preco")
    getPreco.className = 'diaria'

    let diaria = document.createElement("span")
    diaria.innerHTML = "/Diária"

    card.appendChild(titulocard)

    div.appendChild(apartir)
    precocard.appendChild(cifrao)
    precocard.appendChild(getPreco)
    precocard.appendChild(diaria)
    div.appendChild(precocard)
    card.appendChild(img)
    card.appendChild(div)
    listadeveiculos.appendChild(card)
}

let confirmar = document.querySelector(".confirmar")

// let locall = document.querySelector("#locall")
// let retiradaa = document.querySelector("#retiradaa")
// let devolucaoo = document.querySelector("#devolucaoo")

if (cidade !== null) {

    let locall = document.createElement("div")
    let plocall = document.createElement("p")
    plocall.innerHTML = "Local:"
    let spanlocall = document.createElement("span")
    spanlocall.innerHTML = localStorage.getItem("local")
    locall.appendChild(plocall)
    locall.appendChild(spanlocall)
    confirmar.appendChild(locall)
    
    let retiradaa = document.createElement("div")
    let pretiradaa = document.createElement("p")
    pretiradaa.innerHTML = "Retirada:"
    let spanretiradaa = document.createElement("span")
    spanretiradaa.innerHTML = localStorage.getItem("retirada")
    retiradaa.appendChild(pretiradaa)
    retiradaa.appendChild(spanretiradaa)
    confirmar.appendChild(retiradaa)
    
    let devolucaoo = document.createElement("div")
    let pdevolucaoo = document.createElement("p")
    pdevolucaoo.innerHTML = "Devolucao:"
    let spandevolucaoo = document.createElement("span")
    spandevolucaoo.innerHTML = localStorage.getItem("devolucao")
    devolucaoo.appendChild(pdevolucaoo)
    devolucaoo.appendChild(spandevolucaoo)
    confirmar.appendChild(devolucaoo)
}
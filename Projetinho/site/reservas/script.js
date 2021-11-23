let local = document.querySelector("#local")
let retirada = document.querySelector("#retirada")
let devolucao = document.querySelector("#devolucao")
let preco = document.querySelector("#preco")
let title = document.querySelector("#title")
let img = document.querySelector("#img")


local.innerHTML = localStorage.getItem("local")
retirada.innerHTML = localStorage.getItem("retirada")
devolucao.innerHTML = localStorage.getItem("devolucao")
title.innerHTML = localStorage.getItem("tipo_veiculo")
img.src = localStorage.getItem("imgheader")
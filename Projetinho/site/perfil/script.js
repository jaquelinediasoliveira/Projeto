const url = "http://10.87.202.133:8080/locacao/clientes?id_cliente=" + localStorage.getItem("id_cliente")
const nome = document.querySelector("#nome")
const cpf = document.querySelector("#cpf")
const telefone = document.querySelector("#telefone")
const endereco = document.querySelector("#endereco")
const cep = document.querySelector("#cep")

const email = document.querySelector("#email")
const senha = document.querySelector("#senha")

fetch(url)
    .then(resp => { return resp.json() })
    .then(data => {
        if (data.length > 0) {
            localStorage.setItem("nome_completo", data[0].nome_completo)
            localStorage.setItem("cpf", data[0].cpf)
            localStorage.setItem("telefone", data[0].telefone)
            localStorage.setItem("endereco", data[0].endereco)
            localStorage.setItem("cep", data[0].cep)
        }
    })
    .catch(err => { console.log(err) })

nome.innerHTML = localStorage.getItem("nome_completo")
cpf.innerHTML = localStorage.getItem("cpf")
telefone.innerHTML = localStorage.getItem("telefone")
endereco.innerHTML = localStorage.getItem("endereco")
cep.innerHTML = localStorage.getItem("cep")

email.innerHTML = localStorage.getItem("email")
senha.innerHTML = localStorage.getItem("senha")


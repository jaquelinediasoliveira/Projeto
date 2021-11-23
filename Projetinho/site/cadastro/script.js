function cadastrar() {

    let inputNome = document.querySelector("#nome").value
    let inputCpf = document.querySelector("#input-cpf").value
    let inputTelefone = document.querySelector("#input-telefone").value
    let inputNascimento = document.querySelector("#input-nascimento").value
    let inputEndereco = document.querySelector("#input-endereco").value
    let inputCep = document.querySelector("#input-cep").value
    let inputEmail = document.querySelector("#input-email").value
    let inputSenha = document.querySelector("#input-senha").value

    // let url = "http://10.87.202.133:8080/locacao/clientes?cpf=" + inputNome + inputCpf + inputTelefone + inputNascimento
    // inputEndereco + inputCep + inputEmail + inputSenha

    localStorage.setItem("nome", inputNome)
    console.log(inputNome)
}
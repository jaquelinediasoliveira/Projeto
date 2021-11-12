function login() {

    let email = document.querySelector("#email").value

    let url = "http://10.87.202.133:8080/locacao/usuarios?email=" + email

    fetch(url)
        .then((resp) => { return resp.json() })
        .then(data => {
            if (data.length > 0) {
                localStorage.setItem("id_cliente", data[0].id_cliente)
                localStorage.setItem("id_usuario", data[0].id_usuario)
                localStorage.setItem("id_funcionario", data[0].id_funcionario)
                localStorage.setItem("senha", data[0].senha)
                localStorage.setItem("nome_completo", data[0].nome_completo)
                window.location.href = "/index"

                // if (cliente == senha) {
                // } else {
                //     alert("Usuário não cadastrado!")
                // }

            } else {
                alert("Usuário não cadastrado!")
            }
        })
        .catch(err => { console.log(err) })

    localStorage.clear();

}





















// async function login() {

//     let cpf = document.querySelector("#cpf").value

//     try {

//         const url = "http://10.87.202.133:8080/locacao/clientes";

//         const response = await fetch(url);
//         const data = await response.json();

//         console.log(data);
//     } catch (err) {
//         console.log(err)
//     }

//     let url = "http://10.87.202.133:8080/locacao/clientes?cpf=" + cpf
// }

// function init() {
//     login();
// }

// (init)();
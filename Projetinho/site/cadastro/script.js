function login() {

    let cpf = document.querySelector("#cpf").value

    let url = "http://10.87.202.133:8080/locacao/clientes?cpf=" + cpf


    fetch(url)
        .then((resp) => { return resp.json() })
        .then(data => {
            if (data.length > 0) {
                localStorage.setItem("id_cliente", data[0].id_cliente)
                localStorage.setItem("nome_completo", data[0].nome_completo)
                window.location.href = "/index"
            } else {
                alert("Usuário não cadastrado!")
            }
        })
        .catch(err => { console.log(err) })
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
// function login() {
//     let email = document.querySelector("#email").value

//     let url = "http://10.87.202.133:8080/locacao/clientes?email=" + email

//     fetch(url)
//         .then((resp) => { return resp.json() })
//         .then(data => {
//             if (data.length > 0) {
//                 localStorage.setItem("cpf_passaporte", data[0].cpf_passaporte)
//                 localStorage.setItem("nome_completo", data[0].nome_completo)
//                 window.location.href = "/login"
//             } else {
//                 alert("Usuário não cadastrado!")
//             }
//         })
//         .catch(err => { console.log(err) })
// }
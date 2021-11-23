function login() {

    let email = document.querySelector("#email")
    let senha = document.querySelector("#senha")

    let url = "http://10.87.202.133:8080/locacao/usuarios?email=" + senha.value + email.value

    fetch(url)
        .then((resp) => { return resp.json() })
        .then(data => {
            if (data.length > 0) {
                localStorage.setItem("buscar", "TODOS")
                localStorage.setItem("email", data[0].email)
                localStorage.setItem("id_cliente", data[0].id_cliente)
                localStorage.setItem("id_usuario", data[0].id_usuario)
                localStorage.setItem("id_funcionario", data[0].id_funcionario)
                localStorage.setItem("senha", data[0].senha)
                email.value = ""
                senha.value = ""
                window.location.href = "/index";

            } else {
                alert("Usuário não cadastrado!")
            }
        })
        .catch(err => { console.log(err) });

    localStorage.clear();
}
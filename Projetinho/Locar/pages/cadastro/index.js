import React, { useState } from 'react';
import { View, Text, TouchableOpacity, TextInput, ScrollView } from 'react-native';
import css from "./style"
import global from '../global/style'

export default function Reservas({navigation}){
    const url = "http://10.87.202.133:8080/locacao/clientes";
    const [cpf, setCpf] = useState("");
    const [passaporte, setPassaporte] = useState("");
    const [nomeCompleto, setNomeCompleto] = useState("");
    const [telefone, setTelefone] = useState("");
    const [nascimento, setNascimento] = useState("");
    const [email, setEmail] = useState("");
    const [endereco, setEndereco] = useState("");
    const [cep, setCep] = useState("");
    const [senha, setSenha] = useState("");

    const cadastrar = () => {
        fetch(`${url}?id_cliente=${data.id_cliente}`, {
            method: "post",
            body: {
                cpf: cpf,
                passaporte: passaporte,
                nome_completo: nomeCompleto,
                telefone: telefone,
                data_nascimento: nascimento,
                email: email,
                endereco: endereco,
                cep: cep,
                senha: senha,
                tipo_usuario: false,
                logOn: false
            }
        })
        .then((resp) => { return resp.json() })
        .then(data => {
            setListaReserva(data);
        })
        .catch(err => { console.log(err) });

    }

    return(
        <View style={global.tela}>
            <View style={css.texto}>
                <Text style={css.font}>Insira seus Dados</Text>
            </View>
            <View style={css.scroll}>
                <ScrollView>
                    <TextInput placeholder="CPF" style={css.input} value={cpf} onChangeText={setCpf}/>
                    <TextInput placeholder="Passaporte" style={css.input} value={passaporte} onChangeText={setPassaporte}/>
                    <TextInput placeholder="Nome Completo" style={css.input} value={nomeCompleto} onChangeText={setNomeCompleto}/>
                    <TextInput placeholder="Telefone" style={css.input} value={telefone} onChangeText={setTelefone}/>
                    <TextInput placeholder="Data de Nascimento" style={css.input} value={nascimento} onChangeText={setNascimento}/>
                    <TextInput placeholder="E-mail" style={css.input} value={email} onChangeText={setEmail}/>
                    <TextInput placeholder="Endereço" style={css.input} value={endereco} onChangeText={setEndereco}/>
                    <TextInput placeholder="CEP" style={[css.input, {width: '60%'}]} value={cep} onChangeText={setCep}/>
                    <TextInput placeholder="Senha" style={css.input} value={senha} onChangeText={setSenha}/>
                    <TouchableOpacity style={css.entrar} onPress={() => cadastrar()}>
                        <Text style={css.botao}>Entrar</Text>
                    </TouchableOpacity>
                </ScrollView>
            </View>
        </View>
    )
}
import React,{useState, useEffect} from 'react';
import { View, Text, TouchableOpacity, TextInput,ScrollView} from 'react-native';
import css from "./style"
import global from '../global/style'

import Navbar from '../components/navbar'
import { AntDesign } from '@expo/vector-icons';

import AsyncStorage from '@react-native-async-storage/async-storage';

export default function Perfil({navigation}) {
    const url = "http://10.87.202.133:8080/locacao/clientes";
    const [listaCliente, setListaCliente] = useState([]);
    const [alerta, setAlerta] = useState("");
    const [email, setEmail] = useState("");

    useEffect(() => {
    }, []);

    const formatDate = (nasc) => {
        let dia = nasc.getDate();
        dia = (dia < 10) ? "0" + dia : dia;
        let mes = nasc.getMonth() + 1;
        mes = (mes < 10) ? "0" + mes : mes;
        let ano = nasc.getFullYear();
        return `${dia}/${mes}/${ano}`;
     }

    const handleNavigate = (tela) => {
        navigation.navigate(tela);
    }

    const login = () => {
        // fetch(`${url}?email=${email}&senha=${senha}`)
        //     .then((resp) => { return resp.json() })
        //     .then(data => {
        //         //{id_cliente:10,nome_completo:'Fulano'}
        //         if(data.id_cliente == undefined) {
        //             setAlerta("E-mail ou senha inválidos !");
        //         }else {
        //             AsyncStorage.setItem("cliente", JSON.stringify(data))

        //             let cli = JSON.parse( AsyncStorage.getItem("cliente") );

        //             cli.id_cliente
        //         }
        //     })
        //     .catch(err => { console.log(err) });
    }

    // const usuarios = [
    //     {
    //         'nome_completo': 'Laricoste da Silva',
    //         'data_nascimento': '21/03/2002',
    //         'telefone': '4002-8922',
    //         'endereco': 'Rua das Gostosas',
    //         'cep': '13920-000'
    //     }
    // ]

    return (
        <View style={global.tela}>
            
            <View style={global.header}>
                <Text style={global.title}>Usuário</Text>
            </View>

            <View style={global.body}>
                <ScrollView>
                    {/* {
                        usuarios.map((item, index) => {
                            return(
                                <View style={{width: 380}} key={index}>
                                    <Text style={global.question}>Bem-Vindo!</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>Nome:  {item.nome_completo}</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>Nascimento:  {item.data_nascimento}</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>Telefone:  {item.telefone}</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>Endereço:  {item.endereco}</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>CEP:  {item.cep}</Text>
                                    <View style={{marginTop: 30}}>
                                        <Text style={{color: 'gray'}}>Para editar as informações é necessário entrar no nosso site</Text>
                                    </View>
                                </View>   
                            )
                        })
                    } */}
                    {
                        (listaCliente.length === 0)
                        ?
                            <View>
                                <Text style={global.question}>Login</Text>
                                <View style={css.login}>
                                    <Text style={css.text} >Insira seu documento</Text>
                                    <TextInput placeholder="E-mail" style={css.input} value={email} onChangeText={(e) => {
                                        setEmail(e.value);
                                    }}/>
                                    <TextInput secureTextEntry={true} placeholder="Senha" style={css.input}/>
                                    <Text style={[(alerta == "") ? {marginBottom: -40} : {color: 'red'}]}>{alerta}</Text>
                                    <TouchableOpacity style={css.entrar} onPress={() => login()}>
                                        <Text style={css.text}>Entrar</Text>
                                    </TouchableOpacity>
                                </View>
                                <Text style={global.question}>Ainda não possui cadastro?</Text>
                                <TouchableOpacity style={css.botao}>
                                    <Text style={css.text} onPress={() => handleNavigate("Cadastro")}>Cadastrar</Text>
                                </TouchableOpacity>
                            </View>
                        :
                            
                        listaCliente.map((item,index) => {
                            return (
                                <View style={{width: 380}} key={index}>
                                    <Text style={global.question}>Bem-Vindo!</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>Nome:  {item.nome_completo}</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>Nascimento:  {formatDate(new Date(item.data_nascimento))}</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>Telefone:  {item.telefone}</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>Endereço:  {item.endereco}</Text>
                                    <Text style={[css.text, {marginBottom: 10}]}>CEP:  {item.cep}</Text>
                                    <View style={{marginTop: 30}}>
                                        <Text style={{color: 'gray'}}>Para editar as informações é necessário entrar no nosso site</Text>
                                    </View>
                                </View>       
                            )
                        })
                            
                    }
                </ScrollView>
            </View>

            <Navbar
                navigation={navigation}
                screen="User"
            />
        </View>
    );
}
import React,{useState} from 'react';
import { View, Text, TouchableOpacity, TextInput,ScrollView, ImageEditor} from 'react-native';
import css from "./style"
import global from '../global/style'

import Navbar from '../components/navbar'
import { AntDesign } from '@expo/vector-icons';

import AsyncStorage from '@react-native-async-storage/async-storage';

export default function Perfil({navigation}) {
    // const url = "http://10.87.202.133:8080/locacao/clientes";
    const [listaCliente, setListaCliente] = useState([]);

    const login = () => {

    }

    const handleNavigate = (tela) => {
        navigation.navigate(tela);
    }

    return (
        <View style={global.tela}>
            
            <View style={global.header}>
                <Text style={global.title}>Usuário</Text>
            </View>

            <View style={global.body}>
                <ScrollView>
                    {
                        (listaCliente.length === 0)
                        ?
                            <View>
                                <Text style={global.question}>Login</Text>
                                <View style={css.login}>
                                    <Text style={css.text} >Insira seu documento</Text>
                                    <TextInput placeholder="E-mail" style={css.input}/>
                                    <TextInput secureTextEntry={true} placeholder="Senha" style={css.input}/>
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
                               <View>
                                   <Text style={global.question}>Bem-Vindo!</Text>
                                   <Text>Nome do usuário: {item.nome_completo}</Text>
                                   <Text>Nascimento: {item.data_nascimento}</Text>
                                   <Text>Telefone: {item.telefone}</Text>
                                   <Text>Endereço: {item.endereco}</Text>
                                   <Text>CEP: {item.cep}</Text>
                                   <View style={css.edit}>
                                       <Text>Editar</Text>
                                       <AntDesign name="edit" size={24} color="purple" />
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
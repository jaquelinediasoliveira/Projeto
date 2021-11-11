import React,{useState} from 'react';
import { View, Text, TouchableOpacity, TextInput,ScrollView} from 'react-native';
import css from "./style"
import global from '../global/style'

import Navbar from '../components/navbar'

export default function Perfil({navigation}) {
    // const url = "http://10.87.202.133:8080/locacao/clientes";
    const [listaCliente, setListaCliente] = useState([{
        'email': 'jaquelinediasoliveira5@gmail.com',
        'senha': 'seila555'
    }]);

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
                                    <TouchableOpacity style={css.entrar}>
                                        <Text style={css.text}>Entrar</Text>
                                    </TouchableOpacity>
                                </View>
                                <Text style={global.question}>Ainda não possui cadastro?</Text>
                                <TouchableOpacity style={css.botao}>
                                    <Text style={css.text} onPress={() => handleNavigate("Cadastro")}>Cadastrar</Text>
                                </TouchableOpacity>
                            </View>
                            :
                            <View>
                                <Text>{listaCliente[0].email}</Text>
                            </View>
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
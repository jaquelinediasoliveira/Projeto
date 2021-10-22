import React from 'react';
import { View, Text, TouchableOpacity, TextInput} from 'react-native';
import css from "./style"
import global from '../global/style'

import Navbar from '../components/navbar'

export default function Perfil({navigation}) {
    const handleNavigate = (tela) => {
        navigation.navigate(tela);
     }

    return (
        <View style={global.tela}>
            
            <View style={global.titulo}>
                <Text style={global.text}>Usuário</Text>
            </View>

            <View style={global.body}>
                <Text style={css.perg}>Fazer login</Text>
                <View style={css.login}>
                    <Text style={css.text} >Insira seu documento</Text>
                    <TextInput placeholder="  CPF/Passaporte" style={css.input}/>
                    <TouchableOpacity style={css.entrar}>
                        <Text style={css.text}>Entrar</Text>
                    </TouchableOpacity>
                </View>
                <Text style={css.perg}>Ainda não possui cadastro?</Text>
                <TouchableOpacity style={css.botao}>
                    <Text style={css.text} onPress={() => handleNavigate("Cadastro")}>Cadastrar</Text>
                </TouchableOpacity>
            </View>

            <Navbar
                navigation={navigation}
                screen="User"
             />
        </View>
    );
}
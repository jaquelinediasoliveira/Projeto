import React from 'react';
import { View, Text, TouchableOpacity} from 'react-native';
import css from "./style"
import global from '../global/style'

import Navbar from '../components/navbar'

export default function Perfil({navigation}) {
    return (
        <View style={global.tela}>
            
            <View style={global.titulo}>
                <Text style={global.text}>Usuário</Text>
            </View>

            <View style={global.body}>
                <Text style={css.perg}>Já possui uma conta?</Text>
                <TouchableOpacity style={css.botao}>
                    <Text style={css.text}>Login</Text>
                </TouchableOpacity>
                <Text style={css.perg}>Ainda não possui cadastro?</Text>
                <TouchableOpacity style={css.botao}>
                    <Text style={css.text}>Cadastrar</Text>
                </TouchableOpacity>
            </View>

            <Navbar
                navigation={navigation}
                screen="User"
             />
        </View>
    );
}
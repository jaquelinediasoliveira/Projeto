import React from 'react';
import { View, Text, TouchableOpacity} from 'react-native';
import css from "./style"

import Navbar from '../components/navbar'

export default function Perfil({navigation}) {
    return (
        <View style={css.tela}>
            <View style={css.titulo}>
                <Text style={css.text}>Usuário</Text>
            </View>

            <View style={css.body}>
                <Text style={css.perg}>Já possui uma conta?</Text>
                <TouchableOpacity style={css.botao}>
                    <Text>Login</Text>
                </TouchableOpacity>
                <Text style={css.perg}>Ainda não possui cadastro?</Text>
                <TouchableOpacity style={css.botao}>
                    <Text>Cadastrar</Text>
                </TouchableOpacity>
            </View>

            <Navbar
                navigation={navigation}
                screen="User"
             />
        </View>
    );
}
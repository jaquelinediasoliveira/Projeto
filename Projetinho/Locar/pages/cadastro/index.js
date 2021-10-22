import React from 'react';
import { View, Text, TouchableOpacity, TextInput} from 'react-native';
import css from "./style"
import global from '../global/style'

export default function Reservas({navigation}){
    return(
        <View style={global.tela}>
            <Text style={css.perg}>Insira seus dados</Text>
            <TextInput placeholder="  CPF/Passaporte" style={css.input}/>
            <TextInput placeholder="  Nome completo" style={css.input}/>
            <TextInput placeholder="  Telefone" style={css.input}/>
            <TextInput placeholder="  Data de nascimento" style={css.input}/>
            <TouchableOpacity style={css.entrar}>
                <Text style={css.text}>Entrar</Text>
            </TouchableOpacity>
        </View>
    )
}
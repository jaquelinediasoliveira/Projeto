import React from 'react';
import { View, Text, TouchableOpacity, TextInput, Piker, ScrollView } from 'react-native';
import css from "./style"
import global from '../global/style'

export default function Reservas({navigation}){
    return(
        <View style={global.tela}>
            <View style={css.texto}>
                <Text style={css.font}>Insira seus Dados</Text>
            </View>
            <View style={css.scroll}>
                <ScrollView>
                    <TextInput placeholder="CPF/Passaporte" style={css.input}/>
                    <TextInput placeholder="Nome completo" style={css.input}/>
                    <TextInput placeholder="Telefone" style={css.input}/>
                    <TextInput placeholder="Data de nascimento" style={css.input}/>
                    <TextInput placeholder="E-mail" style={css.input}/>
                    <View style={css.end}>
                        <TextInput placeholder="Cidade" style={css.city}/>
                        <TextInput placeholder="UF" style={css.uf}/>
                    </View>
                    <TextInput placeholder="Logradouro" style={css.input}/>
                    <TextInput placeholder="Bairro" style={css.input}/>
                    <TouchableOpacity style={css.entrar}>
                        <Text style={css.botao}>Entrar</Text>
                    </TouchableOpacity>
                </ScrollView>
            </View>
        </View>
    )
}
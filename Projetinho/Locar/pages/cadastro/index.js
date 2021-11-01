import React, { useState } from 'react';
import { View, Text, TouchableOpacity, TextInput, ScrollView } from 'react-native';
import { Picker } from '@react-native-picker/picker'
import css from "./style"
import global from '../global/style'

export default function Reservas({navigation}){
    const [selectedValue, setSelectedValue] = useState("uf");

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
                            <View style={css.uf}>
                                <Picker
                                    selectedValue={selectedValue}
                                    style={{width:'100%',height:'100%'}}
                                    onValueChange={(itemValue, itemIndex) => setSelectedValue(itemValue)}
                                >
                                    <Picker.Item label="UF" enabled={false} value="uf" style={{color: 'gray'}}/>
                                    <Picker.Item label="AC" value="ac" />
                                    <Picker.Item label="AL" value="al" />
                                    <Picker.Item label="AP" value="ap" />
                                    <Picker.Item label="AM" value="am" />
                                    <Picker.Item label="BA" value="ba" />
                                    <Picker.Item label="CE" value="ce" />
                                    <Picker.Item label="ES" value="es" />
                                    <Picker.Item label="GO" value="go" />
                                    <Picker.Item label="MA" value="ma" />
                                    <Picker.Item label="MT" value="mt" />
                                    <Picker.Item label="MS" value="ms" />
                                    <Picker.Item label="PA" value="pa" />
                                    <Picker.Item label="PB" value="pb" />
                                    <Picker.Item label="PR" value="pr" />
                                    <Picker.Item label="PE" value="pe" />
                                    <Picker.Item label="PI" value="pi" />
                                    <Picker.Item label="RJ" value="rj" />
                                    <Picker.Item label="RN" value="rn" />
                                    <Picker.Item label="RS" value="rs" />
                                    <Picker.Item label="RO" value="ro" />
                                    <Picker.Item label="RR" value="rr" />
                                    <Picker.Item label="SC" value="sc" />
                                    <Picker.Item label="SP" value="sp" />
                                    <Picker.Item label="SE" value="se" />
                                    <Picker.Item label="TO" value="to" />
                                    <Picker.Item label="DF" value="df" />
                                </Picker>
                            </View>
                    </View>
                    <TextInput placeholder="Logradouro" style={css.input}/>
                    <TextInput placeholder="Bairro" style={css.input}/>
                    <TextInput placeholder="Senha" style={css.input}/>
                    <TouchableOpacity style={css.entrar}>
                        <Text style={css.botao}>Entrar</Text>
                    </TouchableOpacity>
                </ScrollView>
            </View>
        </View>
    )
}
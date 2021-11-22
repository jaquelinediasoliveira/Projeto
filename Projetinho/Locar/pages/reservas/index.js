import React, { useState, useEffect } from 'react';
import { View, Text, ScrollView } from 'react-native'
import { Entypo, MaterialCommunityIcons } from '@expo/vector-icons';

import Navbar from '../components/navbar'

import css from './style';
import global from '../global/style'
import AsyncStorage from '@react-native-async-storage/async-storage';
import DeprecatedViewPropTypes from 'react-native/Libraries/DeprecatedPropTypes/DeprecatedViewPropTypes';

export default function Reservas({ navigation }) {
    const url = "http://10.87.202.133:8080/locacao/reservas";
    const [listaReservas, setListaReserva] = useState([]);

    useEffect(() => {
        loadReserva();
    }, []);

    const loadReserva = async () => {
        let data = JSON.parse(await AsyncStorage.getItem('cliente'));

        if(data != null) {
            fetch(`${url}?id_cliente=${data.id_cliente}`)
            .then((resp) => { return resp.json() })
            .then(data => {
                setListaReserva(data);
            })
            .catch(err => { console.log(err) });
        }
    }

    const formatDate = (nasc) => {
        let dia = nasc.getDate();
        dia = (dia < 10) ? "0" + dia : dia;
        let mes = nasc.getMonth() + 1;
        mes = (mes < 10) ? "0" + mes : mes;
        let ano = nasc.getFullYear();
        return `${dia}/${mes}/${ano}`;
     }

     const valor = (ret, dev, val) => {
        const dif = Math.abs(ret - dev);
        const days = Math.ceil(dif / (1000 * 60 * 60 * 24));
        const cont = days * val;
        console.log(cont);
    }

    return (
        <View style={global.tela}>

            <View style={global.header}>
                <Text style={global.title}>Reservas</Text>
            </View>
            
            <View style={global.body}>
                <View style={css.scroll}>
                    <ScrollView>
                        {
                            (listaReservas.length === 0)
                                ?
                                    <View style={css.card2}>
                                        <Text style={css.text}>Você ainda não possui reservas</Text>
                                        <Entypo name="emoji-sad" size={25} color="#c0c0c0" />
                                    </View>
                                :
                                    listaReservas.map((item, index) => {
                                        return (
                                            <View style={css.card} key={index}>
                                                <View style={css.imagem}>
                                                    <MaterialCommunityIcons name="image-off-outline" size={70} color="black"/>
                                                </View>
                                                <View>
                                                    <Text style={css.txt}>Placa:</Text>
                                                    <Text style={css.txt}>Retirada:</Text>
                                                    <Text style={css.txt}>Devolução:</Text>
                                                    <Text style={css.txt}>Valor:</Text>
                                                    <Text style={css.txt}>Filial:</Text>
                                                </View>
                                                <View>
                                                    <Text style={{color: 'green', marginRight: 10, marginBottom: 5, fontWeight: 'bold'}}>{item.veiculo}</Text>
                                                    <Text style={{color: 'green', marginRight: 10, marginBottom: 5, fontWeight: 'bold'}}>{formatDate(new Date(item.data_retirada))}</Text>
                                                    <Text style={{color: 'purple', marginRight: 10, marginBottom: 5, fontWeight: 'bold'}}>{formatDate(new Date(item.data_devolucao_esperada))}</Text>
                                                    <Text style={{fontWeight: 'bold'}}>{valor(new Date(item.data_devolucao_esperada),new Date(item.data_retirada), item.valor)}</Text>
                                                    <Text style={{fontWeight: 'bold'}}>{item.id_loja}</Text>
                                                </View>
                                            </View>
                                        )
                                    })
                        }
                    </ScrollView>
                </View>
            </View>

            <Navbar
                navigation={navigation}
                screen="Reservas"
            />

        </View>
    );
}
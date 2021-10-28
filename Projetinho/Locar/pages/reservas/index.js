import React, {useState, useEffect} from 'react';
import { View, Text} from 'react-native'

import Navbar from '../components/navbar'

import css from './style';
import global from '../global/style'

export default function Reservas({navigation}) {
    // const [listaReservas, setListaReserva] = useState([]);

    //useEffect(()=>{
        // fetch('https://myapi.com')
        // .then((response) => response.json())
        // .then((data) => {
        //   setListaReserva(data)
        // })
        // .catch((error) => {
        //   console.error(error);
        // });
        const setListaReserva = 
            [
                {
                    "imagem":"",
                    "retirada":"28/10/2021",
                    "devolucao":"29/10/2021",
                    "valor":"R$ 120,00"
                },
                {
                    "imagem":"",
                    "retirada":"30/10/2021",
                    "devolucao":"31/10/2021",
                    "valor":"R$ 220,00"
                },
                {
                    "imagem":"",
                    "retirada":"32/10/2021",
                    "devolucao":"33/10/2021",
                    "valor":"R$ 320,00"
                },
                {
                    "imagem":"",
                    "retirada":"34/10/2021",
                    "devolucao":"35/10/2021",
                    "valor":"R$ 420,00"
                }
            ]

    return (
        <View style={global.tela}>

            <View style={global.titulo}>
                <Text style={global.text}>Reservas</Text>
            </View>

            <View style={global.body}>
                {
                    setListaReserva.map((item, index)=>{
                        return(
                            <View style={css.card}>
                                <View style={css.imagem}>

                                </View>
                                <View>
                                    <Text>Retirada:  </Text>
                                    <Text>Devolução:  </Text>
                                    <Text>Valor:  </Text>
                                </View>
                                <View style={css.info}>
                                        <Text style={css.ret}>{item.retirada}</Text>
                                        <Text style={css.dev}>{item.devolucao}</Text>
                                        <Text>{item.valor}</Text>
                                </View>
                            </View>
                        )
                    })
                }
            </View>

            <Navbar
                navigation={navigation}
                screen="Reservas"
             />
        </View>
    );
}
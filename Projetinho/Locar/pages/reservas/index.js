import React, {useState, useEffect} from 'react';
import { View, Text, Image, ScrollView} from 'react-native'

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
                    "imagem":"https://s2.glbimg.com/mYgwlPa7vtIiUk6kROUxJUi2yyo=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/a/4/Ik8J1fQYirf6wYRvRJ8Q/2020-03-20-novo-tracker-1.jpg",
                    "retirada":"28/10/2021",
                    "devolucao":"29/10/2021",
                    "valor":"R$ 120,00"
                },
                {
                    "imagem":"https://s2.glbimg.com/mYgwlPa7vtIiUk6kROUxJUi2yyo=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/a/4/Ik8J1fQYirf6wYRvRJ8Q/2020-03-20-novo-tracker-1.jpg",
                    "retirada":"30/10/2021",
                    "devolucao":"31/10/2021",
                    "valor":"R$ 220,00"
                },
                {
                    "imagem":"https://s2.glbimg.com/mYgwlPa7vtIiUk6kROUxJUi2yyo=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/a/4/Ik8J1fQYirf6wYRvRJ8Q/2020-03-20-novo-tracker-1.jpg",
                    "retirada":"32/10/2021",
                    "devolucao":"33/10/2021",
                    "valor":"R$ 320,00"
                },
                {
                    "imagem":"https://s2.glbimg.com/mYgwlPa7vtIiUk6kROUxJUi2yyo=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/a/4/Ik8J1fQYirf6wYRvRJ8Q/2020-03-20-novo-tracker-1.jpg",
                    "retirada":"34/10/2021",
                    "devolucao":"35/10/2021",
                    "valor":"R$ 420,00"
                },
                {
                    "imagem":"https://s2.glbimg.com/mYgwlPa7vtIiUk6kROUxJUi2yyo=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/a/4/Ik8J1fQYirf6wYRvRJ8Q/2020-03-20-novo-tracker-1.jpg",
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
                <View style={css.scroll}>
                    <ScrollView>
                        {
                            setListaReserva.map((item, index)=>{
                                return(
                                    <View style={css.card}>
                                        <View style={css.imagem}>
                                            <Image source={{ uri: item.imagem }} style={{ width: '100%', height: '100%', borderTopLeftRadius: 15, borderBottomLeftRadius: 15 }} />
                                        </View>
                                        <View>
                                            <Text style={css.txt}>Retirada:</Text>
                                            <Text style={css.txt}>Devolução:</Text>
                                            <Text style={css.txt}>Valor:</Text>
                                        </View>
                                        <View style={css.info}>
                                                <Text style={css.ret}>{item.retirada}</Text>
                                                <Text style={css.dev}>{item.devolucao}</Text>
                                                <Text style={css.val}>{item.valor}</Text>
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
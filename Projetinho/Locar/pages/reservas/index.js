import React from 'react';
import { View, Text} from 'react-native'

import Navbar from '../components/navbar'

import css from './style';
import global from '../global/style'

export default function Reservas({navigation}) {
    return (
        <View style={global.tela}>

            <View style={global.titulo}>
                <Text style={global.text}>Reservas</Text>
            </View>

            <View style={global.body}>

            </View>
            <Navbar
                navigation={navigation}
                screen="Reservas"
             />
        </View>
    );
}
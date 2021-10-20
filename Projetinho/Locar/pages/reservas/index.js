import React from 'react';
import { View, Text} from 'react-native'

import Navbar from '../components/navbar'

export default function Reservas({navigation}) {
    return (
        <View>
            <Text>Pag de reservas</Text>
            <Navbar
                navigation={navigation}
                screen="Reservas"
             />
        </View>
    );
}
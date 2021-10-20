import React from 'react';
import { View, Text} from 'react-native'

import Navbar from '../components/navbar'

export default function Help({navigation}) {
    return (
        <View>
            <Text>Help</Text>
            <Navbar
                navigation={navigation}
                screen="Help"
             />
        </View>
    );
}
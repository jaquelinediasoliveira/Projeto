import React from 'react';
import { View, Text, TouchableOpacity, Linking} from 'react-native'

import Navbar from '../components/navbar'
import { MaterialIcons, Feather, FontAwesome } from '@expo/vector-icons';

import css from './style';
import global from '../global/style'

export default function Help({navigation}) {
    return (
        <View style={global.tela}>

            <View style={global.header}>
                <Text style={global.title}>Ajuda</Text>
            </View>
            
            <View style={global.body}>
                <View style={css.view1}>
                    <MaterialIcons name="live-help" size={23} color="purple" />
                    <Text style={global.question}> O que você precisa?</Text>
                </View>
                
                <View style={css.cards}>
                    <Text style={{fontWeight: "bold", fontSize: 16}}>Central de atendimento</Text>
                    <TouchableOpacity style={css.tel} onPress={() => {Linking.openURL(`tel:0800 123 4567`)}}>
                        <Feather name="phone" size={20} color="black" />
                        <Text>  0800 123 4567</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={css.wpp}>
                        <FontAwesome name="whatsapp" size={24} color="black" />
                        <Text>  (11) 4002-8922</Text>
                    </TouchableOpacity>
                </View>

                <View style={css.cards}>
                    <Text style={{fontWeight: "bold", fontSize: 16}}>Central de reservas 24h</Text>
                    <View style={css.tel} onPress={() => {Linking.openURL(`tel:0800 90007654`)}}>
                        <Feather name="phone" size={20} color="black" />
                        <Text>  0800 90007654</Text>
                    </View>
                </View>

                <View style={css.cards}>
                    <Text style={{fontWeight: "bold", fontSize: 16}}>Assistência técnica 24h</Text>
                    <View style={css.tel} onPress={() => {Linking.openURL(`tel:0800 484 7231`)}}>
                        <Feather name="phone" size={20} color="black" />
                        <Text>  0800 484 7231</Text>
                    </View>
                </View>

            </View>
            <Navbar
                navigation={navigation}
                screen="Help"
             />
        </View>
    );
}
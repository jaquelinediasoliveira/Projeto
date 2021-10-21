import React from 'react';
import { View, Text} from 'react-native'

import Navbar from '../components/navbar'
import { MaterialIcons, Feather, FontAwesome } from '@expo/vector-icons';

import css from './style';
import global from '../global/style'

export default function Help({navigation}) {
    return (
        <View style={global.tela}>

            <View style={global.titulo}>
                <Text style={global.text}>Ajuda</Text>
            </View>
            
            <View style={global.body}>
                <View style={css.view1}>
                    <MaterialIcons name="live-help" size={23} color="purple" />
                    <Text style={css.perg}>O que você precisa?</Text>
                </View>
                
                <View style={css.view2}>
                    <Text style={{fontWeight: "bold"}}>Central de atendimento</Text>
                    <View style={css.tel}>
                        <Feather name="phone" size={20} color="black" />
                        <Text>  0800 123 4567</Text>
                    </View>
                    <View style={css.wpp}>
                        <FontAwesome name="whatsapp" size={24} color="black" />
                        <Text>  (11) 4002-8922</Text>
                    </View>
                </View>

                <View style={css.view3}>
                    <Text style={{fontWeight: "bold"}}>Central de reservas 24h</Text>
                    <View style={css.tel}>
                        <Feather name="phone" size={20} color="black" />
                        <Text>  0800 90007654</Text>
                    </View>
                </View>

                <View style={css.view4}>
                    <Text style={{fontWeight: "bold"}}>Assistência técnica 24h</Text>
                    <View style={css.tel}>
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
import React from 'react';

import { View, Text, Image, TextInput} from 'react-native'

import css from "./style"

 export default function Home({navigator}){
     return(
         <View style={css.tela}>
             <View style={css.header}>
                <Image source={require('../assets/logo.png')} style={css.logo}/>
             </View>
             <View style={css.content}>
                <Text style={css.text}>Bem-Vindo(a) ao nosso App!</Text>
                <View  style={css.localizacao}>
                    <Image source={require('../assets/icone.png')} style={css.local}/>
                    <TextInput placeholder=" Local de retirada" style={css.input}/>
                </View>
             </View>
            <View style={css.footer}>
                <Image source={require('../assets/home.png')}/>
                <Image source={require('../assets/user.png')}/>
                <Image source={require('../assets/car.png')}/>
                <Image source={require('../assets/help.png')}/> 
            </View>
         </View>
     )
 }
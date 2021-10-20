import React from 'react';

import { View, Text, Image, TextInput} from 'react-native'

import css from "./style"

import Navbar from '../components/navbar'

 export default function Home({navigation}){
     
     return(
         <View style={css.tela}>

             <View style={css.header}>
                <Image source={require('../assets/logo.png')} style={css.logo}/>
             </View>

             <View style={css.content}>
                <Text style={css.text}>Bem-Vindes ao nosso App!</Text>

                <View  style={css.localizacao}>
                    <Image source={require('../assets/icone.png')} style={css.local}/>
                    <TextInput placeholder=" Local de retirada" style={css.input}/>
                </View>

             </View>

             <Navbar
                navigation={navigation}
                screen="Home"
             />

         </View>
     )
 }
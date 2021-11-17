import React from 'react'

import {View} from 'react-native'

import { CommonActions } from '@react-navigation/native';

import css from "./style"
import { AntDesign } from '@expo/vector-icons'; 

export default function Navbar(props){
    const { navigation, screen } = props;

    const handleNavigate = (tela) => {
        navigation.push(tela);

        // navigation.dispatch(state => {
        //     // Remove the home route from the stack
        //     const routes = state.routes.filter(r => r.name !== tela);
          
        //     return CommonActions.reset({
        //       ...state,
        //       routes,
        //       index: routes.length - 1,
        //     });
        // });
        // navigation.navigate(tela);
     }

     return(
        <View style={css.footer}>
            <AntDesign name="home" size={30} color={(screen === "Home") ? "purple" : "black"} onPress={() => {handleNavigate("Home")}}/>
            <AntDesign name="user" size={30} color={(screen === "User") ? "purple" : "black"} onPress={() => {handleNavigate("User")}}/>
            <AntDesign name="car" size={30} color={(screen === "Reservas") ? "purple" : "black"} onPress={() => {handleNavigate("Reservas")}}/>
            <AntDesign name="question" size={30} color={(screen === "Help") ? "purple" : "black"} onPress={() => {handleNavigate("Help")}}/>
        </View>
     )
}
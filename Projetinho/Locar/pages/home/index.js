import React from 'react';

import { View, Text} from 'react-native'

import css from "./style"

 export default function Home({navigator}){
     return(
         <View style={css.view}>
             <Text style={css.text}>Home</Text>
             <Text style={css.text}>Reserva</Text>
             <Text style={css.text}>Help</Text>
             <Text style={css.text}>User</Text>
         </View>
     )
 }
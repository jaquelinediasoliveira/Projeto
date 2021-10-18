import React from 'react';

import { View, Text} from 'react-native'

import css from "./style"

 export default function Home({navigator}){
     return(
         <View style={css.view}>
             <Text>Home</Text>
             <Text>Reserva</Text>
             <Text>Help</Text>
             <Text>User</Text>
         </View>
     )
 }
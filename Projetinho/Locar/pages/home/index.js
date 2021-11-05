import React, { Component, useState } from 'react';

import { View, Text, Image, TextInput, TouchableOpacity, Linking} from 'react-native'
import DateTimePicker from '@react-native-community/datetimepicker';
import { AntDesign, Entypo } from '@expo/vector-icons';

import AppLoading from 'expo-app-loading';

import { useFonts, Roboto_300Light } from '@expo-google-fonts/roboto';

import css from "./style"

import Navbar from '../components/navbar'

 export default function Home ({navigation}){
   const [date, setDate] = useState(new Date(1598051730000));
   const [show, setShow] = useState(false);

   let [fontsLoaded] = useFonts({
      Roboto_300Light,
   })

   const setData = (event, selectedDate) => {
      const currentDate = selectedDate || date;
      setShow(false);
      setDate(currentDate);
   }

   const formatDate = (data) => {
      let dia = data.getDate();
      dia = (dia < 10) ? "0"+dia : dia;
      let mes = data.getMonth() + 1;
      mes = (mes < 10) ? "0"+mes : mes;
      let ano = data.getFullYear();
      return `${dia}/${mes}/${ano}`;
   }
   
   if (!fontsLoaded) {
      return <AppLoading />;
   }else {
      return(
         <View style={css.tela}>

             <View style={css.header}>
                <Image source={require('../assets/logo.png')} style={css.logo}/>
             </View>

             <View style={css.content}>
                <Text style={css.text}>Bem-Vindes ao nosso App!</Text>
                <View  style={css.localizacao}>
                     <Entypo name="location-pin" size={28} color="purple" />
                    <TextInput placeholder=" Local de retirada" style={css.input}/>
                </View>
                <TouchableOpacity style={css.data} onPress={() => setShow(true)}>
                  <AntDesign name="calendar" size={24} color="purple"/>
                   <Text style={{marginLeft: "4%", fontFamily: "Roboto_300Light"}}>{formatDate(date)}</Text>
                </TouchableOpacity>
                <View style={css.data}>                  
                </View>
                {
                  show && (
                     <DateTimePicker
                        testID="dateTimePicker"
                        value={date}
                        mode="date"
                        is24Hour={true}
                        display="spinner"
                        onChange={setData}
                     />
                  )
                }
             </View>

             <Navbar
                navigation={navigation}
                screen="Home"
             />

         </View>
     )
   }
}
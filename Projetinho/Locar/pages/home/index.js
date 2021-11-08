import React, { Component, useState } from 'react';

import { View, Text, Image, TextInput, TouchableOpacity, Linking, ToastAndroid, ScrollView} from 'react-native'
import DateTimePicker from '@react-native-community/datetimepicker';
import { AntDesign, Entypo } from '@expo/vector-icons';

import AppLoading from 'expo-app-loading';

import { useFonts, Roboto_300Light } from '@expo-google-fonts/roboto';

import css from "./style"

import Navbar from '../components/navbar'

 export default function Home ({navigation}){
   const [date, setDate] = useState(new Date());
   const [dateDev, setDateDev] = useState(new Date());
   const [show, setShow] = useState(false);
   const [tipo, setTipo] = useState(0);

   let [fontsLoaded] = useFonts({
      Roboto_300Light,
   })

   const setData = (event, selectedDate) => {
      let pode = false;

      if(tipo == 0) {
         if(selectedDate >= new Date()) {
            pode = true;
            setDateDev(selectedDate);
         }
      }else {
         if(selectedDate >= date) {
            pode = true;
         }
      }

      if(pode) {
         let novaData = (tipo == 0) ? date : dateDev;
         const currentDate = selectedDate || novaData;
         if (tipo == 0){
            setDate(currentDate);
         } else{
            setDateDev(currentDate);
         } 
      }      
      setShow(false);   
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
                <TouchableOpacity style={css.data} onPress={() => { setTipo(0); setShow(true) }}>
                  <AntDesign name="calendar" size={24} color="purple"/>
                  <Text style={{marginLeft: "4%", fontFamily: "Roboto_300Light"}}>{formatDate(date)}</Text>
                </TouchableOpacity>
                <TouchableOpacity style={css.data} onPress={() => { setTipo(1); setShow(true) }}>
                  <AntDesign name="calendar" size={24} color="purple"/>
                  <Text style={{marginLeft: "4%", fontFamily: "Roboto_300Light"}}>{formatDate(dateDev)}</Text>
                </TouchableOpacity>
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
               <View style={css.scroll}>
                  <ScrollView>
                     <View style={css.card}>
                        
                     </View>
                  </ScrollView>
               </View>
             </View>

             <Navbar
                navigation={navigation}
                screen="Home"
             />

         </View>
     )
   }
}
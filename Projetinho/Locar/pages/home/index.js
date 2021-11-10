import React, { Component, useState } from 'react';

import { View, Text, Image, TextInput, TouchableOpacity, ToastAndroid, ScrollView } from 'react-native'
import DateTimePicker from '@react-native-community/datetimepicker';
import { AntDesign, Entypo } from '@expo/vector-icons';

import AppLoading from 'expo-app-loading';

import { useFonts, Roboto_300Light } from '@expo-google-fonts/roboto';

import css from "./style"
import global from "../global/style"

import Navbar from '../components/navbar'

export default function Home({ navigation }) {
   const [date, setDate] = useState(new Date());
   const [dateDev, setDateDev] = useState(new Date());
   const [show, setShow] = useState(false);
   const [tipo, setTipo] = useState(0);
   const [selecionado, setSelecionado] = useState(-1);

   let [fontsLoaded] = useFonts({
      Roboto_300Light,
   })

   const carros = [
      {
         "img":require('../assets/carro.jpg'),
         "texto":"Marca"
      },
      {
         "img":require('../assets/carro.jpg'),
         "texto":"carro"
      },
      {
         "img":require('../assets/carro.jpg'),
         "texto":"carro"
      },
      {
         "img":require('../assets/carro.jpg'),
         "texto":"carro"
      },
      {
         "img":require('../assets/carro.jpg'),
         "texto":"carro"
      }
   ]

   const setData = (event, selectedDate) => {
      let pode = false;

      if (tipo == 0) {
         if (selectedDate >= new Date()) {
            pode = true;
            setDateDev(selectedDate);
         }
      } else {
         if (selectedDate >= date) {
            pode = true;
         }
      }

      if (pode) {
         let novaData = (tipo == 0) ? date : dateDev;
         const currentDate = selectedDate || novaData;
         if (tipo == 0) {
            setDate(currentDate);
         } else {
            setDateDev(currentDate);
         }
      }
      setShow(false);
   }

   const formatDate = (data) => {
      let dia = data.getDate();
      dia = (dia < 10) ? "0" + dia : dia;
      let mes = data.getMonth() + 1;
      mes = (mes < 10) ? "0" + mes : mes;
      let ano = data.getFullYear();
      return `${dia}/${mes}/${ano}`;
   }

   if (!fontsLoaded) {
      return <AppLoading />;
   } else {
      return (
         <View style={css.tela}>

            <View style={css.header}>
               <Image source={require('../assets/logo.png')} style={css.logo} />
            </View>

            <View style={global.body}>
               <ScrollView>
                  <Text style={css.text}>Bem-Vindos ao nosso App!</Text>
                  <View style={css.localizacao}>
                     <Entypo name="location-pin" size={28} color="purple" />
                     <TextInput placeholder=" Local de retirada" style={css.input} />
                  </View>
                  <TouchableOpacity style={css.data} onPress={() => { setTipo(0); setShow(true) }}>
                     <AntDesign name="calendar" size={24} color="purple" />
                     <Text style={{ marginLeft: "4%", fontFamily: "Roboto_300Light" }}>{formatDate(date)}</Text>
                  </TouchableOpacity>
                  <TouchableOpacity style={css.data} onPress={() => { setTipo(1); setShow(true) }}>
                     <AntDesign name="calendar" size={24} color="purple" />
                     <Text style={{ marginLeft: "4%", fontFamily: "Roboto_300Light" }}>{formatDate(dateDev)}</Text>
                  </TouchableOpacity>
                  <Text style={{marginTop: 25, marginLeft: 20,marginBottom: -10, fontSize: 18}}>Veículos disponíveis:</Text>
                  <View style={css.carros}>
                     <ScrollView horizontal={true}>
                        {
                           carros.map((car, index) => {
                              return(
                                 <View style={[css.card, (selecionado == index) ? { borderColor : '#91DE25'} : {}]} key={index}>
                                    <Image source={car.img} style={css.imagem}/>
                                    <Text>{car.texto}</Text>
                                    <Text>{car.texto}</Text>
                                    <Text>{car.texto}</Text>
                                    <Text style={css.texto}>Carro</Text>
                                    <TouchableOpacity style={[css.botao, (selecionado == index) ? {backgroundColor: '#E0EBD0', borderColor : '#91DE25'} : {}]} onPress={() => {
                                       setSelecionado(index);
                                    }} >
                                       <Text style={(selecionado == index) ? {color: '#567A23'} : {color: 'purple'}}>{(selecionado == index) ? 'Selecionado' : 'Selecionar'}</Text>
                                    </TouchableOpacity>
                                 </View>
                              )
                           })
                        }
                     </ScrollView>
                  </View>
                  <Text>Confirmar aluguel?</Text>
                  <TouchableOpacity>
                     <Text>Confirmar</Text>
                  </TouchableOpacity>
               </ScrollView>


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
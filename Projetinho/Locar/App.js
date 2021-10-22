import React from 'react';

import { StatusBar } from 'react-native';

import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

const Stack = createNativeStackNavigator();

import Home from './pages/home';
import User from './pages/user';
import Reservas from './pages/reservas';
import Help from './pages/help';
import Cadastro from './pages/cadastro';

export default function App(){
  return(
    <NavigationContainer>
      <StatusBar hidden={true} />
      <Stack.Navigator screenOptions={{ headerShown: false, showNavigationBar:false }}>
        <Stack.Screen name="Home" component={Home}/>
        <Stack.Screen name="User" component={User}/>
        <Stack.Screen name="Reservas" component={Reservas}/>
        <Stack.Screen name="Help" component={Help}/>
        <Stack.Screen name="Cadastro" component={Cadastro}/>
      </Stack.Navigator>
    </NavigationContainer>
  )
}
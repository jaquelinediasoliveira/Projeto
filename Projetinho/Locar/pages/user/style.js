import {StyleSheet} from 'react-native';

export default StyleSheet.create({
    botao:{
        borderRadius: 15,
        backgroundColor: '#F7EFFA',
        width: '40%',
        height: "10%",
        justifyContent: 'center',
        alignItems: 'center',
        alignSelf: 'center'
    },
    text:{
        fontSize: 18
    },
    login:{
        borderRadius: 15,
        backgroundColor: '#FDFBFB',
        width: '70%',
        height: '50%',
        justifyContent: 'space-evenly',
        alignItems: 'center',
        shadowColor: "#000",
        shadowOffset: {width: 0, height: 2,},
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        elevation: 5
    },
    input:{
        width: '75%',
        height: '15%',
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 5,
        padding: '3%'
    },
    entrar:{
        borderRadius: 15,
        backgroundColor: '#F7EFFA',
        width: '40%',
        height: '15%',
        justifyContent: 'center',
        alignItems: 'center',
        alignSelf: 'center'
    }
})
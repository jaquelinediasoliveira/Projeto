import {StyleSheet} from 'react-native';

export default StyleSheet.create({
    tela:{
        flex: 1,
        alignItems: 'center',
        backgroundColor: 'white'
    },
    logo:{
        width: '50%',
        height: '62%'
    },
    header:{
        width: "100%",
        height: "10%",
        backgroundColor: 'purple',
        justifyContent: 'center',
        alignItems: 'center'
    },
    content: {
        width: "100%",
        height: "82%",
        alignItems: 'center'
    },
    text:{
       fontSize: 18, 
       marginTop: '8%'
    },
    localizacao:{
        width: '65%',
        height: '10%',
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 15,
        flexDirection: 'row',
        alignItems: 'center',
        marginTop: "5%"
    },
    local:{
        width: '13%',
        height: '51%'
    },
    input:{
        width: '95%',
        height: '100%'
    },
    footer:{
        width: '100%',
        height: '8%',
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-around',
        alignItems: 'center'
    },
    icon:{
        width: '10%',
        height: '60%'
    }
})
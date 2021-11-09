import {StyleSheet} from 'react-native';

export default StyleSheet.create({
    tela:{
        flex: 1,
        alignItems: 'center',
        backgroundColor: 'white',
    },
    logo:{
        width: "100%",
        height: "50%",
        resizeMode: "contain",
    },
    header:{
        width: "100%",
        height: "10%",
        backgroundColor: 'purple',
        justifyContent: 'center',
        alignItems: 'center'
    },
    text:{
       fontSize: 18, 
       marginTop: '8%',
       fontFamily: "Roboto_300Light",
       alignSelf: 'center'
    },
    localizacao:{
        width: 270,
        height: 45,
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 15,
        flexDirection: 'row',
        alignItems: 'center',
        marginTop: "5%",
        alignSelf: 'center'
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
    },
    data:{
        width: 270,
        height: 45,
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 15,
        flexDirection: 'row',
        alignItems: 'center',
        marginTop: "5%",
        padding: 10,
        alignSelf: 'center'
    },
    scroll:{
        width: '100%',
        height: '40%',
        backgroundColor: 'red',
        marginTop: '15%'
    },
    scrollview:{
        height: '100%',
        
    },
    card: {
        width: 200,
        alignItems: 'center',
        justifyContent: 'space-between',
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 10,
        marginTop: 13,
        marginBottom: 13, 
        shadowColor: "#000",
        shadowOffset: {width: 0, height: 2,},
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        backgroundColor: '#FDFBFB',
        alignSelf: 'center',
        elevation: 5,
        marginRight: 10,
        marginLeft: 10
    },
    carros: {
        marginTop: '5%',
        width: 275
    }
})
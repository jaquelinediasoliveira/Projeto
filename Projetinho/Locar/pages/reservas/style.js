import {StyleSheet} from 'react-native';

export default StyleSheet.create({
    card: {
        width: '80%',
        height: 100,
        alignItems: 'center',
        justifyContent: 'space-between',
        flexDirection: 'row',
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 15,
        marginTop: 13,
        marginBottom: 13, 
        shadowColor: "#000",
        shadowOffset: {width: 0, height: 2,},
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        backgroundColor: '#FDFBFB',
        alignSelf: 'center',
        elevation: 5,
    },
    ret:{
        color: 'green',
        marginRight: 5,
        marginBottom: 5,
        fontWeight: 'bold'
    },
    dev:{
        color: 'purple',
        marginBottom: 5,
        fontWeight: 'bold'
    },
    val:{
        fontWeight: 'bold'
    },
    imagem:{
        width: '40%',
        height: '99%'
    },
    txt:{
        marginBottom: 4,
        fontWeight: 'bold'
    },
    scroll: {
        height: '100%',
        width: '100%',
    },
    text:{
        fontSize: 20,
        color: '#c0c0c0'
    },
    card2:{
        alignSelf: 'center',
        marginTop: '70%',
        alignItems: 'center'
       
    }
})
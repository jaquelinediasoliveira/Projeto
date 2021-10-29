import {StyleSheet} from 'react-native';

export default StyleSheet.create({
    card: {
        width: '80%',
        height: '20%',
        alignItems: 'center',
        justifyContent: 'space-between',
        flexDirection: 'row',
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 15,
        marginTop: 25,
        shadowColor: "#000",
        shadowOffset: {width: 0, height: 2,},
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        elevation: 5,
        alignSelf: 'center'
    },
    ret:{
        color: 'green',
        marginRight: 5,
        marginBottom: 5,
        fontWeight: 'bold'
    },
    dev:{
        color: 'red',
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
        width: '100%'
    }
})
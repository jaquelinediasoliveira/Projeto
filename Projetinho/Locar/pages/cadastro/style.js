import {StyleSheet, StatusBar} from 'react-native';

export default StyleSheet.create({
    font: {
        fontSize: 20,
    },
    scroll: {
        height: '90%',
        width: '90%',
    },
    texto: {
        height: '10%',
        justifyContent: 'center',
        alignItems: 'center'
    },
    input: {
        width: '100%',
        height: 50,
        marginTop: '5%',
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 5,
        padding: 10,
    },
    end: {
        width: '100%',
        flexDirection: 'row',
        justifyContent: 'space-between'
    },
    city: {
        width: '72%',
        height: 50,
        marginTop: '2%',
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 5,
        padding: 10,
    },
    uf: {
        width: '25%',
        height: 50,
        marginTop: '2%',
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 5,
    },
    entrar: {
        borderRadius: 15,
        backgroundColor: '#F7EFFA',
        width: '40%',
        height: 50,
        justifyContent: 'center',
        alignItems: 'center',
        alignSelf: 'center',
        marginTop: '4%',
        marginBottom: '4%',
    }
})
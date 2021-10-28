import {StyleSheet} from 'react-native';

export default StyleSheet.create({
    card: {
        width: '70%',
        height: '15%',
        alignItems: 'center',
        justifyContent: 'space-around',
        padding: '0 15px',
        flexDirection: 'row',
        borderWidth: 1,
        borderColor: '#9932CC',
        borderRadius: 15,
        marginTop: 10,
        shadowColor: "#000",
        shadowOffset: {width: 0, height: 2,},
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        elevation: 5
    },
    ret:{
        color: 'green'
    },
    dev:{
        color: 'red'
    }
})
import {StyleSheet} from 'react-native';

export default StyleSheet.create({
    view1:{
        width: '100%',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center'
    },
    cards:{
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: 5,
        backgroundColor: '#FDFBFB',
        width: '70%',
        padding: 15,
        justifyContent: 'space-evenly',
        marginBottom: '10%',
        shadowColor: "#000",
        shadowOffset: {width: 0, height: 2,},
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        elevation: 5
    },
    tel:{
        flexDirection: 'row',
        marginBottom: '2.5%',
        marginTop: '5%'
    },
    wpp:{
        flexDirection: 'row',
        marginTop: '2.5%',
    }
})
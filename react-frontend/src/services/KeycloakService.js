import React from 'react';
import * as Keycloak from 'keycloak-js';


let initOptions = {
    url: 'http://localhost:8082',
    realm: 'MueblesStgo-MicroServices',
    clientId: 'react-app',
    onLoad: 'login-required'
}

let keycloak = Keycloak(initOptions);

keycloak.init({ onLoad: initOptions.onLoad }).success((auth) => {

    if (!auth) {
        window.location.reload();
    } else {
        console.info("Authenticated");
    }

    localStorage.setItem('bearer-token', keycloak.token);
    localStorage.setItem('refresh-token', keycloak.refreshToken);
    console.log(keycloak.token);

    setTimeout(() => {
        keycloak.updateToken(70).success((refreshed) => {
            if (refreshed) {
                console.debug('Token refreshed' + refreshed);
            } else {
                console.warn('Token not refreshed, valid for '
                    + Math.round(keycloak.tokenParsed.exp + keycloak.timeSkew - new Date().getTime() / 1000) + ' seconds');
            }
        }).error(() => {
            console.error('Failed to refresh token');
        });
    }, 60000)
}).error(() => {
    console.error("Authenticated Failed");
});


function KeycloakService() {
    return (
        <>
            
        </>

    );
}

export default KeycloakService;
import axios from "axios";

const EXTRAHOURS_URL = "http://localhost:8080/extrahours";

class ExtraHoursService {
    
    postExtraHours(extrahours){
        return axios.post(EXTRAHOURS_URL, extrahours, {headers: {Authorization: 'Bearer ' + localStorage.getItem('bearer-token')}});
    }
}

export default new ExtraHoursService()
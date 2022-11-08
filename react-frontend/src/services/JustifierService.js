import axios from "axios";

const JUSTIFIER_URL = "http://localhost:8080/justifier";

class JustifierService {
    
    postJustifier(justifier){
        return axios.post(JUSTIFIER_URL, justifier, {headers: {Authorization: 'Bearer ' + localStorage.getItem('bearer-token')}});
    }

    getJustifiers(){
        return axios.get(JUSTIFIER_URL, {headers: {Authorization: 'Bearer ' + localStorage.getItem('bearer-token')}});
    }
}

export default new JustifierService()

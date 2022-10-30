import axios from "axios";

const JUSTIFIER_URL = "http://localhost:8080/justifier";

class JustifierService {
    
    postJustifier(justifier){
        return axios.post(JUSTIFIER_URL, justifier);
    }

    getJustifiers(){
        return axios.get(JUSTIFIER_URL);
    }
}

export default new JustifierService()

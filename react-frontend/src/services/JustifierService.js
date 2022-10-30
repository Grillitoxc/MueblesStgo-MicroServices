import axios from "axios";

const JUSTIFIER_URL = "http://localhost:8080/justifier";

class JustifierService {
    
    postjustifier(justifier){
        return axios.post("http://localhost:8080/justifier", justifier);
    }
}

export default new JustifierService()

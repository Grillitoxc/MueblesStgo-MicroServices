import axios from "axios";

const SPREADSHEET_URL = "http://localhost:8080/spreadsheet";

class SpreadsheetService {

    getSpreadsheet(){
        return axios.get(SPREADSHEET_URL, {headers: {Authorization: 'Bearer ' + localStorage.getItem('bearer-token')}});
    }
}

export default new SpreadsheetService()
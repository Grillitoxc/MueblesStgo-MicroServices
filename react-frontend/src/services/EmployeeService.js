import axios from "axios";

const EMPLOYEE_URL = "http://localhost:8080/employee";

class EmployeeService {

    getEmployees(){
        return axios.get(EMPLOYEE_URL, {headers: {Authorization: 'Bearer ' + localStorage.getItem('bearer-token')}});
    }
}

export default new EmployeeService()
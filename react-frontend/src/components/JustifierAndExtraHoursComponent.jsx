import React, { Component } from 'react'
import Form from 'react-bootstrap/Form';
import EmployeeService from '../services/EmployeeService'
import JustifierService from '../services/JustifierService';

class JustifierAndExtraHoursComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            employees: []
        }
        this.justifier = {
            name: '',
            fecha: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeFechaHandler = this.changeFechaHandler.bind(this);
        this.sendJustifier = this.sendJustifier.bind(this);
    }

    changeNameHandler = (event) => {
        this.justifier.name = event.target.value;
        console.log(this.justifier.name);
    }

    changeFechaHandler = (event) => {
        this.justifier.fecha = event.target.value;
        console.log(event.target.value);
    }

    sendJustifier = (e) => {
        e.preventDefault();
        let justifierNew = {
            name: this.justifier.name,
            fecha: this.justifier.fecha
        };
        console.log('justifierNew => ' + JSON.stringify(justifierNew));
        JustifierService.postJustifier(justifierNew).then(res => {
            this.props.history.push('/justifier-and-extra-hours');
        });
    }

    componentDidMount() {
        EmployeeService.getEmployees().then((res) => {
            this.setState({ employees: res.data });
        });
    }

    render() {
        return (
            <div>
                <div className='row'>
                    <div className='card col-md-6'>
                        <h3 className='text-center'>Justificativos</h3>
                        <div className='card-body'>
                            <form>
                                <div className='form-group'>
                                    <Form.Select aria-label="Default select example" onChange={this.changeNameHandler}>
                                        <option>Seleccionar empleado</option>
                                        {
                                            this.state.employees.map(
                                                employee =>
                                                    <option value={employee.nombre} >{employee.name}</option>
                                            )
                                        }
                                    </Form.Select>
                                </div>
                                <div className='form-group'>
                                    <label>Fecha:</label>
                                    <input placeholder='Fecha del justificativo' name='fecha' className='form-control'
                                        onChange={this.changeFechaHandler} />
                                </div>
                                <button className="btn btn-success" onClick={this.sendJustifier}>Enviar Justificativos</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default JustifierAndExtraHoursComponent

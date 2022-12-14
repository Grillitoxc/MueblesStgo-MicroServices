import React, { Component } from 'react'
import Form from 'react-bootstrap/Form';
import EmployeeService from '../services/EmployeeService'
import JustifierService from '../services/JustifierService';
import CarouselComponent from './CarouselComponent'
import { Link } from 'react-router-dom'
import ExtraHoursService from '../services/ExtraHoursService';

class JustifierAndExtraHoursComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            employees: []
        }
        this.justifier = {
            name: '',
            date: ''
        }
        this.extraHours = {
            name: '',
            hours: ''
        }
        this.changeNameHandlerJ = this.changeNameHandlerJ.bind(this);
        this.changeDateHandlerJ = this.changeDateHandlerJ.bind(this);
        this.sendJustifier = this.sendJustifier.bind(this);
        this.changeNameHandlerE = this.changeNameHandlerE.bind(this);
        this.changeHoursHandlerE = this.changeHoursHandlerE.bind(this);
        this.sendExtraHours = this.sendExtraHours.bind(this);
    }

    changeNameHandlerJ = (event) => {
        this.justifier.name = event.target.value;
        console.log(this.justifier.name);
    }

    changeDateHandlerJ = (event) => {
        this.justifier.date = event.target.value;
        console.log(event.target.value);
    }

    sendJustifier = (e) => {
        e.preventDefault();
        let justifierNew = {
            name: this.justifier.name,
            date: this.justifier.date
        };
        console.log('justifierNew => ' + JSON.stringify(justifierNew));
        JustifierService.postJustifier(justifierNew).then(res => {
        });
    }

    changeNameHandlerE = (event) => {
        this.extraHours.name = event.target.value;
        console.log(this.extraHours.name);
    }

    changeHoursHandlerE = (event) => {
        this.extraHours.hours = event.target.value;
        console.log(event.target.value);
    }

    sendExtraHours = (e) => {
        e.preventDefault();
        let extraHoursNew = {
            name: this.extraHours.name,
            hours: this.extraHours.hours
        };
        console.log('extraHoursNew => ' + JSON.stringify(extraHoursNew));
        ExtraHoursService.postExtraHours(extraHoursNew).then(res => {
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
                <div className="row g-0">
                    <div className="col-lg-7 d-none d-lg-block">
                        <CarouselComponent />
                    </div>
                    <div className="col-lg-5 bg-dark d-flex flex-column align-items-end min-vh-100">
                        <div className="px-lg-5 pt-lg-4 pb-lg-3 p-4 mb-auto w-100">
                            <img src="https://i.imgur.com/cApEoul.png" alt="logo" className="img-fluid" />
                        </div>


                        <div className="align-self-center w-100 px-lg-5 py-lg-3 p-3 d-flex flex-column align-items-center">
                            <h1 className="text-center" style={{ fontSize: '2.4rem' }}>Ingresar justificativos</h1>
                            <form>
                                <label>Empleado</label>
                                <Form.Select size="lg" onChange={this.changeNameHandlerJ}>
                                    <option>Seleccionar empleado</option>
                                    {
                                        this.state.employees.map(
                                            employee =>
                                                <option value={employee.nombre} key={employee.name}>{employee.name}</option>
                                        )
                                    }
                                </Form.Select >
                                <div className="form-group">
                                    <label>Ingrese el la fecha del justificativo</label>
                                    <br />
                                    <input className='input-jh border-0' placeholder='yyyy/mm/dd' name='date'
                                        onChange={this.changeDateHandlerJ} />


                                </div>
                            </form>
                            <div className="text-center w-100 mt-2">
                                <label className="sendJustifier" onClick={this.sendJustifier}>
                                    <span className="material-symbols-outlined" style={{ fontSize: '1.8rem' }}>
                                        description
                                    </span>
                                    Ingresar justificativo
                                </label>
                            </div>
                        </div>

                        <div className="align-self-center w-100 px-lg-5 py-lg-3 p-3 d-flex flex-column align-items-center">
                            <h1 className="text-center" style={{ fontSize: '2.4rem' }}>Ingreso de horas extra</h1>
                            <form>
                                <label>Empleado</label>
                                <Form.Select size="lg" onChange={this.changeNameHandlerE}>
                                    <option>Seleccionar empleado</option>
                                    {
                                        this.state.employees.map(
                                            employee =>
                                                <option value={employee.nombre} key={employee.name}>{employee.name}</option>
                                        )
                                    }
                                </Form.Select >

                                <div className="form-group">
                                    <label>Horas extras aprobadas</label>
                                    <br />
                                    <input className='input-jh border-0' placeholder='Horas' name='date'
                                        onChange={this.changeHoursHandlerE} />
                                </div>
                            </form>
                            <div className="text-center w-100 mt-2">
                                <label className="sendJustifier" onClick={this.sendExtraHours}>
                                    <span className="material-symbols-outlined" style={{ fontSize: '1.8rem' }}>
                                        <span className="material-symbols-outlined">
                                            <span className="material-symbols-outlined" style={{ fontSize: '1.8rem' }}>
                                                schedule
                                            </span>
                                        </span>
                                    </span>
                                    Ingresar horas extra
                                </label>
                            </div>
                        </div>
                        <div className="text-center px-lg-5 pt-lg-3 pb-lg-4 p-4 mt-auto w-100">
                            <Link to="/spreadsheet" className="btn justifierandextrahours">Calcular planillas</Link>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default JustifierAndExtraHoursComponent

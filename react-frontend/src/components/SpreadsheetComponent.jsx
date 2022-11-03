import React, { Component } from 'react'
import SpreadsheetService from '../services/SpreadsheetService';



class SpreadsheetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            employees: []
        }
    }

    componentDidMount() {
        SpreadsheetService.getSpreadsheet().then((res) => {
            this.setState({ employees: res.data });
            console.log(this.state.employees);
        });
    }

    render() {
        return (
            <div className="background-img">
                <div className="container">
                    <div className="table_header">
                        <h1>Planilla de sueldos mensual</h1>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>Rut</th>
                                <th>Nombre</th>
                                <th>Categoría</th>
                                <th>Años de servicio</th>
                                <th>Sueldo fijo</th>
                                <th>Bono años</th>
                                <th>Bono horas</th>
                                <th>Monto descuentos</th>
                                <th>Sueldo bruto</th>
                                <th>Cotización previsional</th>
                                <th>Cotización salud</th>
                                <th>Sueldo final</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.employees.map(
                                    employee =>
                                        <tr key={employee.rut}>
                                            <td>{employee.rut}</td>
                                            <td>{employee.name}</td>
                                            <td>{employee.category}</td>
                                            <td>{employee.yearsOfService}</td>
                                            <td>{employee.fixedSalary}</td>
                                            <td>{employee.yearsOfServiceBonus}</td>
                                            <td>{employee.extraHoursBonus}</td>
                                            <td>{employee.discounts}</td>
                                            <td>{employee.grossSalary}</td>
                                            <td>{employee.forecastQuote}</td>
                                            <td>{employee.healthQuote}</td>
                                            <td>{employee.finalSalary}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div className="table_footer">
                        <p>MueblesStgo</p>
                    </div>
                </div>
            </div>
        )
    }
}

export default SpreadsheetComponent
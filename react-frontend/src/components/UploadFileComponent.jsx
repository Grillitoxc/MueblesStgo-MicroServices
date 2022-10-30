import React, { Component } from 'react'
import UploadService from '../services/UploadService';
import CarouselComponent from './CarouselComponent'
import { Link } from 'react-router-dom'

class UploadFileComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
        }
    }

    render() {
        return (
            <div className="row g-0">
                <div className="col-lg-7 d-none d-lg-block">
                    <CarouselComponent />
                </div>
                <div className="col-lg-5 bg-dark d-flex flex-column align-items-end min-vh-100">
                    <div className="px-lg-5 pt-lg-4 pb-lg-3 p-4 mb-auto w-100">
                        <img src="https://i.imgur.com/cApEoul.png" alt="logo" className="img-fluid" />
                    </div>
                    <div className="align-self-center w-100 px-lg-5 py-lg-4 p-4">
                        <h1 className="text-center">Subir archivos</h1>
                        <br />
                        <h4 className="text-center">El archivo debe seguir el formato establecido, donde la primera columna
                            es la fecha de la marca de reloj, la segunda columna la hora de entrada o salida y la tercera
                            columna es el rut del empleado.</h4>
                        <br />
                        <UploadService />
                    </div>

                    <div className="text-center px-lg-5 pt-lg-3 pb-lg-4 p-4 mt-auto w-100">
                        <br />
                        <Link to="/justifier-and-extra-hours" className="btn justifierandextrahours">Ingresar justificativos y horas extra</Link>
                    </div>
                </div>
            </div>
        )
    }
}

export default UploadFileComponent
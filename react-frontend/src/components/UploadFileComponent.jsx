import React, { Component } from 'react'
import UploadService from '../services/UploadService';
import CarouselComponent from './CarouselComponent'


class UploadFileComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
        }
    }

    render() {
        return (
            <div class="row g-0">
                <div class="col-lg-7 d-none d-lg-block">
                    <CarouselComponent />
                </div>
                <div class="col-lg-5 bg-dark d-flex flex-column align-items-end min-vh-100">
                    <div class="px-lg-5 pt-lg-4 pb-lg-3 p-4 mb-auto w-100">
                        <img src="https://i.imgur.com/cApEoul.png" alt="logo" class="img-fluid" />
                    </div>
                    <div class="align-self-center w-100 px-lg-5 py-lg-4 p-4">
                        <h1 class="text-center">Subir archivos</h1>
                        <h4 class="text-center">El archivo debe seguir el formato establecido, donde la primera columna
                            es la fecha de la marca de reloj, la segunda columna la hora de entrada o salida y la tercera
                            columna es el rut del empleado.</h4>
                        <UploadService />

                    </div>

                    <div class="text-center px-lg-5 pt-lg-3 pb-lg-4 p-4 mt-auto w-100">
                        <p class="d-inline-block mb-0">Ingresar justificativos y horas extras</p>
                    </div>
                </div>
            </div>
        )
    }
}

export default UploadFileComponent
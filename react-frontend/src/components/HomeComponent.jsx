import React, { Component } from 'react'
import CarouselComponent from './CarouselComponent'
import UploadFileComponent from './UploadFileComponent'

class HomeComponent extends Component {
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
                        <h1 class="text-center">Calculadora de sueldos</h1>
                        {/* Aquí va el formulario de ingreso de archivo*/}
                        <br />
                        <UploadFileComponent />
                        <br />
                        <form class="mb-5">
                            <div class="mb-4">
                                <label for="exampleInputEmail1" class="form-label font-weight-bold">Email</label>
                                <input type="email" class="form-control bg-dark-x border-0" id="exampleInputEmail1" placeholder="Ingresa tu email" aria-describedby="emailHelp" />
                            </div>
                            <div class="mb-4">
                                <label for="exampleInputPassword1" class="form-label font-weight-bold">Contraseña</label>
                                <input type="password" class="form-control bg-dark-x border-0 mb-2" placeholder="Ingresa tu contraseña" id="exampleInputPassword1" />
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Cargar archivo</button>
                        </form>
                    </div>

                    <div class="text-center px-lg-5 pt-lg-3 pb-lg-4 p-4 mt-auto w-100">
                        <p class="d-inline-block mb-0">Ingresar justificativos y horas extras</p>
                    </div>
                </div>
            </div>
        )
    }
}

export default HomeComponent

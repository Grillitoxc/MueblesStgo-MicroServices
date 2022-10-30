import React, { Component } from 'react'
import CarouselComponent from './CarouselComponent'

class HomeComponent extends Component {
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
                        <h1 className="text-center">Calculadora de sueldos</h1>
                        <form className="mb-5">
                            <div className="mb-4">
                                <label htmlFor="exampleInputEmail1" className="form-label font-weight-bold">Email</label>
                                <input type="email" className="form-control bg-dark-x border-0" id="exampleInputEmail1" placeholder="Ingresa tu email" aria-describedby="emailHelp" />
                            </div>
                            <div className="mb-4">
                                <label htmlFor="exampleInputPassword1" className="form-label font-weight-bold">Contraseña</label>
                                <input type="password" className="form-control bg-dark-x border-0 mb-2" placeholder="Ingresa tu contraseña" id="exampleInputPassword1" />
                            </div>
                            <button type="submit" className="btn btn-primary w-100">Cargar archivo</button>
                        </form>
                    </div>

                    <div className="text-center px-lg-5 pt-lg-3 pb-lg-4 p-4 mt-auto w-100">
                        <p className="d-inline-block mb-0">Ingresar justificativos y horas extras</p>
                    </div>
                </div>
            </div>
        )
    }
}

export default HomeComponent

import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div><a href="https://informatica.usach.cl" className="navbar-brand">BarrA de navbar</a></div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent

import React, { Component } from 'react'
import UploadService from '../services/UploadService';

class UploadFileComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
        }
    }

    render() {
        return (
            <div>
            <UploadService />
            </div>
        )
    }
}

export default UploadFileComponent
import React, { useState } from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';

const CLOCK_UPLOAD_API_URL = "http://localhost:8080/clock/upload";

function UploadService() {
    const [archivo, setArchivos] = useState([null]);

    const subirArchivo = (e) => {
        setArchivos(e);
    }

    const enviarArchivo = async () => {
        const f = new FormData();
        f.append("file", archivo[0]);

        await axios.post(CLOCK_UPLOAD_API_URL, f, {headers: {"Content-Type": "multipart/form-data"}}).then((response) => {
            console.log(response);
        }).catch((error) => {
            console.log(error);
        });
    }

    return (
        <div>
            <h1>Upload File Component</h1>
            <div className='Form'>
                <input type='file' name='file' onChange={(e) => { subirArchivo(e.target.files[0]) }} />
                <button onClick={enviarArchivo}>Enviar</button>
            </div>
        </div>
    );
}

export default UploadService;